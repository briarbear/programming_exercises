package leetcode.ch1;

import leetcode.ListNode;
import org.junit.Test;

public class S160Test {

    @Test
    public void getIntersectionNode() {

        S160 s = new S160();
        ListNode listA = new ListNode(1);
        listA.next = new ListNode(3);
        listA.next.next = new ListNode(5);
        listA.next.next.next = new ListNode(7);

        ListNode listB = new ListNode(2);
        listB.next = new ListNode(4);
        listB.next.next = new ListNode(8);
        listB.next.next.next = new ListNode(10);


//        listA.next.next.next = listB.next;

//        ListNode listB = listA;
        ListNode res = s.getIntersectionNode2(listA,listB);

        System.out.println("");
    }
}