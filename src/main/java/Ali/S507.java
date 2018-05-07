package Ali;

import java.util.Scanner;

/**
 * 2018年阿里巴巴实习生招聘模式笔试题
 * 消除连续的重复字符串 字串长度>=2
 */
public class S507 {

    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);

        System.out.println(handle("我是阿里旺旺，我在重复说话重复说话重复说话"));
//        while (scanner.hasNext()){
//            String input = scanner.next();
//
//            System.out.println(handle(input));
//        }


    }

    /**
     * 滑动窗口解决方法
     * @param string
     * @return
     */
    public static String handle(String string){

        StringBuilder sb = new StringBuilder(string);



        for (int i = 2; i <= sb.length()/2; i++) {
            for (int j = 0; j < sb.length()-i-i+1; j++) {
                String s1 = sb.substring(j,j+i);
                String s2 = sb.substring(j+i,j+i+i);
                if (s1.equals(s2)){

                    sb.replace(j+i,j+i+i,"");
                    j -= i;  //往后移动i个位置
                }
            }
        }


        return sb.toString();
    }
}
