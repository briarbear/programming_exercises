package leetcode.ch5;

import java.util.*;

/**
 * 56. 合并区间
 */
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
public class S56 {

    public List<Interval> merge(List<Interval> intervals) {

        LinkedList<Interval> res = new LinkedList<>();

        //先将区间排序
        Comparator<Interval> comparator = (o1,o2) -> o1.start - o2.start;
        Collections.sort(intervals,comparator);

        for (Interval interval : intervals) {
            if (res.isEmpty() || res.getLast().end < interval.start)
                res.add(interval);
            else
                res.getLast().end = Math.max(res.getLast().end,interval.end);

        }

        return res;
    }





}



