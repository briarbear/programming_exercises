package Algorithm.Sorts;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author Xbear
 */
public class BubbleSort {


    /**
     * 对数组从小到大排序
     * @param array 待排序数组
     */
    public void sort(int[] array){

        int len = array.length;
        int temp;
        for (int i = 0; i < len ; i++) {
            for (int j = 0; j < len-i-1; j++) {
                if (array[j+1]<array[j]){  //交换
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }

    }


}
