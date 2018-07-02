package nowcoder;

import org.junit.Test;

import static org.junit.Assert.*;

public class PowerTest {

    @Test
    public void pow() {
        var s = new Power();
        System.out.println(s.pow(2.3, -4));
        System.out.println(Math.pow(2.3,-4));
    }
}