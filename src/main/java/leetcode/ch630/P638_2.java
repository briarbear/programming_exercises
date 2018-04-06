package leetcode.ch630;

import java.util.*;

public class P638_2 {


    public int shopping(List < Integer > price, List < List < Integer >> special, List < Integer > needs, Map< List < Integer > , Integer > map){

        if (map.containsKey(needs))  //如果用来记录needs约束条件下最优解的已经存在，则直接返回
            return map.get(needs);

        int j = 0,res = dot(needs,price);

        for (List<Integer> s: special){
            ArrayList<Integer> clone = new ArrayList<>(needs);
            for (  j = 0; j < needs.size(); j++) {
                int diff = clone.get(j) - s.get(j);
                if (diff < 0)
                    break;
                clone.set(j,diff);
            }

            if (j == needs.size())
                res = Math.min(res,s.get(j)+shopping(price,special,clone,map));
        }

        map.put(needs,res);
        return res;


    }


    public int dot(List < Integer > a, List < Integer > b) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> price = new ArrayList<>(Arrays.asList(1,1));

        List<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.asList(1,1,2));
        special.add(Arrays.asList(1,1,3));

        List<Integer> needs = new ArrayList<>(Arrays.asList(400,400));

        Map<List<Integer>,Integer> map = new HashMap<>();

        System.out.println(new P638_2().shopping(price, special, needs,map));

    }
}
