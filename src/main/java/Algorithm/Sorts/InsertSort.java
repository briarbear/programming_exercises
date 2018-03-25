package Algorithm.Sorts;

/**
 * 插入排序，
 * 假设前序元素已有序，则从紧接着后面的第一个元素依次向前比较，直到找到比他小的（或者相等）则停止
 * @author Xbear
 */
public class InsertSort {

    public int[] sort(int[] array){
        int len = array.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (array[j]<array[j-1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    continue;
                }

                break;
            }
        }
        return array;
    }

    public int[] sort2(int[] array){
        if (array.length == 0)
            return array;

        int current;  //拿出来待插入的元素
        for (int i = 0; i < array.length-1; i++) {
            current = array[i+1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]){
                array[preIndex+1] = array[preIndex];
                preIndex--;
            }
            array[preIndex+1] = current;

        }

        return array;
    }

    public static void main(String[] args) {
        int[] n = {1, 2, 4, 6, 9, 3, 5};
//        int[] n = {1};
        new InsertSort().sort2(n);
        for (int x :
                n) {
            System.out.print(x + " ");
        }
    }
}
