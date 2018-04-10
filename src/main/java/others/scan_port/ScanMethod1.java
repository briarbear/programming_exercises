package others.scan_port;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 实现Runnable接口
 * http://blog.51cto.com/983836259/1727023
 */
public class ScanMethod1 implements Runnable{

    private String ip;  //目标ip
    private int startPort,endPort,threadNumber,serial,timeout;//起始端口

    public ScanMethod1() {

    }

    public ScanMethod1(String ip, int startPort, int endPort, int threadNumber, int serial, int timeout) {
        this.ip = ip;
        this.startPort = startPort;
        this.endPort = endPort;
        this.threadNumber = threadNumber;
        this.serial = serial;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        int port = 0;
        try {
            InetAddress address = InetAddress.getByName(ip);
            Socket socket;
            SocketAddress socketAddress;
            for (port = startPort+serial; port <=endPort ; port += threadNumber) {
                socket = new Socket();
                socketAddress = new InetSocketAddress(address,port);

                try {
                    socket.connect(socketAddress,timeout);
                    socket.close();
                    System.out.println("端口" + port + ":开放");
                } catch (IOException e) {
//                    e.printStackTrace();
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    /**
     * 多线程扫描目标主机一个段的端口开放情况
     * @param ip 目标ip或域名
     * @param startPort 开始端口
     * @param endPort 结束端口
     * @param threadNumber 线程数
     * @param timeout 超时时间
     */
    public void scanLargePorts(String ip,int startPort,int endPort,int threadNumber,int timeout){
        ExecutorService threadPool = Executors.newCachedThreadPool();  //线程池
        for (int i = 0; i < threadNumber; i++) {
            ScanMethod1 scanMethod1 = new ScanMethod1(ip,startPort,endPort,threadNumber,i,timeout);
            threadPool.execute(scanMethod1);
        }

        threadPool.shutdown();

        //每秒查看一次是否扫描结束
        while (true){
            if (threadPool.isTerminated()){
                System.out.println("扫描结束");
                break;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }



    }
}
