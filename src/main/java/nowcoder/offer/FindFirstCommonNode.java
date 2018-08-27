package nowcoder.offer;

/**
 * 两个链表中公共结点的个数
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @date 2018-08-27 20:23
 */
public class FindFirstCommonNode {

    public ListNode solution1(ListNode pHead1,ListNode pHead2){
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        int len1 = 0,len2 = 0;
        while (p1 != null){
            len1++;
            p1 = p1.next;
        }

        while (p2 != null){
            len2++;
            p2 = p2.next;
        }

        if (len1 < len2){
            p1 = pHead2;
            p2 = pHead1;
            len2 = len1 + len2;
            len1 = len2 - len1;
            len2 = len2 = len1;
        }else {
            p1 = pHead1;
            p2 = pHead2;
        }

        //p1指向较长的链表 p2指向较短的链表
        int dist = len1 - len2;
        for (int i = 0; i < dist; i++) {
           p1 = p1.next;
        }

        while (p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
