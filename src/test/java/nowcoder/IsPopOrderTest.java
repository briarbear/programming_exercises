package nowcoder;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsPopOrderTest {

    @Test
    public void isOrder() {
        var s = new IsPopOrder();
        var p1 = new int[]{1,3};
        var p2 = new int[]{1,4};

        System.out.println(s.isOrder(p1, p2));
    }
}