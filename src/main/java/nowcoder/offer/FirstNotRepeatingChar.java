package nowcoder.offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 第一次只出现一次的字符
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @date 2018-08-27 16:57
 */
public class FirstNotRepeatingChar {

    public int solution(String str){
        LinkedHashMap<Character,Integer> map  = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))){
                int count = map.get(str.charAt(i));
                map.put(str.charAt(i),count+1);
            }else
                map.put(str.charAt(i),1);
        }

        int res = -1;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int temp = entry.getValue();
            if (temp == 1){
                res = str.indexOf(entry.getKey());
                break;
            }
        }

        return res;
    }

    /**
     * 采用ascii码作为hash表
     */
    public int solution2(String str){
        int[] hash = new int[256];
        /**
         * 将出现的情况存储到hash表中
         */
        for (int i = 0; i < str.length(); i++) {
            hash[str.charAt(i)]++;
        }

        /**
         * 再遍历原字符串
         */
        for (int i = 0; i < str.length(); i++) {
            if (hash[str.charAt(i)] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        new FirstNotRepeatingChar().solution("google");
    }
}
