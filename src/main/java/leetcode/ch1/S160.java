package leetcode.ch1;

import leetcode.ch0.ListNode;

import java.util.HashSet;

/**
 * 160. 相交链表
 *
 * @auther Val1ant
 * @blog http://www.val1ant.xin
 * @create 2018-05-14-22:58
 */
public class S160 {


    /**
     * Hash表的解决方式
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode res = null;
        //1. 先遍历一遍第一个链表，将其每个节点的地址，存储在hash表中
        HashSet<ListNode> hashSet = new HashSet<>();
        for (ListNode startA = headA; startA != null; hashSet.add(startA), startA = startA.next) ;

        ListNode startB = headB;
        //2. 然后遍历链表B，逐个判断是否在hash表中存在
        while (startB != null){
            if (hashSet.contains(startB)){
                return startB;
            }
            startB =startB.next;
        }

        return res;
    }

    /**
     * 双指针方案，
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
         //待完成
    }
}
