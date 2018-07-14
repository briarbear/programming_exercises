package nowcoder;

/**
 * 二叉搜索树与双向链表
 *
 * @auther briarbear
 * @blog http://briarbear.github.io
 * @create 2018-07-14-20:45
 */
public class Convert {

    //
    public TreeNode convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null)
            return null;

        helper(pRootOfTree, 0);

        //返回最左侧头节点
        TreeNode t = pRootOfTree;
        while (t.left != null)
            t = t.left;
        return t;
    }


    /**
     * 我还是习惯用递归的方式来解决
     */
    public TreeNode helper(TreeNode node, int flag) {

        if (node.left != null) {
            node.left = helper(node.left, 0);
            node.left.right = node;
        }

        if (node.right != null) {
            node.right = helper(node.right, 1);
            node.right.left = node;
        }

        if (node.left == null && node.right == null) //叶子节点
            return node;

        if (flag == 0)
            return node.right == null ? node : node.right;
        else
            return node.left == null ? node : node.left;


    }
}
