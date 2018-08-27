package nowcoder.offer;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @date 2018-08-27 14:43
 */
public class PrintMinNumber {

    public String solution(int[] numbers){
        String res = "";
        if (numbers == null || numbers.length == 0) return res;

        /**
         * 按照自定义的排序 对数组排序
         */
        sort(numbers);
        for (int i : numbers) {
            res += i;
        }

        return res;
    }

    /**
     * 自定义比较器
     * 大于返回 ture
     */
    public boolean compare(int a,int b){

       String s1 = "" + a + b;
       String s2 = "" + b + a;

       if (s1.compareTo(s2) > 0)
           return true;
       else
           return false;
    }

    /**
     * 冒泡排
     * @param array
     * @return
     */
    public void sort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if (compare(array[j],array[j+1])){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new PrintMinNumber().solution(new int[]{3, 32, 321}));
    }
}
