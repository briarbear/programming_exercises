package nowcoder;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ReverseListTest {

    @Test
    public void reverseList() {
        ReverseList s = new ReverseList();
        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        ListNode res = s.ReverseList(root);
        System.out.println("");
    }
}