package Algorithm.Sorts;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author Xbear
 */
public class bubbleSort {


    /**
     * 对数组从小到大排序
     * @param array
     * @return
     */
    public int[] sort(int[] array){

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

        return array;


    }

    public static void main(String[] args) {
        int[] n = {1,2,4,6,9,3,5};
        new bubbleSort().sort(n);
        for (int x :
                n) {
            System.out.println(x);
        }

        String[] array = {"a", "b", "c", "d", "e"};
        Arrays.asList(array).stream().forEach(x -> System.out.println(x));
    }
}
