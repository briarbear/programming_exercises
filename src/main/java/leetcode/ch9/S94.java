package leetcode.ch9;

import leetcode.data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 */
public class S94 {

    /**
     * 递归遍历
     * @param root
     * @return
     */
    private List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        //中序遍历，递归解决

        if (root == null)
            return res;

        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);

        return res;

    }

    /**
     * 二叉树中序遍历的非递归实现，借助栈
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        //非递归遍历
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();


        while (root!=null || !stack.isEmpty()){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }

        }

        return res;
    }





}
