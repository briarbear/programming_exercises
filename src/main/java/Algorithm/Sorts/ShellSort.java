package Algorithm.Sorts;

/**
 * 希尔排序，
 * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：
 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 按增量序列个数k，对序列进行k 趟排序；
 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 */
public class ShellSort {

    public int[] sort(int[] array){

        int len = array.length;
        int temp, gap = len / 2; //gpa是步长，依次间隔步长个元素，进行插入排序
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap; //取与i间隔gap前的元素，
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{26, 53, 67, 48, 57, 13, 48, 32, 60, 50};
        new ShellSort().sort(array);
    }
}
