package nowcoder;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReOrderArrayTest {

    @Test
    public void reOrder() {
        var s  =  new ReOrderArray();
        int[] n = new int[]{1,2,3,4,5,6,7,8};
        s.reOrder(n);
    }
}