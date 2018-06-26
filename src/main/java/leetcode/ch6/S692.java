package leetcode.ch6;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

/**
 * 692. 前K个高频单词
 */
public class S692 {




    public List<String> topKFrequent(String[] words, int k) {


        List<String> ans = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i <words.length ; i++) {
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1)!=map.get(o2))
                    return map.get(o2)-map.get(o1);
                else
                    return o1.compareTo(o2);
            }
        };
        Queue<String> q = new PriorityQueue<>(com);
        for (String e:map.keySet()
                ) {
            if(q.size()<k)
                q.add(e);
            else {
                if(com.compare(e,q.peek())<=0){
                    q.poll();
                    q.add(e);
                }
            }
        }
        while (!q.isEmpty()){
            ans.add(q.peek());
            q.poll();
        }
        return ans;
    }
}
