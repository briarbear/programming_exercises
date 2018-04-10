package others.scan_port;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 扫描指定ip的特定范围的端口，并以ip名保存下来
 */
public class PortsThread implements Runnable {
    private String ip = null;
    private CountDownLatch threadsSingle;

    public PortsThread(String ip, CountDownLatch threadsSingle) {
        this.ip = ip;
        this.threadsSingle = threadsSingle;
    }

    public CountDownLatch getThreadsSingle() {
        return threadsSingle;
    }

    @Override
    public void run() {
        String cmdPorts = "nmap -sT " + ip + " -p 1000-65535 -oX ports/" + ip + ".xml";

        Process pro = null;
        try {
            pro = Runtime.getRuntime().exec(cmdPorts);
            pro.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //通知机制
        threadsSingle.countDown();  //其他的线程通过CountDownLatch.countDown()方法来完成
        System.out.println(cmdPorts + "\t" +threadsSingle.getCount());
    }

}
