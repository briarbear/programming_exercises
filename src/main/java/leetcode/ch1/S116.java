package leetcode.ch1;

import leetcode.data_structure.TreeLinkNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 116 填充同一层的兄弟节点
 * 116. Populating Next Right Pointers in Each Node
 */
public class S116 {

    /**
     * 感觉就是层次遍历的应用,非递归的方式
     *
     * @param root
     */
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        if (root == null)
            return;
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            TreeLinkNode temp = null;
            for (int i = 0; i < len; i++) {
                TreeLinkNode node = queue.poll();
                if (node.left != null){
                    //只要子节点不为空，这说明有两个子节点
                    queue.add(node.left);
                    queue.add(node.right);

                    node.left.next = node.right;
                    if (temp != null)
                        temp.next = node.left;
                    temp = node.right;
                }

            }


        }
    }

    /**
     * 递归的实现方式
     * @param root
     */
    public void connect2(TreeLinkNode root){
        //递归的实现方式
        if (root == null)
            return;
        if (root.left != null){
            root.left.next = root.right;
            if (root.next != null)
                root.right.next = root.next.left;
        }

        connect2(root.left);
        connect2(root.right);
    }
}
