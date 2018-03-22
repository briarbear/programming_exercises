package ch1;

import java.util.*;

public class P15 {

    public static void main(String[] args) {


        int[] nums = new int[]{-4,-1,-1,0,1,2};
        System.out.println(threeSum4(nums));
    }


    /**
     * 暴力破解，运行超时
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums){

        if (nums.length == 0)
            return new ArrayList<>();

        //对数组重排序
        Arrays.sort(nums);
        int m,n,l;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            m = nums[i];
            for (int j = i+1; j < nums.length-1; j++) {
                n = nums[j];
                for (int k = j+1; k < nums.length; k++) {
                    l = nums[k];
                    if (m+n+l == 0){
                        temp.add(m);
                        temp.add(n);
                        temp.add(l);
                        if (!result.contains(temp)){
                            List<Integer> list = new ArrayList<>();
                            list.addAll(temp);
                            result.add(list);
                        }
                        temp.clear();
                    }

                }
            }
        }


        return result;
    }

    /**
     * 有一定优化，但不够，仍然运行超时
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums){

        if (nums.length == 0)
            return new ArrayList<>();

        //对数组重排序
        Arrays.sort(nums);
        int mid = 0;
        //找到正负数分隔处
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>=0){
                mid = i;
                break;
            }
        }
        int m,n,l,max = nums[nums.length-1];
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i <= mid; i++) {
            m = nums[i];
            if (m>0)
                break;
            for (int j = i+1; j < nums.length-1; j++) {
                n = nums[j];
                int k;
                if (m+n<=0){
                    k = mid>j?mid:j+1;

                }else{
                    break;
                }

                for (; k < nums.length; k++) {
                    l = nums[k];
                    if (m+n+l == 0){
                        temp.add(m);
                        temp.add(n);
                        temp.add(l);
                        if (!result.contains(temp)){
                            List<Integer> list = new ArrayList<>();
                            list.addAll(temp);
                            result.add(list);
                        }
                        temp.clear();
                    }

                }
            }
        }


        return result;

    }

    public static List<List<Integer>> threeSum3(int[] nums){

        if (nums.length == 0)
            return new ArrayList<>();

        //重排序
        Arrays.sort(nums);

        int left = 0,right = nums.length-1;
        int mid = (left+right)/2;
        int l,m,r;
        List<List<Integer>> result = new ArrayList<>();

        for (; left < mid; left++) {
            l = nums[left];right = nums.length-1;mid = left + 1;
            while (mid < right){

                m = nums[mid];r = nums[right];

                if (r < 0)
                    break;

                if (l+m+r<0){
                    mid++;
                    continue;
                }
                if (l+m+r > 0){
                    right--;
                    continue;
                }
                if (l+m+r == 0){

                    result.add(Arrays.asList(l,m,r));

                    mid++;
                }

            }
        }






        return result;
    }


    public static List<List<Integer>> threeSum4(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int lo = i+1, hi = nums.length-1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
}
