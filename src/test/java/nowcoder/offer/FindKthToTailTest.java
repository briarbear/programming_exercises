package nowcoder.offer;

import nowcoder.offer.FindKthToTail;
import nowcoder.offer.ListNode;
import org.junit.Test;

public class FindKthToTailTest {

    @Test
    public void find() {
        FindKthToTail s = new FindKthToTail();
        ListNode root = new ListNode(0);
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        System.out.println(s.find(root, 0).val);
    }
}