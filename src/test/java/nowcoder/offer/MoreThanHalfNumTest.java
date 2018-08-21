package nowcoder.offer;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoreThanHalfNumTest {

    @Test
    public void moreThanHalfNum_Solution() {
        MoreThanHalfNum m = new MoreThanHalfNum();
//        System.out.println(m.MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
        System.out.println(m.solution(new int[]{2,2,2,2,2,1,3,4,5}));
    }
}