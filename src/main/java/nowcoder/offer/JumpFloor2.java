package nowcoder.offer;

public class JumpFloor2 {

    //跳台阶2
    public int JumpFloorII(int target) {
        if (target == 0)
            return 0;
        int[] arr = new int[100];
        arr[0] = 1;
        arr[1] = 2;
        int sum = 3;
        for (int i  = 2; i < target; i++) {
            arr[i] = sum + 1;
            sum += arr[i];
        }

        return arr[target-1];
    }
}
