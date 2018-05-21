package leetcode.ch4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46 全排列
 */
public class S46 {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        force(nums,new ArrayList<Integer>(),res);
        return res;
    }

    /**
     * 方法1 暴力
     */
    public void force(int[] nums,List<Integer> cur,List<List<Integer>> res){
        if (cur.size() == nums.length){
            res.add(cur);
        }
        for (int i = 0; i < nums.length ; i++) {
            if (!cur.contains(Integer.valueOf(nums[i]))){
                List<Integer> temp = new LinkedList<>(cur);
                temp.add(Integer.valueOf(nums[i]));
                force(nums,temp,res);
            }
        }
    }
}
