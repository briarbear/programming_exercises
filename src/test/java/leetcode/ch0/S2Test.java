package leetcode.ch0;

import org.junit.Test;

import static org.junit.Assert.*;

public class S2Test {

    @Test
    public void addTwoNumbers() {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
//        l1.next.next = new ListNode(9);
//        l1.next.next.next = new ListNode(7);

        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        S2 s = new S2();
        s.addTwoNumbers(l1,l2);
    }
}