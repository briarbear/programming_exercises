package nowcoder.offer;

/**
 * 链表中倒数第K个节点
 *
 * @auther Val1ant
 * @blog http://www.val1ant.xin
 * @create 2018-07-02-20:12
 */
public class FindKthToTail {

    /**
     * 双指针方案
     * @param head
     * @param k
     * @return
     */
    public ListNode find(ListNode head,int k) {
        if (head == null || k == 0)
            return null;

        ListNode right = head,left = head;

        //right先右便宜k个位置
        int j = 1;
        while (j++ < k){
            right = right.next;
            if (right == null)
                return null;
        }

        //left right 同时偏移
        while (right.next != null){
            right = right.next;
            left = left.next;
        }

        return left;
    }
}
