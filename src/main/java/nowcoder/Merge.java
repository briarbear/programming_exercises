package nowcoder;

/**
 * 合并两个排序的链表
 *
 * @auther briarbear
 * @blog http://briarbear.github.io
 * @create 2018-07-02-21:05
 */
public class Merge {

    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     * @param list1
     * @param list2
     * @return
     */
    public ListNode merge(ListNode list1,ListNode list2) {
        if (list1 == null)  return list2;
        if (list2 == null)  return list1;

        ListNode res = new ListNode(-2);
        ListNode t = new ListNode(-1);
        res.next = t;
        while (list1 != null || list2 != null){

            if (list2 == null || (list1 != null && list1.val < list2.val)){
                t.next = list1;
                list1 = list1.next;
            }else {
                t.next = list2;
                list2 = list2.next;
            }

            t = t.next;
        }

        return res.next.next;
    }
}
