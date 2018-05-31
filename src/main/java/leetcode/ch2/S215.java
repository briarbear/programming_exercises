package leetcode.ch2;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 */
public class S215 {

    public int findKthLargest(int[] nums, int k) {

        return bubbleSort(nums,k);
    }

    //考虑冒泡排序 性能略差
    public int bubbleSort(int[] nums,int k){
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < nums.length - i-1; j++) {
                if (nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        return nums[nums.length-k];
    }

    //topK问题，使用堆排序来解决
    //使用Java的PriorityQueue
    public int findKthLargest2(int[] nums,int k){
        //构建小顶推 默认就是小顶推
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);

        for (int i : nums) {
            if (heap.size() < k)
                heap.add(i);
            else {
                if (i > heap.peek()){
                    heap.poll();
                    heap.add(i);
                }
            }
        }

        return heap.peek();
    }
}
