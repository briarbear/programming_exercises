package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 袋鼠过河
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @create 2018-07-09-17:37
 */
public class T5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String[] strs;
        int n;

        while((str = br.readLine()) != null){
            n = Integer.parseInt(str.trim());
            str = br.readLine();
            strs = str.trim().split(" ");
            int[] input = new int[n];
            for(int i = 0; i < n; ++i)
                input[i] = Integer.parseInt(strs[i]);
            int step = 1;
            int now = input[0];
            int next = now;
            for(int i = 1; i < n; ++i){
                if(i == now){
                    next = Math.max(next, i + input[i]);
                    if(next == now){
                        System.out.println(-1);
                        break;
                    }
                    ++step;
                    now = next;
                    if(next >= n){
                        System.out.println(step);
                        break;
                    }
                }
                else{
                    next = Math.max(next, i + input[i]);
                    if(next >= n){
                        System.out.println(++step);
                        break;
                    }
                }
            }
        }
    }
}
