package Ali;

import java.math.BigDecimal;
import java.util.Scanner;

public class A {
    /**
     * 请完成下面这个函数，实现题目要求的功能 计算等额本息的每月还款金额
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来
     *
     * @param a 贷款金额
     * @param i 年利率
     * @param n 贷款期限
     * @return 月还款额，保留2位小数，向上舍入
     */
    static String calculate(int a, double i, int n) {

            String res;
            double res2 = (a * (i/(100 * 12)) * Math.pow((1+ i/(100*12)),n*12) ) / (Math.pow((1+i/(100 * 12)),n*12)-1);
            System.out.println(res2);

            BigDecimal   b   =   new BigDecimal(res2+0.004);

            double   res3  =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
            res = String.valueOf(res3);
            System.out.println(res);
        return res;
    }

    public static void main(String[] args){
        calculate(10000,4.9,1);

//        Scanner in = new Scanner(System.in);
//        String res;
//
//        //请出入贷款金额(正整数):;
//        int _a;
//        _a = Integer.parseInt(in.nextLine().trim());
//
//        //请输入年利率(如:4.35)%:;
//        double _i;
//        _i = Double.parseDouble(in.nextLine().trim());
//
//        //请输入贷款期限多少年:;
//        int _n;
//        _n = Integer.parseInt(in.nextLine().trim());
//
//        res = calculate(_a, _i, _n);
//        System.out.println(res);
    }
}
