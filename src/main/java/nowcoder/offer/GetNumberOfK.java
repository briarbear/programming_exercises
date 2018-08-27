package nowcoder.offer;

import java.util.Arrays;

/**
 * 数字在排序数组中出现的次数
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @date 2018-08-27 20:36
 */
public class GetNumberOfK {

    public int solution(int[] array,int k){
        if (array == null || array.length == 0) return 0;
        int index = Arrays.binarySearch(array,k);
        if (index < 0)
            return 0;
        int left = index,right = index;
        while (left>=0 && array[left] == k) left--;
        while (right < array.length && array[right] == k) right++;

        return right -left - 1;
    }

    public static void main(String[] args) {
        System.out.println(new GetNumberOfK().solution(new int[]{3,3,3,3,4,5}, 3));
    }


}
