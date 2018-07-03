package nowcoder;

/**
 * 二叉树的镜像
 *
 */
public class Mirror {


    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        //交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null)
            Mirror(root.left);
        if (root.right!= null)
            Mirror(root.right);

    }
}
