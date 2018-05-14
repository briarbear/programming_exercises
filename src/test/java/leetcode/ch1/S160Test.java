package leetcode.ch1;

import leetcode.ch0.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class S160Test {

    @Test
    public void getIntersectionNode() {

        S160 s = new S160();
        ListNode listA = new ListNode(1);
        listA.next = new ListNode(2);
        listA.next.next = new ListNode(3);

        ListNode listB = new ListNode(4);
        listB.next = new ListNode(5);
        listB.next = new ListNode(7);

        listA.next.next.next = listB.next;

        ListNode res = s.getIntersectionNode(listA,listB);

        System.out.println("");
    }
}