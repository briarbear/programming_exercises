package nowcoder;

import java.util.ArrayList;
import java.util.Stack;

public class PrintLinkedList {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
}
