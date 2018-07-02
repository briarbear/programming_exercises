package leetcode.ch1;

import leetcode.InstanceUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class S166Test {

    @Test
    public void fractionToDecimal() throws Exception {
        System.out.println(InstanceUtils.get(S166.class).fractionToDecimal(4, 333));
        System.out.println(InstanceUtils.get(S166.class).fractionToDecimal(1, 2));
        System.out.println(InstanceUtils.get(S166.class).fractionToDecimal(2, 3));
        System.out.println(InstanceUtils.get(S166.class).fractionToDecimal(1, 6));
        System.out.println(InstanceUtils.get(S166.class).fractionToDecimal(1, 90));
    }
}