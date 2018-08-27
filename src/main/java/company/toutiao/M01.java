package company.toutiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 头条 面试题1
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @date 2018-08-27 13:18
 */
public class M01 {
    public static void main(String[] args) {

        int[] array = {2, -1, 1, 2, 19, 30, 20};
        ArrayList<ArrayList<Integer>> res = helper2(array,21);
        res.stream().forEach(( list -> {
            System.out.println(list.get(0) + " " + list.get(1));
        }));
    }


    public static ArrayList<ArrayList<Integer>> helper(int[] array,int target){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (array == null || array.length < 2)
            return res;

        /**
         * 1. 保存数组元素的下标到map中去
         */
        int len = array.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> link = map.get(array[i]);
            if (link == null){
                    link = new ArrayList<>();
                    link.add(i);
                    map.put(array[i],link);
            }else {
                link.add(i);
                map.put(array[i],link);
            }
        }
        /**
         * 2. 对数组排序
         */
        Arrays.sort(array);

        /**
         * 3。遍历数组
         */

        int left = 0,right = len - 1;

        while (left < right){
            int sum = array[left] + array[right];

            if (sum == target){
                if (array[left] == array[right]){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(map.get(array[left]).get(0));
                    list.add(map.get(array[left]).get(1));
                    if (map.get(array[left]).size() > 1)
                        map.get(array[left]).remove(0);
                    if (map.get(array[right]).size() > 1)
                        map.get(array[right]).remove(0);
                    res.add(list);
                    left++;
                    continue;
                }else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(map.get(array[left]).get(0));
                    list.add(map.get(array[right]).get(0));
                    if (map.get(array[left]).size() > 1)
                        map.get(array[left]).remove(0);
                    if (map.get(array[right]).size() > 1)
                        map.get(array[right]).remove(0);
                    res.add(list);
                    left++;
                    continue;
                }
            }

            if (sum > target)
                right--;
            else
                left++;
        }
        return res;

    }

    /**
     * 更高效 简洁
     */
    public static ArrayList<ArrayList<Integer>> helper2(int[] array,int target){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(target-array[i])){
                for (Integer t : map.get(target - array[i])) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(t);
                    list.add(i);
                    res.add(list);
                }
            }
            ArrayList<Integer> link = map.get(array[i]);
            if (link == null)
                 link = new ArrayList<>();
            link.add(i);

            map.put(array[i],link);
        }

        return res;
    }
}
