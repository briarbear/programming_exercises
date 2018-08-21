package nowcoder.offer;

import java.util.HashMap;

/**
 * 数组中出现次数超过一半的数字
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @date 2018-08-20 20:22
 */
public class MoreThanHalfNum {


    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int n = 1;
            if (map.containsKey(array[i])) {
                n = map.get(array[i]);
                n++;
                map.put(array[i],n);

            }else
                map.put(array[i],1);
            if (n > length / 2)
                return array[i];
        }

        return 0;
    }

    public int solution(int[] array){
        if (array==null||array.length==0)
            return 0;
        int n = 0,count = 0;

        /**
         * 遍历数组时保存两个值，一个是数组中的一个数字，一个是次数
         * 当我们遍历到下一个数字时，如果与之前的数字相同，则次数 ＋1，如果不同，则次数 -1，如果次数为0，则重新保存新的数字
         * 最后保存的数字就是出现次数最后的数字（还需要验证）
         */
        for (int i = 0; i < array.length; i++) {
            if (count ==0){
                n = array[i];
                count++;
                continue;
            }
            if (array[i] == n)
                count++;
            else
                count--;
        }

        /**
         * 再遍历一次数组，判断是否满足
         */
        int times = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) times++;
        }
        if (times*2 > array.length)
            return n;

        return 0;
    }
}
