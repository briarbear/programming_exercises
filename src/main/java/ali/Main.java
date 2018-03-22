package ali;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/



    public static void main(String[] args) {

        List<Integer> order = new ArrayList<Integer>();
        Map<String, List<Integer>> boms = new HashMap<String, List<Integer>>();

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();


        Integer n = Integer.parseInt(line.split(",")[0]);
        Integer m = Integer.parseInt(line.split(",")[1]);

        line = in.nextLine();
        String[] itemCnt = line.split(",");
        for(int i = 0; i < n ; i++){
            order.add(Integer.parseInt(itemCnt[i]));
        }

        for(int i = 0; i < m; i++){
            line = in.nextLine();
            String[] bomInput = line.split(",");
            List<Integer> bomDetail = new ArrayList<Integer>();

            for(int j = 1; j <= n; j++ ){
                bomDetail.add(Integer.parseInt(bomInput[j]));
            }
            boms.put(bomInput[0], bomDetail);
        }
        in.close();

        Map<String, Integer> res = resolve(order, boms,null);

        System.out.println("match result:");
        for(String key : res.keySet()){
            System.out.println(key+"*"+res.get(key));
        }
    }

    // write your code here
    public static Map<String, Integer> resolve(List<Integer> order, Map<String, List<Integer>> boms,Map<String,Integer> map) {

        Map<String,Integer> res = new HashMap<>(map);
        int i = 0,j = 0;

        for (i = 0; i < boms.size(); i++) {
            String bl = "bom" + i;
            List<Integer> bomlist = boms.get(bl);

            List<Integer> last = new ArrayList<>(order);
            for (j = 0; j < order.size(); j++) {
                int diff = order.get(j) - bomlist.get(j);

                if (diff < 0)
                    break;
                last.set(j,diff);
            }

            if (j == order.size()){

                if (res.containsKey(bl)){
                    res.put(bl,res.get(bl)+1);
                }else
                    res.put(bl,1);


            }

        }





        return null;

    }


    /**
     * 比较两个选择方案，如果前者由于后者，则返回1，否则返回-1，相等就返回0
     * @param order1
     * @param map1
     * @param order2
     * @param map2
     * @return
     */
    public static int compare(List<Integer> order1,Map<String,Integer> map1,List<Integer> order2,Map<String,Integer> map2){

        int count1 = 0,count2 = 0;

        for (Integer o1 :
                order1) {
            if (o1 == 0)
                count1++;
        }
        for (Integer o2 :
                order2) {
            if (o2 == 0)
                count2++;
        }



        if (count1 < count2)
            return 1;
        if (count2 > count2)
            return -1;
        if (map1.size() < map2.size())
            return 1;
        if (map1.size() > map2.size())
            return -1;
        return 0;
    }
}