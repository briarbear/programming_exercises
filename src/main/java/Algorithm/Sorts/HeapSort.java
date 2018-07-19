package Algorithm.Sorts;

/**
 * 堆排序
 * https://www.cnblogs.com/guoyaohua/p/8600214.html
 */
public class HeapSort {




    public void sort(int[] n){

        //1.构建大顶堆
        //2. 输出最大元素后，重新调整大顶堆
        for (int i = n.length-1; i >=0 ; i--) {
            adjustHeap(n,i);
            swap(n,0,i);
        }
    }


    /**
     * 调整整个大顶堆
     * @param end 最后元素的下标
     */
    public void adjustHeap(int[] n,int end){
        //从第一个非叶子节点开始
        for (int i = (end-1)/2; i >= 0 ; i--) {
            adjust(n,i,end);
        }
    }


    /**
     * 调整数组（二叉树）中某个节点的值
     * @param end 需要调整的数组最后一个元素的下标
     */
    public void adjust(int[] n,int index,int end){

        //如果有左节点，则小于左节点
        if (index*2+1 <= end && n[index] < n[2*index+1])
            swap(n,index,index*2+1);
        //如果有右节点 则小于右节点
        if (index*2+2 <= end && n[index] < n[2*index+2])
            swap(n,index,index*2+2);
    }

    /**
     * 交换数组中的两个值
     */
    public void swap(int[] n, int i, int j){
        int temp  = n[i];
        n[i] = n[j];
        n[j] = temp;
    }

}

