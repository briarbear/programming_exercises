package nowcoder;

import org.junit.Test;

import static org.junit.Assert.*;

public class CloneListTest {

    @Test
    public void Clone() {

        RandomListNode root = new RandomListNode(1);
        root.next = new RandomListNode(2);
        root.next.next = new RandomListNode(3);
        root.next.next.next = new RandomListNode(4);
        root.next.next.next.next = new RandomListNode(5);


        root.random = root.next.next;
        root.next.random = root.next.next.next.next;
        root.next.next.next.random = root.next;


        CloneList s = new CloneList();
        RandomListNode res = s.copy(root);
//        RandomListNode res = s.copy(null);

        return;
    }
}