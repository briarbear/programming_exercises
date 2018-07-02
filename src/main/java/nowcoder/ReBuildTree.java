package nowcoder;

/**
 * 前序遍历与中序遍历构建二叉树
 */
public class ReBuildTree {


    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {


        return helper(0,pre.length-1,0,in.length-1,pre,in);
    }

    /**
     *
     */
    public TreeNode helper(int preStart,int preEnd,int inStart,int inEnd,int[] pre,int[] in){
        if (preStart > preEnd || inStart > inEnd)
            return null;

        //建立根节点
        TreeNode root = new TreeNode(pre[preStart]);  //从前序节点的第一个节点建立根节点

        //从中序列表中找到该节点的位置
        int i = inStart;
        for (; i <= inEnd; i++) {
            if (in[i] == root.val)
                break;
        }
        //此时，i为根节点在中序列中位置

        //建立左子树
        root.left = helper(preStart+1,preStart+i-inStart,inStart,i-1,pre,in);

        //建立右子树
        root.right = helper(preStart+i-inStart+1,preEnd,i+1,inEnd,pre,in);

        return root;
    }

}
