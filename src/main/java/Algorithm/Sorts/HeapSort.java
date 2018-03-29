package Algorithm.Sorts;

/**
 * 堆排序
 * https://www.cnblogs.com/guoyaohua/p/8600214.html
 */
public class HeapSort {


    private int len;  //记录数组长度

    public void sort(int[] n){
        len = n.length;
        if (len <= 1) return;
        //1.构建一个最大堆
        buildMaxHeap(n);
        //2.循环将堆的首位（最大值）与末位相交换
        while (len>0){
            swap(n,0,len-1);
            len--;
            adjustHeap(n,0);  //只调整最上面的一个，因为构建大堆的过程中，已经保证了父节点必定大于子节点数值，则肯定倒数第二大的就在第二排
        }

    }
    /**
     * 构建最大堆
     * @param n 数组
     */
    private void buildMaxHeap(int[] n){

//        len = n.length;
        for (int i = (len-1)/2; i >=0 ; i--) {
            adjustHeap(n,i); //从最后一个非叶子节点开始向上构造最大堆
        }
    }

    private void adjustHeap(int[] n,int i){

        int maxIndex = i; //maxIndex指向最大数组的游标
        //如果有左子树，且左子树节点大于父节点，则更新maxIndex
        if (i*2+1<len && n[i*2+1]>n[i])
            maxIndex = i*2+1;
        //如果有右子树，且右子树节点大于父节点，且大于左子树节点
        if ((i+1)*2<len){//有右子树
            if (n[i*2+2]>n[i]&&n[i*2+2]>n[i*2+1])
                maxIndex = i*2+2;
        }

        if (maxIndex != i)
            swap(n,i,maxIndex);
    }

    //交换数组内两个元素
    private  void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}

