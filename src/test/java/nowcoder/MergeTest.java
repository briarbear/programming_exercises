package nowcoder;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeTest {

    @Test
    public void merge() {
        Merge s = new Merge();
        ListNode r1 = new ListNode(1);
        r1.next = new ListNode(3);
        r1.next.next = new ListNode(5);
        r1.next.next.next = new ListNode(7);
        ListNode r2 = new ListNode(2);
        r2.next = new ListNode(4);
        r2.next.next = new ListNode(6);
//        r2.next.next.next = new ListNode(8);

        s.merge(r1,r2);
    }
}