package leetcode.ch6;

/**
 * 679 24点游戏
 */
public class S679 {


    public boolean judgePoint24(int[] nums) {
        if (handle(nums))
            return true;
        else
            return false;
    }


    public static boolean handle(int[] arr) {

        double accuracy = 0.00000001;

        //从4个数种选择2个数
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                double[] r1 = cal((double) arr[i], (double) arr[j]);
                //得到3个数，再从剩下的数中，再选择两个
                for (int k = 0; k < 4; k++) {
                    if (k == i || k == j)
                        continue;
                    for (int l = 0; l < 4; l++) {
                        if (l == i || l == j || l == k)
                            continue;
                        for (int m = 0; m < 6; m++) {
                            //选到了3个数，r1[m],arr[k],arr[l],拼成一个数组,然后从中选择两个
                            double[] arr2 = new double[3];
                            arr2[0] = r1[m];
                            arr2[1] = arr[k];
                            arr2[2] = arr[l];
                            //从arr2数组中选择2个数
                            for (int n = 0; n < 2; n++) {
                                for (int o = n + 1; o < 3; o++) {
                                    double[] r2 = cal(arr2[n], arr2[o]);

                                    //计算得到6个元素的数组，然后再与剩下的最后一个元素计算
                                    for (int p = 0; p < 3; p++) {
                                        if (p == n || p == o)
                                            continue;
                                        //到这里得到2个元素，r2[q],arr2[p]
                                        for (int q = 0; q < 6; q++) {
                                            double[] r3 = cal(r2[q], arr2[p]);

                                            for (int r = 0; r < r3.length; r++) {
                                                //分别计算r3，判断是否等于24
//                                                System.out.println(r3[r]);
                                                if (Math.abs(24 - r3[r]) < accuracy)
                                                    return true;
                                            }
                                        }
                                    }
                                }
                            }

                        }

                    }

                }
            }
        }

        return false;
    }


    public static double[] cal(double a, double b) {
        //返回6种计算结果
        double[] res = new double[6];
        res[0] = a + b;
        res[1] = a - b;
        res[2] = b - a;
        res[3] = a * b;
        res[4] = b == 0 ? Double.MAX_VALUE / 2 : a / b;
        res[5] = a == 0 ? Double.MAX_VALUE / 2 : b / a;

        return res;

    }


}
