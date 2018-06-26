package leetcode.ch2;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;

/**
 * 202. 快乐数
 */
public class S202 {

    private Map<Integer,Integer> map = new HashMap<>();

    public boolean isHappy(int n) {

        helper2(n);
        return helper(n);

    }


    public boolean helper(int n){
        if (map.containsKey(n))
            return false;
        String s = String.valueOf(n);
        int len = s.length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            int t = Integer.parseInt(String.valueOf(s.charAt(i)));
            res += t * t;
        }
        if (res == 1)
            return true;
        map.put(n,res);
        return helper(res);
    }

    /**
     * 如果是循环的数字，一定会出现4
     * @param n
     * @return
     */
    public boolean helper2(int n){
        int sum = 0;
        while (n != 4 && n != 1){

            while (n > 0){
                sum += (int)Math.pow(n%10,2);
                n = n/10;
            }
            n = sum;
            sum = 0;
        }

        return n == 1;
    }
}
