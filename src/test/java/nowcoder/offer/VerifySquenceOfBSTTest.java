package nowcoder.offer;

import nowcoder.offer.VerifySquenceOfBST;
import org.junit.Test;

public class VerifySquenceOfBSTTest {

    @Test
    public void sequence() {
        VerifySquenceOfBST s  = new VerifySquenceOfBST();
//        int[] nums = new int[]{1,3,2,5,7,6,4};
        int[] nums = new int[]{5,4,3,2,1};
//        int[] nums = new int[]{4,8,6,12,9,15,10};
//        int[] nums = new int[]{1};
        System.out.println(s.sequence(nums));
    }
}