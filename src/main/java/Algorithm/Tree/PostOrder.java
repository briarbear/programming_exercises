package Algorithm.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树后序遍历
 *
 * @author briarbear
 * @blog http://briarbear.github.io
 * @create 2018-08-21-22:31
 */
public class PostOrder {

    /**
     * 后序遍历的非递归实现
     *
     * @param root
     * @return
     */
    public List<Integer> order(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        /**
         * 先序遍历逆运算
         */
        while (node != null || !stack.isEmpty()) {
            if (node != null) {  //一直走到最右边
                res.addFirst(node.val); //加到头部
                if (node.left != null) {
                    stack.add(node.left);
                }
                node = node.right;
            } else {
                node = stack.pop();
            }
        }

        return res;
    }
}
