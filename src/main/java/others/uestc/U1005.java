package others.uestc;

import java.util.Scanner;

/**
 * Flagstone 石板
 */
public class U1005 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();  //石头数量
            int[] lens = new int[num];  //保存石头长度的数组
            int[] gap = new int[num - 1];  //间隙数组

            for (int j = 0; j < num; j++) {
                lens[j] = scanner.nextInt();
            }
            for (int j = 0; j < num - 1; j++) {
                gap[j] = scanner.nextInt();
            }

            System.out.println(handle(num, lens, gap));
        }

    }

    //计算函数 二分查找
    public static String handle(int num, int[] lens, int[] gap) {
        //生成len+gap+len
        if (num < 2)
            return "impossible";

        double min = lens[0] + gap[0];
        double max = min + lens[1];

        double mid = 0;
        double accuracy = 0.001;
        boolean flag = false;
        while (!(Math.abs(max - min) < accuracy)){
            mid = (min + max) / 2;
            switch (walk(lens,gap,mid)){
                case -1:min = mid;break;
                case 1:max = mid;break;
                case 0:max = mid;flag = true;break;
            }
        }

        if (!flag)
            return "impossible";


        return String.format("%.2f",min);
    }

    //判断是否满足 -1 表示 步伐过短，1 表示步伐过长
    public static int walk(int[] lens, int[] gap, double foot) {
        double location = 0;
        int length = 0;
        for (int i = 0; i < lens.length - 1; i++) {
            location += foot;
            length += lens[i] + gap[i];

            if (location <length)
                return -1;
            if (location > length + lens[i+1])
                return 1;
        }

        return 0;
    }


}
