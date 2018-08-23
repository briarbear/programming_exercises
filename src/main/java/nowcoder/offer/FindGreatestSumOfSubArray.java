package nowcoder.offer;

import java.util.Arrays;

/**
 * 连续子数组的最小和
 *
 * @author briarbear
 * @blog http://briarbear.github.io
 * @create 2018-08-22-20:49
 */
public class FindGreatestSumOfSubArray {

    /**
     * 类似双指针方案解决
     * O(n)的复杂度
     */
    public int solution(int[] array) {

        if(array == null || array.length == 0) return 0;

        int sum = array[0],max = array[0];
        for(int i = 1;i < array.length;i++){
            if(sum < 0) //如果和小于0 就用新的数替换
                sum = array[i];
            else
                sum += array[i];
            if(sum > max) max = sum;
        }


        return max;
    }

    /**
     * 动态规划 dp[i]表示 以第i个数字结尾的子数组的最大和
     * @param array
     * @return
     */
    public int solution2(int[] array){

        int[] dp = new int[array.length];
        System.arraycopy(array,0,dp,0,array.length);

        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i-1]+array[i],array[i]);
        }

        return Arrays.stream(dp).max().getAsInt();  //使用jdk8的stream流
    }
}
