package leetcode.ch7;

/**
 * 75 分类颜色
 */
public class S75 {


    public void sortColors(int[] nums) {
//        bubbleSort(nums);
//        countingSort(nums);
        sort(nums);
    }


    /**
     * 计数排序
     */

    public void countingSort(int[] nums){
        //1. 建立数组
        int[] temp = new int[3];
        //2. 遍历原数组
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]){
                case 0:temp[0]++;break;
                case 1:temp[1]++;break;
                case 2:temp[2]++;break;
            }
        }
        //3. 输出临时数组
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (temp[count] == 0){
                count++;
                i--;
            }else {
                nums[i] = count;
                temp[count]--;
            }
        }

    }


    /**
     * 冒泡排序
     * @param nums
     */
    public void bubbleSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if (nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    /**
     * 双指针
     */
    public void sort(int[] nums){
        int red = 0,blue = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0 && i>=red){
                //和red指向的位置，交换
                int temp = nums[red];
                nums[red] = nums[i];
                nums[i] = temp;
                red++;
                i--;
                continue;
            }
            if (nums[i] == 2 && i<=blue){
                //和blue指向的位置交换
                int temp = nums[blue];
                nums[blue] = nums[i];
                nums[i] = temp;
                blue--;
                i--;
                continue;
            }
        }
    }
}
