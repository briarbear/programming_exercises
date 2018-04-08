package leetcode.others;

public class P7 {

    public static void main(String[] args) {


        System.out.println(reverse(123));
    }

     public static int reverse(int x) {
        long temp = Long.valueOf(x);
        long nResever = 0;
        while (x!=0){
            nResever = nResever *10 + x%10;
            x = x/10;
        }
        if (nResever>Integer.MAX_VALUE||nResever<Integer.MIN_VALUE)
            return 0;

        return (int)nResever;
    }

}
