package nowcoder;

import java.util.Stack;

public class StackToList {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        //先将元素存在第一个栈中
        stack1.push(node);

    }

    public int pop() {
        //将第一个栈中的元素都转存到第二个栈中，
//        stack2.clear();
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        //输出第二个栈的栈顶元素
        int res = stack2.pop();

        //然后再转载到第一个栈中
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return res;
    }
}
