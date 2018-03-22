package ch1;

import java.util.List;

public class P19 {

    static class ListNode implements Cloneable {

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }

    }

    public static void main(String[] args) throws CloneNotSupportedException {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        System.out.println(removeNthFromEnd2(listNode,1));

    }


    /**
     * 先遍历得到链表长度，然后偏移到待删除结点的前置结点，然后删除结点
     * @param head
     * @param n
     * @return
     * @throws CloneNotSupportedException
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) throws CloneNotSupportedException {

        int len = 0;
        ListNode h = new ListNode(0);  //作为头节点的前置结点
        h.next = head;

        //遍历得到链表的长度
        ListNode p = head;
        while (p!=null){
            len++;
            p = p.next;
        }
        int i = 0,count = len - n;
        p = h;             //保证p指向的是待删除结点的前一个结点
        while (i<count){
            p= p.next;
            i++;
        }

        p.next = p.next.next;

        return h.next;

    }

    /**
     * 用两个指针，其中一个先偏移n个位置，然后两个指针同时偏移
     * 当第一个指针到达末尾了，则第二个指针则达到待删除的结点位置
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head,int n){

        ListNode p0 = new ListNode(0),p2,p1;
        p0.next = head;
        p1 = p0; p2 = p0;
        int i = 0;
        while (i<n){        //用两个指针，其中一个先偏移n个位置，
            p1 = p1.next;
            i++;
        }
        //然后两个指针同时偏移,当第一个指针到达末尾了，则第二个指针则达到待删除的结点位置
        while (p1.next!=null){
            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;

        return p0.next;

    }
}
