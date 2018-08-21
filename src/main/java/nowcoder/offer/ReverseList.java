package nowcoder.offer;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * @auther briarbear
 * @blog http://briarbear.github.io
 * @create 2018-07-02-20:44
 */
public class ReverseList {

    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode root = new ListNode(-1);

        while (head != null){
            ListNode t = head.next;
            head.next = root.next;
            root.next = head;
            head = t;
        }

        return root.next;
    }
}
