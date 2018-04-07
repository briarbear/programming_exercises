package leetcode.ch4;

import java.util.*;

/**
 * 49. Group Anagrams 字谜分组
 */
public class S49 {

    //1. 用hashmap存储，关键字为字符串的排序后的
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {   //遍历字符串数组

            char[] chars = str.toCharArray();   //先转化为字符数组
            Arrays.sort(chars);                 //然后排序
            String temp = new String(chars);    //再转变为字符串
            if (!map.containsKey(temp)){        //判断hashmap中是否包含这个字符串
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(temp,list);
            }else {
                map.get(temp).add(str);
            }
        }

        for (List<String> stringList : map.values()) {
            res.add(stringList);
        }
        return res;
    }

    //2. leetcode官方solution1

    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }


    //3. leetcode运行时间最短的实例
    public List<List<String>> groupAnagrams4(String[] strs) {
        HashMap<Key,List<String>> map = new HashMap<Key,List<String>>();
        for(String s:strs)
        {
            Key key = new Key(s);
            List<String> l = map.get(key);
            if(l==null)
            {
                l = new ArrayList<String>();
                map.put(key, l);
            }
            l.add(s);
        }
        List<List<String>> rs = new ArrayList<List<String>>(map.size());
        rs.addAll(map.values());
        return rs;
    }

    private static final class Key{
        int[] refs = new int[26];
        int h;

        public Key(String s) {
            for (int i = 0; i < s.length() ; i++) {
                refs[s.charAt(i)-'a']++;  //记录数组中相应位置字符出现的次数
            }
            h = 0;
            for (int ref : refs) {
                h = h*31 + ref;  //为何选择31 ，很奇怪，
            }
        }

        @Override
        public int hashCode() {
            return h;
        }

        @Override
        public boolean equals(Object obj) {
            int[] refs1 = ((Key)obj).refs;
            for(int i=0;i<refs1.length;i++)
            {
                if(refs1[i] != refs[i])
                    return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = new S49().groupAnagrams2(strings);
        for (List<String> list : res) {
            System.out.println(list);
        }
    }
}
