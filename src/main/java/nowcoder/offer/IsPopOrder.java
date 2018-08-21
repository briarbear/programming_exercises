package nowcoder.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 栈的压入、弹出序列
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @create 2018-07-03-20:54
 */
public class IsPopOrder {


    public boolean isOrder(int [] pushA,int [] popA) {

        if (pushA.length == 0)
            return false;

        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < pushA.length; list.add(pushA[i]),i++);

        for (int i = 0; i < popA.length; i++) {
            int index = list.indexOf(popA[i]);
            if (index != -1){
                for (int j = 0; j <= index; j++)
                    stack.push(list.remove(0));
            }
            if (!stack.isEmpty() && stack.peek() == popA[i]){
                stack.pop();
                continue;
            }

            return false;
        }

        return true;
    }
}
