package others.uestc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 24点纸牌游戏的实现
 */
public class U1002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {

            int[] arr = new int[4];
            for (int j = 0; j < 4; j++) {
                arr[j] = scanner.nextInt();
            }
            scanner.nextLine();

            if (handle(arr))
                System.out.println("yes");
            else
                System.out.println("no");


        }


    }


    //
    public static boolean handle(int[] arr) {

        double accuracy = 0.0000000001;

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
                                                if (Math.abs(24 - r3[r]) < accuracy){
//                                                    System.out.println(arr[i]+" "+arr[j]+" "+"="+r1[m]);
//                                                    System.out.println(arr2[n]+" "+ arr2[o]+" = "+r2[q]);
//                                                    System.out.println(r2[q]+" "+ arr2[p] +" "+r3[r]);
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
        res[4] = b == 0 ? Double.MAX_VALUE/2 : a / b;
        res[5] = a == 0 ? Double.MAX_VALUE/2 : b / a;

        return res;

    }

    public static boolean helper(int[] arr) {

        //列举4阶层的各种情况
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j)
                    continue;
                for (int k = 0; k < 4; k++) {
                    if (i == k || j == k)
                        continue;
                    for (int l = 0; l < 4; l++) {
                        if (i == l || j == l || k == l)
                            continue;
                        int[] list = new int[4];
                        list[0] = arr[i];
                        list[1] = arr[j];
                        list[2] = arr[k];
                        list[3] = arr[l];
//                        System.out.print(list[0]+" "+list[1]+" "+list[2]+" "+list[3]);
                        if (judge(list)) {
//                            System.out.println("yes");
                            return true;
                        }
                    }
                }
            }
        }

        return false;

    }

    //给定一个四个数的序列，判断能够组成24
    public static boolean judge(int[] list) {
        //转化成double数组
        double[] arr = new double[]{(double) list[0], (double) list[1], (double) list[2], (double) list[3],};
        double accuracy = 0.00000001;
        double res = 0.0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    double r1 = 0.0, r2 = 0.0;
                    switch (i) {
                        case 0:
                            r1 = arr[0] + arr[1];
                            break;
                        case 1:
                            r1 = arr[0] - arr[1];
                            break;
                        case 2:
                            r1 = arr[1] - arr[0];
                            break;
                        case 3:
                            r1 = arr[0] * arr[1];
                            break;
                        case 4:
                            if (arr[1] == 0) continue;
                            r1 = arr[0] / arr[1];
                            break;
                        case 5:
                            if (arr[0] == 0) continue;
                            r1 = arr[1] / arr[0];
                            break;
                    }
                    switch (j) {
                        case 0:
                            r2 = r1 + arr[2];
                            break;
                        case 1:
                            r2 = r1 - arr[2];
                            break;
                        case 2:
                            r2 = arr[2] - r1;
                            break;
                        case 3:
                            r2 = r1 * arr[2];
                            break;
                        case 4:
                            if (arr[2] == 0) continue;
                            r2 = r1 / arr[2];
                            break;
                        case 5:
                            if (r1 == 0) continue;
                            r2 = arr[2] / r1;
                            break;
                    }
                    switch (k) {
                        case 0:
                            res = r2 + arr[3];
                            break;
                        case 1:
                            res = r2 - arr[3];
                            break;
                        case 2:
                            res = arr[3] - r2;
                            break;
                        case 3:
                            res = r2 * arr[3];
                            break;
                        case 4:
                            if (r2 == 0) continue;
                            res = arr[3] / r2;
                            break;
                        case 5:
                            if (arr[3] == 0) continue;
                            res = r2 / arr[3];
                            break;
                    }

                    if (Math.abs(res - 24) < accuracy)
                        return true;
                }
            }
        }


        return false;
    }


}
