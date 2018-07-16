package nowcoder;

/**
 * 树的工具类
 *
 * @auther briarbear
 * @blog http://briarbear.github.io
 * @create 2018-07-14-23:03
 */
public class TreeUtils {


    /**
     * 二叉搜索树
     *
     *            4
 *            2         5
*         1      3    6      7
     *
     * @return
     */
    public static TreeNode t1(){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);


        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        return root;
    }


}
