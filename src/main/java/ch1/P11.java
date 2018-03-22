package ch1;

import java.util.Arrays;

public class P11 {

    public static void main(String[] args) {

        int[] a = new int[]{1,2};

        System.out.println(maxArea(a));
    }



    public static int maxArea(int[] height){

        int max = 0,temp = 0;

        int len = height.length;
        int i =0,j = len -1;

        while (i<=j){
            temp = (j-i)*Math.min(height[i],height[j]);
            max = Math.max(max,temp);
            if (height[i]<height[j])
                i++;
            else
                j--;
        }

        return max;
    }

    //暴力破解
//    public static int maxArea(int[] height) {
//
//
//        int max = 0,temp = 0;
//        //对数组排序
//        int len = height.length;
//        for (int i = 0; i < len; i++) {
//            for (int j = i+1; j < len; j++) {
//                temp = (j-i)*Math.min(height[i],height[j]);
//                if (temp>max)
//                    max = temp;
//            }
//        }
//
//        return max;
//    }
}
