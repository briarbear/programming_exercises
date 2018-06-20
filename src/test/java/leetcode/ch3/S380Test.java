package leetcode.ch3;

import org.junit.Test;

import static org.junit.Assert.*;

public class S380Test {

    @Test
    public void test(){
        S380 s = new S380();

        s.insert(1);
        s.insert(2);
        s.insert(1);
        s.insert(3);
        s.insert(4);

        s.remove(5);
        s.insert(5);
        s.remove(2);
        s.remove(1);
        s.remove(3);
        s.remove(4);

        System.out.println(s.getRandom());
    }

}