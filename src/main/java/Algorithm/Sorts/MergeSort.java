package Algorithm.Sorts;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {


    private int[] sort(int[] array){

        if (array.length < 2) return array;

        int mid =  array.length/2; //取中间位置
        int[]  left = Arrays.copyOfRange(array,0,mid);  //将0到mid位置的数组复制到left数组 这是重新建立的数组
        int[]  right = Arrays.copyOfRange(array,mid, array.length);  //将0到mid位置的数组复制到left数组

        return merge(sort(left),sort(right));  //注意递归的思想
    }


    private int[] merge(int[] left,int[] right){
        int[] result = new int[left.length+right.length];
        for (int i = 0,j = 0,index = 0;index<result.length;index++){
            if (i >= left.length){
                result[index] = right[j++];
                continue;
            }
            if (j >= right.length){
                result[index] = left[i++];
                continue;
            }

            if (left[i]<=right[j])
                result[index] = left[i++];
            else
                result[index] = right[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] n = {1, 2, 4, 6, 9, 3, 5};
        int[] result = new MergeSort().sort(n); //用新数组来保存，有递归的过程中，操作的已经不是原来的数组了，即原数组元素没有发生变化
        for (int x :
                result) {
            System.out.print(x + " ");
        }
    }
}
