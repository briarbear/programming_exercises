package leetcode.ch4;

import java.util.*;

/**
 * 46 全排列
 */
public class S46 {



    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
//        force(nums,new ArrayList<Integer>(),res);
        int[] visited = new int[nums.length];
        backtracking(nums,new ArrayList<Integer>(),res,visited);

        return res;
    }

    /**
     * 方法1 深度搜索 暴力求解
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

    /**
     * 回溯解决
     */
    public void backtracking(int[] nums,List<Integer> cur,List<List<Integer>> res,int[] visited){
        if (cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0){ //没有访问过
                visited[i] = 1;
                cur.add(nums[i]);
                int len = cur.size();
                backtracking(nums,cur,res,visited);

                //恢复现场
                cur.remove(len-1);
                visited[i]=0;
            }
        }
    }
}
