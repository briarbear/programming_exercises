package leetcode.ch7;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 78. 子集
 */
public class S78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        handle(nums,new ArrayList<>(),0,res);
        return res;
    }


    /**
     * 回溯法
     */
    public void handle(int[] nums,List<Integer> cur,int level,List<List<Integer>> res){

        res.add(new ArrayList<>(cur));

        for (int i = level ; i < nums.length; i++) {

            cur.add(nums[i]);
            int len = cur.size();
            //恢复现场
            handle(nums,cur,i+1,res);
            cur.remove(len-1);
        }

    }
}
