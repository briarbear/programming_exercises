package Algorithm.Sorts;

/**
 * 测试排序算法类
 * https://www.cnblogs.com/guoyaohua/p/8600214.html
 */
public class Test {
    public static void main(String[] args) {
        int[] array = new int[]{1,7,3,4,9,2,5,5};
        new RadixSort().sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
