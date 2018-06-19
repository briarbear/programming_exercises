package leetcode.ch4;

import java.util.*;

public class S451 {

    public String frequencySort(String s) {

        //1. 存储到char数组中
        char[] chars = s.toCharArray();
        int[] set = new int[128];
        StringBuilder res = new StringBuilder();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
                set[chars[i]]++;

        }
        for (int i = 0; i < 128; list.add(i),i++);

        //2. 排序
        list.sort((x,y) -> set[(int)y] - set[(int)x]);

        //3. 输出
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int key = iterator.next();
            int val = set[key];
            if (val==0)
                break;
            while (val-->0){
                res.append(String.valueOf((char)key));

            }
        }


        return res.toString();
    }

    /**
     * 使用Treemap排序
     * @param s
     * @return
     */
    public String frequencySort2(String s) {

        // 1. 保存频率到数组中
        int freq[] = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }


        List<String> list = new ArrayList<>();
        // 2. 使用Treemap排序
        TreeMap<Integer,String> map = new TreeMap<>();
        for (int i = 0; i < 128; i++) {
            if (freq[i] == 0) continue;
            //取到i处的字符,
            //这行代码的意义其实不大,等同于sb = "";
            StringBuilder sb = new StringBuilder(map.getOrDefault(-freq[i],""));
            for (int j = 0; j < freq[i]; j++)
                sb.append((char)i);

            //这里完成逆序排序
            map.put(-freq[i],sb.toString());
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Integer> iter = map.keySet().iterator();
        while (iter.hasNext()){
            Integer key = iter.next();
            sb.append(map.get(key));
        }

        return sb.toString();
    }

}
