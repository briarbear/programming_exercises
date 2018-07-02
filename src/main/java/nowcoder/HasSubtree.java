package nowcoder;

/**
 * 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @auther briarbear
 * @blog http://briarbear.github.io
 * @create 2018-07-02-21:32
 */
public class HasSubtree {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {


        if (root2 == null || root1 == null)
            return false;



        return sub(root1,root2);

    }


    public boolean sub(TreeNode root1,TreeNode root2){

        //递归遍历

        if (root1.val == root2.val){
            boolean flag = helper(root1,root2);
            if (flag == true)
                return true;
        }

        if (root1.left != null)
            if(sub(root1.left,root2))
                return true;
        if (root1.right != null)
            if (sub(root1.right,root2))
                return true;

        return false;
    }


    public boolean helper(TreeNode root1,TreeNode root2){

        if (root2 == null)
            return true;
        if (root1 == null)
            return false;

        if (root1.val == root2.val)
            return helper(root1.left,root2.left)&&helper(root1.right,root2.right);
        return false;
    }
}
