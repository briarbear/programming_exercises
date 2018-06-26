package test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
//        System.out.println(new Solution().frequencySort("fsdfsf"));
      new Solution().frequencySort("师傅的说法");
//        System.out.println(new Solution().frequencySort("eeelll111el12222ggggtttthyhyhyhy"));

    }
    public String frequencySort(String s) {
        Character[] ch = new Character[s.length()];
        for (int i = 0; i <ch.length ; i++) {
            ch[i] = s.charAt(i);
        }

        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <ch.length ; i++) {
            map.put(ch[i],map.getOrDefault(ch[i],0)+1);
        }

//        char[] chars = s.toCharArray();
//        Arrays.sort(chars);
//        for (int i = 0; i < chars.length; i++) {
//            System.out.print(chars[i]);
//        }
        Arrays.sort(ch,(o1, o2) -> {
            if(map.get(o2).compareTo(map.get(o1)) != 0)
                return map.get(o2)-map.get(o1);
            else
                return o1.compareTo(o2);
        });

        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[i]);
        }

        StringBuffer ans = new StringBuffer("");
        for (int i = 0; i <ch.length ; i++) {
            ans.append(ch[i]);
        }
//        System.out.println(ans.toString());
        return ans.toString();
    }
}
