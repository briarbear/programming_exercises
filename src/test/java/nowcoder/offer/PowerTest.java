package nowcoder.offer;

import nowcoder.offer.Power;
import org.junit.Test;

public class PowerTest {

    @Test
    public void pow() {
        Power s = new Power();
        System.out.println(s.pow(2.3, -4));
        System.out.println(Math.pow(2.3,-4));
    }
}