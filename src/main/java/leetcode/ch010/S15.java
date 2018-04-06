package leetcode.ch010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15 3sum 三数之和
 */
public class S15 {

    //1. 暴力求解 运行超时
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i+1; j < len - 1; j++) {
                if (nums[i]+nums[j] >0)
                    break;
                for (int k = j+1; k < len; k++) {
                    if (nums[i]+nums[j]+nums[k] > 0)
                        break;
                    if (nums[i]+nums[j]+nums[k] == 0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        if (!res.contains(temp))
                            res.add(temp);
                    }

                }
            }
        }


        return res;
    }

    //2. leetcode提交答案
    public List<List<Integer>> threeSum2(int[] nums) {
        //1.对数组排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            //2. 固定第一个元素，问题转化为求两个数的和
            if (i==0||(i>0 && nums[i] != nums[i-1])){  //跳过第一个元素选择了重复的情况
                int left = i + 1, right = len - 1, sum = 0 - nums[i];

                while (left < right){
                    if (nums[left] + nums[right] == sum){
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        //3. 匹配到一个结果后，两端游标分别移动，过掉重复元素
                        while (left < right && nums[left] == nums[left+1]) left++;
                        while (left < right && nums[right] == nums[right-1]) right--;
                        left++;right--;
                    }else{
                        if (nums[left] + nums[right] < sum){
                            while (left < right && nums[left] == nums[left+1]) left++; //同样 ，跳过重复元素
                            left++;
                        }
                        else{
                            while (left < right && nums[right] == nums[right-1]) right--;
                            right--;
                        }
                    }
                }
            }

        }

        return res;
    }


    //3.



    public static void main(String[] args) {

        int[] S = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = new S15().threeSum2(S);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
