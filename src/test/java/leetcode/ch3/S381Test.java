package leetcode.ch3;

import leetcode.InstanceUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class S381Test {

    @Test
    public void test() throws Exception {
        S381 s = InstanceUtils.get(S381.class);
        System.out.println(s.insert(3));
        System.out.println(s.insert(-2));
        System.out.println(s.remove(2));
        System.out.println(s.insert(1));

        System.out.println(s.insert(-3));
        System.out.println(s.insert(-2));
        System.out.println(s.remove(-2));
        System.out.println(s.remove(3));

        System.out.println(s.insert(-1));
        System.out.println(s.remove(-3));
        System.out.println(s.insert(1));
        System.out.println(s.insert(-2));

        System.out.println(s.insert(-2));
        System.out.println(s.insert(-2));
        System.out.println(s.insert(1));
        System.out.println(s.getRandom());

        System.out.println(s.insert(-2));
        System.out.println(s.remove(0));
        System.out.println(s.insert(-3));
        System.out.println(s.insert(1));
    }

    @Test
    public void insert() {

    }

    @Test
    public void remove() {
    }

    @Test
    public void getRandom() {
    }
}