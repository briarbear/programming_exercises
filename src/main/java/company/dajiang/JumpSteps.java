package company.dajiang;

/**
 * 跳青蛙
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @create 2018-07-08-20:19
 */
public class JumpSteps {

    public static void main(String[] args) {
        int[] n  = new int[]{2,3,1,1,4};
        System.out.println(fun3(n));
    }

    public static  int fun3(int[] nums1) {
        int jump = 0;
        int cur = 0;
        int next = 0;

        for (int i = 0; i < nums1.length; i++) {
            if (cur < i) {
                jump++;
                cur = next;
            }
            next = Math.max(next, nums1[i] + i);
        }

        return jump;
    }
}
