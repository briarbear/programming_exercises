package Algorithm.Sorts;

/**
 * 选择排序
 * @author Xbear
 */
public class selectionSort {


    /**
     * 从小到大排序 每次从后续的元素中找到最小的一个，放到前面
     * @param array
     * @return
     */
    public int[] sort(int[] array){

        int min,len = array.length,pos;
        for (int i = 0; i < len-1; i++) {
            min = array[i];
            pos = i;
            for (int j = i+1 ; j < len; j++) {
                if (array[j]<min){
                    min = array[j];
                    pos = j;
                }
            }
            if (pos!=i){
                //交换array[i] array[pos]
                int temp = array[i];
                array[i] = array[pos];
                array[pos] = temp;
            }
        }


        return array;
    }
    public static void main(String[] args) {
        int[] n = {1, 2, 4, 6, 9, 3, 5};
        new selectionSort().sort(n);
        for (int x :
                n) {
            System.out.print(x + " ");
        }
    }
}
