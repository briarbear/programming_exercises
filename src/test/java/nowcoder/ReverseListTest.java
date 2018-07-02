package nowcoder;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseListTest {

    @Test
    public void reverseList() {
        var s = new ReverseList();
        var root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        ListNode res = s.ReverseList(root);
        System.out.println("");
    }
}