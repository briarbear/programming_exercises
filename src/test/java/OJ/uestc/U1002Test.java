package OJ.uestc;

import org.junit.Test;
import others.uestc.U1002;

public class U1002Test {

    @Test
    public void judge() {
        U1002 u = new U1002();
        int[] n = new int[]{8,3,3,8};

        int row = 10,col;
        int[][] n2 = new int[row][4];
        n2[0] = new int[]{1,1,2,7};
        n2[1] = new int[]{1,1,2,9};
        n2[2] = new int[]{1,1,2,7};
        n2[3] = new int[]{1,1,2,7};
        n2[4] = new int[]{1,1,2,7};
        n2[5] = new int[]{1,1,2,7};
        n2[6] = new int[]{1,1,2,7};
        n2[7] = new int[]{1,1,2,7};
        n2[8] = new int[]{1,1,2,7};
        n2[9] = new int[]{1,1,2,7};



        System.out.println(U1002.judge(n));
//        Assert.assertEquals(true,U1002.judge(n));
    }
}