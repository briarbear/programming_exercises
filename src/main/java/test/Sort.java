package test;

import java.util.Arrays;

/**
 * 排序算法复习
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @date 2018-08-23 15:06
 */
public class Sort {

    public static void main(String[] args) {

        int[] array = new int[]{6,1,4,3,7,2,8,5};

//        int[] res = mergeSort(array);
//        quickSort(array,0,array.length-1);
        heapSort(array);
        System.out.println("xiongzp08");

    }






    /**-------------------------------堆排序------------------------------------------------*/

    /**
     * 堆排序
     *
     */

    public static void heapSort(int[] array){
        int len  = array.length-1;
        for (int i = 0; i <= len; i++) {
            adjustHeap(array,len-i);
            swap(array,0,len-i);  //将堆顶的最大值，放在末尾
        }
    }

    /**
     * 调整堆--大顶堆
     * 到下标为end 结束
     */
    public static void adjustHeap(int[] array,int end){
        /**
         * 从倒数第一个非叶子节点开始调整
         */
        int stop = end/2;
        for (int i = stop; i >=0 ; i--) {
            adjust(array,i,end);
        }
    }

    /**
     * 调整第index个节点
     */
    public static void adjust(int[] array,int index,int end){

        if ((index*2+1 <= end)&&array[index*2+1] > array[index])
            swap(array,index,index*2+1);
        if ((index*2+2 <= end) && array[index*2+2] > array[index])
            swap(array,index,index*2+2);
    }
    /**
     * 交换数组元素
     */
    public static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }




    /**--------------------------------快速排序---------------------------------------------*/
    /**
     * 快速排序
     * 基于分治法的思想
     */

    public static void quickSort(int[] array,int low,int high){

        if (low < high){
            int index =  partition(array,low,high);
            quickSort(array,low,index-1);
            quickSort(array,index+1,high);
        }
    }

    /**
     * 划分操作，返回中间数 索引
     */
    public static int partition(int[] array,int low,int high){
        int temp = array[low];
        while (low < high){
            while (low < high && array[high] >= temp) high--;
            array[low] = array[high];

            while (low < high && array[low] <= temp) low++;
            array[high] = array[low];
        }
        array[low] = temp;
        return low;
    }


    /**-------------------------------归并排序----------------------------------------------*/
    /**
     * 归并排序
     * @param array 待排序数组
     * @return 新排序好的数组
     */
    public static int[] mergeSort(int[] array) {
        if (array.length < 2) return array;

        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        return merge(mergeSort(left), mergeSort(right));

    }

    /**
     * 将两个数组合并为一个新的数组
     */
    private static int[] merge(int[] left, int[] right) {
        int len = left.length + right.length;

        int[] res = new int[len];
        int j =0, k = 0;
        for (int i = 0; i < len; i++) {

            if (j == left.length){
                res[i] = right[k++];
                continue;
            }
            if (k == right.length){
                res[i] = left[j++];
                continue;
            }

            res[i] = left[j] < right[k] ? left[j++]:right[k++];
        }

        return res;
    }

    /**-------------------------------基数排序----------------------------------------------*/
    /**
     * 基数排序，
     */
}
