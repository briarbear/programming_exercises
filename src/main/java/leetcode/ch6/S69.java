package leetcode.ch6;

/**
 * 69. Sqrt(x)
 */
public class S69 {

    /**
     * 二分查找
     * @param x
     * @return
     */
    public int mySqrt(int x){
        int left = 0,right = (int) Math.sqrt(x),mid = 0;

        while (right >= left){
            mid = (left + right ) / 2;
            int temp = mid * mid;
            if (temp > x){
                right = mid - 1;
            }else if (temp < x)
                left = mid+1;
            else
                return mid;
        }
        return mid*mid > x ? mid-1:mid;
    }
}
