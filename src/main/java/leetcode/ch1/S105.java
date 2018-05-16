package leetcode.ch1;

import leetcode.data_structure.TreeNode;

/**
 * 105 从前序与中序遍历序列构造二叉树
 */
public class S105 {

    /**
     * 由二叉树的先序序列和中序序列可以唯一地确定一棵二叉树， 在先序遍历序列中，第一个结
     * 点一定是二叉树的根结点，而在中序遍历中，根结点必然将中序序列分割成两个子序列，前一个
     * 子序列就是根结点的左子树的中序序列，后一个子序列是根结点的右子树的中序序列。根据这两
     * 个子序列，在先序序列中找到对应的左子序列和右子序列。在先序序列中，左子序列的第一个结
     * 点是左子树的根结点，右子序列的第一个结点是右子树的根结点。如此递归地进行下去，便能唯
     * 一地确定这棵二叉树。
     *
     */

    /**
     * leetcode
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return help(0,0,inorder.length-1,preorder,inorder);
    }

    public TreeNode help(int preStart,int inStart,int inEnd,int[] preorder,int[] inorder){
        if (preStart > preorder.length-1 || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);  //找到根结点
        int inIndex = 0;
        for (int i = 0; i < inEnd; i++) {  //在中序遍历中找到该根节点的位置
            if (inorder[i] == root.val){
                inIndex = i;
                break;
            }

        }

        root.left = help(preStart+1,inStart,inIndex-1,preorder,inorder);
        root.right = help(preStart+inIndex-inStart+1,inIndex+1,inEnd,preorder,inorder);
        return root;
    }


    public TreeNode buildTree2(int[] preorder, int[] inorder){

        return help2(0,preorder.length-1,0,inorder.length-1,preorder,inorder);
    }

    public TreeNode help2(int preStart,int preEnd,int inStart,int inEnd,int[] preorder,int[] inorder){
        if (preStart>preEnd||inStart>inEnd)
            return null;
        //建立根节点
        TreeNode root = new TreeNode(preorder[preStart]);
        //在中序中找到该结点位置
        int i = inStart;
        for (; i <= inEnd; i++) {
            if (inorder[i] == root.val){
                break;
            }
        }

        int leftLen = i-inStart;//左子树长度
        int rightLen = inEnd-i; //右子树长度
        if (leftLen>0)
            root.left = help2(preStart+1,preStart+leftLen,inStart,i-1,preorder,inorder);

        if (rightLen>0)
            root.right = help2(preEnd-rightLen+1,preEnd,i+1,inEnd,preorder,inorder);

        return root;

    }
}
