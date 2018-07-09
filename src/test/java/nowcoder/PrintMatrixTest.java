package nowcoder;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrintMatrixTest {

    @Test
    public void print() {
        PrintMatrix s = new PrintMatrix();
        int[][] n = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        s.print(n);
        for (Integer p : s.print(n)) {
            System.out.println(p);
        };
    }
}