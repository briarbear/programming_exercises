package others.scan_port;

import java.util.HashMap;

public class Test1 {
    public static void main(String[] args) {
        ScanMethod1 scanMethod1 = new ScanMethod1();
        scanMethod1.scanLargePorts("ld-5.atss.ga",1,100000,10,20000);

    }
}
