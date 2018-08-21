package nowcoder.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小的k个数
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @date 2018-08-21 12:00
 */
public class GetLeastNumbers {

    /**
     * 考虑用优先队列解决
     * 复杂度O(nlogn)
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input ==null || input.length == 0 || input.length < k || k==0) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        //构建大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k,((o1, o2) -> o2 - o1));

        for (int i = 0; i < input.length; i++) {
            if (queue.size() < k)
                queue.add(input[i]);
            else{
                if (input[i] < queue.peek()){ //如果小于堆顶元素
                    queue.poll();
                    queue.add(input[i]);
                }
            }

        }

        while (!queue.isEmpty()){
            res.add(queue.poll());
        }

        return res;
    }

    /**
     * 基于Partition函数的O(n)的复杂度
     * 快速排序的思想
     */
    public ArrayList<Integer> solution(int[] input,int k){
        if (input ==null || input.length == 0 || input.length < k || k==0) {
            return new ArrayList<Integer>();
        }
        int start = 0,end = input.length-1;
        int index = partition(input,start,end);
        while (index != k-1){
            if (index > k-1){
                end = index - 1;
                index = partition(input,start,end);
            }else {
                start = index +1;
                index = partition(input,start,end);
            }
        }

        //输出前k个数
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }

        return res;
    }

    /**
     * 在数组的start-end范围类，进行一次快排的操作
     * 返回中间数的下标
     */
    public int partition(int[] array,int start,int end){
        int temp = array[start];
        int i = start,j = end;
        while (i < j){
            while (i < j && array[j] > temp) j--;
            array[i] = array[j]; //将小于temp的数交换到地位来

            while (i<j && array[i] < temp) i++;
            array[j] = array[i];
        }
        array[i] = temp;
        return i;
    }
}
