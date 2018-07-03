package nowcoder;

import java.util.Stack;

/**
 * 包含min函数的栈
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @create 2018-07-03-20:45
 */
public class MinStack {

    private Stack<Integer> stack = new Stack();
    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        //将栈中的数据存到另外一个栈，再次过程中找到最小值
        int min = Integer.MAX_VALUE;
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()){
            if (stack.peek() < min)
                min = stack.peek();
            temp.push(stack.peek());
            stack.pop();
        }

        while (!temp.isEmpty()){
            stack.push(temp.peek());
            temp.pop();
        }

        return min;
    }
}
