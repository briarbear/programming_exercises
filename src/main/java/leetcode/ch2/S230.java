package leetcode.ch2;

import leetcode.data_structure.TreeNode;

/**
 * 230. 二叉搜索树中第K小的元素
 */
public class S230 {

    private int res = 0,k,count = 0;

    /**
     * 深度优先搜素 即二叉树的中序遍历
     */
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        helper(root,k);

        return res;
    }

    public void helper(TreeNode root,int k){

        if(root != null){
            if (root.left != null){
                helper(root.left,k);
            }
            count++;
            if (count > k)
                return;
            if (count == k){
                res = root.val;
                return;
            }
            if (root.right != null){
                helper(root.right,k);
            }
        }

    }

}
