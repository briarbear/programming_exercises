package test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 测试
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @date 2018-08-25 14:00
 */
public class T8 {

    public static void main(String[] args) {
        int[] array = {1,2,3,5,6,7,8};
        System.out.println(binarySearch(array, 0, 7, 4));
        System.out.println(binarySearch2(array, 0, 7, 4));
        HashMap map = new HashMap();
        ArrayList<Integer> list = new ArrayList<>();
    }

    public static int binarySearch(int[] dp,int start,int end,int n){
        while (start < end){
            int mid = (start + end) / 2;
            if (dp[mid] == n) return mid;
            if (dp[mid] > n)
                end = mid -1;
            else
                start = mid +1;
        }

        return start;
    }

    public static int binarySearch2(int[] dp,int start,int end,int num){

        while(start < end){
            int mid = start + (end - start) / 2;
            if(dp[mid] == num) return mid;
            if(dp[mid] > num)
                end  = mid;
            else
                start = mid + 1;
        }

        return start;
    }
}
