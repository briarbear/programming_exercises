package nowcoder;

/**
 * 青蛙跳台阶问题
 */
public class JumpStairs {

    //递归法
    public int JumpFloor(int target) {
        if (target == 0)
            return 0;
        if ( target == 1)
            return 1;
        if (target == 2)
            return 2;

        return JumpFloor(target-1) + JumpFloor(target-2);
    }

    //迭代
    public int JumpFloor2(int target) {
        if (target == 0)
            return 0;
        int[] arr = new int[10000];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < target; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[target-1];
    }

}
