package others.scan_port;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 参考格格（王中晴）的扫描，使用nmap扫描生成xml，xml包含所有主机ip，然后解析该xml文件，得到ipList,
 * 然后再根据ip，使用多线程扫描（nmap）开发端口.
 */
public class GetAllPortsXml {

    /**
     * 解析特定ip的xml文件，得到Result对象，包含ip以及开放端口列表
     * @return
     */
    public List<Result> getResult() {
        List<Result> resultList = new ArrayList<Result>();

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        List<String> ipList = new GetAllIp().getAllIp();
        int len = ipList.size();

        for (int i = 0; i < len; i++) {
            String xmlFilePath = "./ports/"+ipList.get(i)+".xml";
            DocumentBuilder documentBuilder;
            try {
                documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.parse(xmlFilePath);
                NodeList portList = document.getElementsByTagName("port");
                int portListLength = portList.getLength();
                List<String> ports = new ArrayList<String>();
                for (int k = 0; k < portListLength; k++) {
                    System.out.print(portList.item(k).getAttributes().item(0).getNodeValue()+" ");
                    ports.add(portList.item(k).getAttributes().item(0).getNodeValue());
                }
                System.out.println();
                Result result = new Result();
                result.setIp(ipList.get(i));
                result.setPorts(ports);
                resultList.add(result);
            } catch (ParserConfigurationException | SAXException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "start----------------------->");
        List<String> ipList = new ArrayList<>();
        ipList.add("10.59.12.1");
        ipList.add("10.59.12.2");
        int len = ipList.size();
        CountDownLatch threadSingle = new CountDownLatch(len);   //线程数量

        for (int i = 0; i < len; i++) {
            PortsThread portsThread = new PortsThread(ipList.get(i),threadSingle);  //传入参数为主线程
            Thread thread = new Thread(portsThread);  //创建线程的方式1，portsThread继承Threa，重写run方法，然后在外部执行thread启动
            thread.start();
        }

        try {
            threadSingle.await(30L, TimeUnit.SECONDS);  //在启动其他线程后，立即调用.await()方法，这样主线程的操作会阻塞，直到其他线程完成各自任务
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //每隔一秒检查
        while (true){
            if (threadSingle.getCount() == 0)
                break;
            try {
                Thread.sleep(1000);  //间隔一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        GetAllPortsXml allPortsXml = new GetAllPortsXml();
        List<Result> resultsList = new ArrayList<Result>();
        resultsList = allPortsXml.getResult();
        for (Result result : resultsList) {
            System.out.println(result.toString());
        }
        String url = null;
        for (Result result : resultsList) {
            for (int i = 0; i < result.getPorts().size(); i++) {
                url= "http://"+result.getIp()+":"+result.getPorts().get(i)+"/webhdfs/v1/?op=LISTSTATUS";
                System.out.println(url);
                if (new Json().isConnect(url)) {  //将获得的结果 用json解析
                    System.out.println(url);
//					System.out.println(result.getIp()+":" +result.getPorts().get(i));
//					System.out.println(new Json().loadJson(url));
                    new Json().parseJson(new Json().loadJson(url));
                }
            }
        }

    }
}
