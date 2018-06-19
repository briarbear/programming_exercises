package leetcode.ch2;

import leetcode.ch3.S3;
import leetcode.data_structure.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 297. 二叉树的序列化与反序列化  Serialize and Deserialize Binary Tree
 */
public class S297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null)
            return "";
        StringBuilder sb = new StringBuilder();
        se(root,sb);

        return sb.toString();
    }


    /**
     *
     */
    public void se(TreeNode node,StringBuilder sb){
        if (node == null)
            sb.append("# ");
        else {
            sb.append(node.val + " ");
            se(node.left,sb);
            se(node.right,sb);
        }
    }


    // Decodes your encoded data to tree.

    /**
     * 反序列化
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {

        if (data==null || data.equals(""))
            return null;
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(" ")));
        int value = Integer.valueOf(queue.poll());
        TreeNode root = new TreeNode(value);
        de(queue,root);
        return root;
    }

    public void de(Queue<String> queue,TreeNode node){
        if (queue == null)
            return;

        if (queue.peek().equals("#")) {
            node.left = null;
            queue.poll();
        }else {
            node.left = new TreeNode(Integer.valueOf(queue.poll()));
            de(queue,node.left);
        }
        if (queue.peek().equals("#")){
            node.right = null;
            queue.poll();
        }else {
            node.right = new TreeNode(Integer.valueOf(queue.poll()));
            de(queue,node.right);
        }

    }















    public void arrayToNode(String[] st,TreeNode node,int index ,int len){
        if (node == null)
            return;
        if (index*2+1<len&&!st[index*2+1].equals("null")){
            node.left = new TreeNode(Integer.valueOf(st[index*2+1]));
            arrayToNode(st,node.left,index*2+1,len);
        }
        if (index*2+2 < len&&!st[index*2+2].equals("null")){
            node.right = new TreeNode(Integer.valueOf(st[index*2+2]));
            arrayToNode(st,node.right,index*2+2,len);
        }
    }

    /**
     * 存储到数组中
     *
     */
    public void toArray(String[] st,TreeNode node,int index){

        st[index] = String.valueOf(node.val);
        if (node.left != null){
            toArray(st,node.left,index*2+1);
        }
        if (node.right != null)
            toArray(st,node.right,index*2+2);
    }

    /**
     * 序列化操作
     */
    public void seHandle(String[] st,TreeNode node,int index){
        String[] s = new String[3];
        s[1] = String.valueOf(node.val);
        return;
    }

    //递归+回溯得到树深度
    public int depth(TreeNode root,int level){
        if (root == null)
            return level;
        int left = root.left==null?level:depth(root.left,level+1);
        int right = root.right==null?level:depth(root.right,level+1);

        return Math.max(left,right);
    }
}
