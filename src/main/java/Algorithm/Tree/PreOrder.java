package Algorithm.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树 的先序遍历
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @date 2018-08-21 19:29
 */
public class PreOrder {

    /**
     * 二叉树先序遍历的非递归实现
     * 1. 把根节点push到栈中
     *
     * 2. 循环检测栈是否为空，若不空，则取出栈顶元素，保存其值，
     *    然后看其右子节点是否存在，若存在则push到栈中。
     *    再看其左子节点，若存在，则push到栈中。
     * @param root 根节点
     */
    public List<Integer> order(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return res;
    }


    public List<Integer> order2(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = null;
        stack.push(root);
        ArrayList<Integer> res = new ArrayList<>();
        while (node != null || !stack.isEmpty()){
            if (node != null){
                res.add(node.val);
                if (node.right != null)  //保存右边节点，往左走
                    stack.push(node.right);
                node = node.left;
            }else {
                node = stack.pop();
            }
        }

        return res;
    }
}
