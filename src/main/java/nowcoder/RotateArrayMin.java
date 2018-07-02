package nowcoder;

/**
 * 求旋转数组的最小数字
 */
public class RotateArrayMin {

    /**
     * 二分法解决
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0)
            return 0;

        int left = 0,right = array.length-1;
        int mid = 0,end = right;
        while (left < right){
            mid = (left + right) / 2;

            if (array[mid] > array[end]){ //如果mid 大于最右边的数，说明最小的那个数在mid右边
                left = mid+1;
            }else {
                right = mid;
            }
        }

        mid = (left + right) / 2;
        return array[mid];

    }
}
