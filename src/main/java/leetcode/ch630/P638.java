package leetcode.ch630;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P638 {


    /**
     * 返回在特定needs列表下，最低的购买价格
     * @param price
     * @param special
     * @param needs
     * @return
     */
    public int shopping(List<Integer> price,List<List<Integer>> special,List<Integer> needs){

        int j = 0,res = dot(needs,price);

        for (List<Integer> s:special) {
            ArrayList<Integer> clone = new ArrayList<>(needs); //将需求列表clone

            for (j   = 0; j < needs.size(); j++) {
                int diff = clone.get(j) - s.get(j);

                if (diff < 0)
                    break;
                clone.set(j,diff);
            }

            if (j == needs.size())
                res = Math.min(res,s.get(j) + shopping(price,special,clone));
        }

        return res;
    }



    /**
     * 返回直接购买的总价格
     * @param a 需求列表
     * @param b 价格列表
     * @return 总价格
     */
    public int dot(List<Integer> a,List<Integer> b){
        int sum = 0;

        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }
        return sum;
    }


    public static void main(String[] args) {
        List<Integer> price = new ArrayList<>(Arrays.asList(2,3,4));

        List<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.asList(1,1,0,4));
        special.add(Arrays.asList(2,2,1,9));

        List<Integer> needs = new ArrayList<>(Arrays.asList(1,2,1));


        System.out.println(new P638().shopping(price, special, needs));

    }
}
