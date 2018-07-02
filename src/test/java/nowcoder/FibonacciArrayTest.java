package nowcoder;

import leetcode.InstanceUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciArrayTest {

    @Test
    public void fibonacci() throws Exception {
        System.out.println(InstanceUtils.get(FibonacciArray.class).Fibonacci2(1));
    }
}