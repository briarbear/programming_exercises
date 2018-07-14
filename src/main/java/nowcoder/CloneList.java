package nowcoder;

/**
 * 复杂链表的复制
 *
 * @auther briarbear
 * @blog http://briarbear.github.io
 * @create 2018-07-14-13:24
 */


public class CloneList {

    /**
     * 算法珠叽
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead)
    {

        if (pHead == null)
            return null;

        RandomListNode p = pHead;
        RandomListNode dumpy = new RandomListNode(-1);

        RandomListNode node = new RandomListNode(p.label);
        //第一遍扫描顺序链表
        dumpy.next = node;
        p = p.next;
        RandomListNode q = node;
        while (p != null){
            RandomListNode t = new RandomListNode(p.label);
            q.next = t;
            q = q.next;
            p = p.next;
        }


        //第二趟扫描

        p = pHead;
        q = dumpy.next;
        while (p != null){
            if (p.random != null){
                //找到random在第一个链表中的位置
                int index = 0;
                RandomListNode t = pHead;
                while (t != p.random){
                    t = t.next;
                    index++;
                }
                RandomListNode tq = dumpy.next;
                for (int i = 0; i < index; i++) {
                    tq = tq.next;
                }
                q.random = tq;
            }

            p = p.next;
            q = q.next;
        }



        return dumpy.next;

    }

    /**
     * 剑指offer推荐解决办法
     * @param pHead
     * @return
     */
    public RandomListNode copy(RandomListNode pHead){

       if (pHead == null)
           return null;

        //1. 在原节点后面插入一个新节点
        RandomListNode p = pHead;
        while (p != null){
            RandomListNode node = new RandomListNode(p.label);
            node.next = p.next;
            p.next = node;

            p = node.next;
        }

        //2. 补充第二个链表的随机节点
        p = pHead;
        RandomListNode res = new RandomListNode(-1);
        RandomListNode q = p.next;
        res.next = q;


        while (p != null){
            if (p.random != null){
                q.random  = p.random.next;
            }

            p = q.next;
            q = p == null?null:p.next;
        }

        //恢复原链表 分开两个链表
        p = pHead;
        q = res.next;
        while (p != null){
            p.next = q.next;
            p = p.next;
            q.next = p==null?null:p.next;
            q = q==null?null:q.next;
        }


        return res.next;
    }
}






class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}