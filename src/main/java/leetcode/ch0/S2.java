package leetcode.ch0;

import leetcode.ListNode;

/**
 * 2 两数相加 	 Add Two Numbers
 *
 * @auther Val1ant
 * @blog http://www.val1ant.xin
 * @create 2018-05-09-19:09
 */

public class S2 {

    /**
     * 基本思路很简答，重点是处理进位与最后一个最高位
     *
     * @param l1
     * @param l2
     * @return
     */
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

    /**
     * 精简升级版
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1); //作为头指针
        ListNode p = res;
        boolean flag = false;//进位标志
        while (l1 != null || l2 != null) { //只要一个不等于空，循环就继续下去
            int t1 = l1 == null ? 0 : l1.val;
            int t2 = l2 == null ? 0 : l2.val;
            int sum = flag ? t1 + t2 +1 : t1 + t2;

            p.next = sum >= 10 ? new ListNode(sum % 10) : new ListNode(sum);
            flag = sum >= 10 ? true:false;
            l1 = l1 == null?null:l1.next;  //如果已经为空，则不向前移动
            l2 = l2 == null?null:l2.next;
            p = p.next;
        }
        //最后再判断是否还有一个进位
        p.next = flag?new ListNode(1):null;

        return res.next;
    }
}


