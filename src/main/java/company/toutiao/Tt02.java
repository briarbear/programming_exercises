package company.toutiao;

import java.util.*;

/**
 * 头条编程题
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @date 2018-08-12 9:55
 */
public class Tt02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int m = scanner.nextInt();
            List<Interval> input = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                String[] strings = scanner.next().split(";");
                for (int j = 0; j < strings.length; j++) {
                    String[] split = strings[j].split(",");
                    input.add(new Interval(Integer.valueOf(split[0]),Integer.valueOf(split[1])));
                }
            }

            LinkedList<Interval> res = new LinkedList<>();

            //先将区间排序
            input.sort((o1, o2) -> o1.start - o2.start);

            for (Interval interval : input) {
                if (res.isEmpty() || res.getLast().end < interval.start)
                    res.add(interval);
                else
                    res.getLast().end = Math.max(res.getLast().end,interval.end);

            }

            //遍历输出
            while (res.size()>0){
                Interval interval = res.remove();
                System.out.print(interval.start+","+interval.end);
                if (res.size()>0)
                    System.out.print(";");
            }

        }
    }

}
class Interval {
    int start;
    int end;
    Interval(){
        start = 0;
        end = 0;
    }
    Interval(int s,int e){
        start = s;
        end =e;
    }
}