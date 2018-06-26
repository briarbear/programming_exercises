package company.shenxinfu;




import java.util.Scanner;

public class RepeatingStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String input = scanner.next();
            int len = input.length();
            int max = 0;
            for (int i = 1; i <= len/2; i++) {
                //i 为窗口宽度
                for (int j = 0; j <=len-2*i; j++) {
                    int k = 0;
                    for (; k < i; k++) {
                        if (input.charAt(j+k) == input.charAt(j+k+i))
                            continue;
                        else
                            break;

                    }
                    if (i == k-1){
                        max = 2*k > max ? 2*k:max;
                    }

                }
            }

            System.out.println(max);
        }
    }


    public void helper(String str){
        //最长的重复字串，极端情况就比如abcabc，最长重复字串就是abc
        //即为字符串长度的一半，当然这是极端情况，通常都是小于串长一半的
        String sub,left;

        for (int len = str.length()/2; len >0 ; len--) {
                //将字符串分隔为若干"最长子串"
            for (int i = 0; i < str.length()/len; i++) {
                //获取最长子串
//                reg = str.substring(0,len+1)
            }
        }
    }


}