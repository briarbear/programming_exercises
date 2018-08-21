package Algorithm.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @date 2018-08-21 20:02
 */
public class InOrder {

    /**
     * 二叉树的中序遍历，非递归实现
     * @param root
     * @return
     */
    public List<Integer> order(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node =null;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }

        }


        return res;

    }
}
