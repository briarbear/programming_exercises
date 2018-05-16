package leetcode.ch1;

import leetcode.data_structure.ListNode;

import java.util.HashSet;
import java.util.Stack;

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
     * 双指针方案，拼接链表，利用环的思想
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
         //双指针方案，拼接链表，利用环的思想
         //Dual-pointer scheme, splicing linked lists, using ring ideas
        if(headA == null || headB == null) return null;
        ListNode tempA= headA,tempB = headB;
        int countA = 0,countB = 0;

        while (tempA != tempB){

            if (countA>=2&&countB>=2)
                return null;

            if (tempA.next == null){
                tempA = headB;
                countA++;
            }else
                tempA = tempA.next;

            if (tempB.next == null){
                tempB = headA;
                countB++;
            }else
                tempB = tempB.next;


        }



        return tempA;
    }



    /**
     * 栈思路解决方案
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB){
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        if (nodeA==null||nodeB==null)
            return null;
        for (;nodeA!=null;stackA.push(nodeA),nodeA = nodeA.next);
        for (;nodeB!=null;stackB.push(nodeB),nodeB = nodeB.next);
        ListNode temp = null,res= null;
        while (!stackA.isEmpty()&&!stackB.isEmpty()){
            if ((temp = stackA.pop()) == stackB.pop()){
                res = temp;
            }else {
                break;
            }


        }
        return res;
    }




}
