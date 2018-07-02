package nowcoder;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindKthToTailTest {

    @Test
    public void find() {
        var s = new FindKthToTail();
        var root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        System.out.println(s.find(root, 0).val);
    }
}