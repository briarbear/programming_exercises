package nowcoder.offer;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GetLeastNumbersTest {

    @Test
    public void getLeastNumbers_Solution() {
        GetLeastNumbers n = new GetLeastNumbers();
//        ArrayList<Integer> list = n.GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4);
        ArrayList<Integer> list2 = n.solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4);
        list2.forEach(integer -> System.out.println(integer));
    }
}