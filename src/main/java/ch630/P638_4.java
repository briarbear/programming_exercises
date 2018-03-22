package ch630;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P638_4 {


    public static void main(String[] args) {
        List<Integer> price = new ArrayList<>(Arrays.asList(2,5));

        List<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.asList(3,0,5));
        special.add(Arrays.asList(1,2,10));

        List<Integer> needs = new ArrayList<>(Arrays.asList(3,2));


        System.out.println(new P638_4().shoppingOffers(price, special, needs));
    }


    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

        return shopping(price,special,needs,0);
    }


    //递归 + 记忆化
    public int shopping(List<Integer> price,List<List<Integer>> special,List<Integer> needs,int pos){
        int res = directPurchase(price,needs);
        
        for (int i = pos; i < special.size(); i++) {
            List<Integer> clone =  new ArrayList<>();
            List<Integer> temp = special.get(i);
            for (int j = 0; j < temp.size()-1; j++) {
                if (temp.get(j) > needs.get(j)){
                    clone = null;
                    break;
                }
                clone.add(needs.get(j) - temp.get(j));
            }

            if (clone != null){
                //实现对第一个方案的依次遍历结束，
                res = Math.min(res,temp.get(temp.size()-1) + shopping(price,special,clone,i));
            }


        }

        return res;

    }


    //直接购买价格
    public int directPurchase(List<Integer> price,List<Integer> needs){
        int sumPrice = 0;
        for (int i = 0; i < price.size(); i++) {
            sumPrice += price.get(i) * needs.get(i);
        }

        return sumPrice;
    }

}
