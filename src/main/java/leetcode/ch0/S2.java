package leetcode.ch0;

/**
 * 2 两数相加 	 Add Two Numbers
 *
 * @auther Val1ant
 * @blog http://www.val1ant.xin
 * @create 2018-05-09-19:09
 */

public class S2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode p = res;
        boolean flag = false;
        while (l1 != null && l2 != null) {

            int t = flag ? l1.val + l2.val + 1 : l1.val + l2.val;
            if (t >= 10) {
                flag = true;
                p.next = new ListNode(t % 10);
            } else {
                flag = false;
                p.next = new ListNode(t);
            }
            l1 = l1.next;
            l2 = l2.next;
            p = p.next;
        }

        p.next = l1 == null ? l2 : l1;

        while (p.next != null) {
            int t = flag ? p.next.val + 1 : p.next.val;
            if (t == 10) {
                flag = true;
                p.next.val = t % 10;
            } else {
                flag = false;
                p.next.val = t;
            }
            p = p.next;
        }

        if (flag)
            p.next = new ListNode(1);

        return res.next;
    }
}


