package Algorithm.Sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 快速排序
 *http://www.cnblogs.com/guoyaohua/p/8600214.html
 */
public class QuickSort {


    public void quicksort(int[] array,int low,int high){

        if (low<high){
            int pivotLoc = partition(array,low,high);
            quicksort(array,low,pivotLoc-1);
            quicksort(array,pivotLoc+1,high);
        }
    }

    /**
     * 交换数组中的元素，并最后返回枢纽元素的位置
     * @param n
     * @param low
     * @param high
     * @return
     */
    public int partition(int[] n,int low,int high){

        int temp = n[low];
        while (low<high){

            while (low<high&&n[high]>=temp)  //右侧游标一直往左移，直到找到比temp小的，就停下来进行交换
                high--;
            n[low] = n[high];

            while (low<high&&n[low]<=temp)  //现在该左侧游标一直往右走，直到找到比temp大的，就停下来，交换
                low++;
            n[high] = n[low];
        }

        n[low] = temp;
        return low;

    }


    public static void main(String[] args) {
        int[] n = {1, 2, 4, 6, 9, 3, 5};
        new QuickSort().quicksort(n,0,n.length-1);
        for (int x :
                n) {
            System.out.print(x+" ");
        }
        String[] list = {"a","b","c"};
        Arrays.asList(list).stream().forEach(x -> System.out.println(x));
    }
}
