package nowcoder.offer;

import java.util.ArrayList;

/**
 * 丑数
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @date 2018-08-27 15:44
 */
public class GetUglyNumber {

    public int solution(int index){
        if (index < 7) return index;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        int t2 = 0,t3 = 0,t5 = 0;

        for (int i = 1; i < index; i++) {
            int t = Math.min(res.get(t2)*2,Math.min(res.get(t3)*3,res.get(t5)*5));
            res.add(t);
            if (res.get(i) == res.get(t2) * 2) t2++;
            if (res.get(i) == res.get(t3) * 3) t3++;
            if (res.get(i) == res.get(t5) * 5) t5++;
        }


        return res.get(index-1);
    }

    public static void main(String[] args) {
        new GetUglyNumber().solution(10);
    }


}
