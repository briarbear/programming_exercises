package leetcode.ch3;

import leetcode.data_structure.ListNode;
import org.junit.Test;

public class S328Test {

    @Test
    public void oddEvenList() {
        S328 s = new S328();

        ListNode r = new ListNode(1);
        r.next = new ListNode(2);
        r.next.next = new ListNode(3);
        r.next.next.next = new ListNode(4);
//        r.next.next.next.next = new ListNode(5);

        ListNode res = s.oddEvenList(r);
        System.out.println(res);
    }
}