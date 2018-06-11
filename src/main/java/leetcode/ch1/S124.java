package leetcode.ch1;

import leetcode.data_structure.TreeNode;

public class S124 {

    private int res;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }

    private int helper(TreeNode node) {
        if (node == null)
            return 0;
        int left = Math.max(helper(node.left),0);
        int rifht = Math.max(helper(node.right),0);
        res = Math.max(res,left+rifht+node.val);
        return Math.max(left,rifht) + node.val;
    }


}
