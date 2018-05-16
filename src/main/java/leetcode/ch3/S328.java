package leetcode.ch3;

import leetcode.data_structure.ListNode;

/**
 * odd 奇数 even偶数
 * 328 Odd Even Linked List 奇偶链表
 *
 * @auther Val1ant
 * @blog http://www.val1ant.xin
 * @create 2018-5-14
 */
public class S328 {

    public ListNode oddEvenList(ListNode head) {
        ListNode oddStart = new ListNode(-1);
        ListNode evenStart = new ListNode(-1);
        ListNode odd = oddStart;
        ListNode even = evenStart;
        int count = 1;
        while (head != null) {
            if (count % 2 == 0) {
                even.next = head;
                even = even.next;
                head = head.next;
            } else {
                odd.next = head;
                odd = odd.next;
                head = head.next;
            }
            count++;
        }


        odd.next = evenStart.next; //拼接
        even.next = null; //置空

        return oddStart.next;

    }

}
