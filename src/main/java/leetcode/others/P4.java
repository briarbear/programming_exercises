package leetcode.others;

public class P4 {

    public static void main(String[] args) {

        int[] n1 = new int[]{1,2};
        int[] n2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(n1,n2));

    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;
        int total_length = length1+length2;
        int jo = 1,mid = total_length/2+1;
        if ((total_length)%2 == 0){
            jo = 0; //总数为偶数个，中间为
            mid = total_length/2;
        }


        int i = 0,j = 0,count=0,temp = 0;
        while (true){

            if (i==length1||j==length2)
                break;

            if(nums1[i]<=nums2[j]){
                temp = nums1[i];
                count++;
                i++;
            }else {
                temp = nums2[j];
                count++;
                j++;
            }

            if (count==mid){
                if (jo==1)
                    return temp;
                else {
                    if (i==length1)
                        return (temp+nums2[j])/2.0;
                    if (j==length2)
                        return (temp+nums1[i])/2.0;
                    if (nums2[j]<=nums1[i])
                        return (temp+nums2[j])/2.0;
                    if (nums1[i]<nums2[j])
                        return (temp+nums1[i])/2.0;

                }
            }



        }

        if (i==length1){  //第一个数组遍历结束
            while (j<length2){
                temp = nums2[j];
                count++;
                j++;
                if (mid==count){
                    if (jo==1)
                        return temp/1.0;
                    else
                        return (temp+nums2[j])/2.0;
                }
            }

        }

        if (j==length2){ //第二个数值遍历结束

            while (i<length1){
                temp = nums1[i];
                count++;
                i++;
                if (mid==count){
                    if (jo==1)
                        return temp/1.0;
                    else
                        return (temp+nums1[i])/2.0;
                }
            }

        }

        return 0.0;

    }
}
