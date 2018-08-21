package nowcoder.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印二叉树
 *
 * @author briarbear
 * @blog https://briarbear.github.io
 * @create 2018-07-04-20:07
 */
public class PrintFromTopToBottom {

    /**
     * 层次遍历
     * @param root
     * @return
     */
    public ArrayList<Integer> print(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        //借助队列实现
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); //插入头节点

        while (!queue.isEmpty()){
            //从队列中取出一个节点
            TreeNode node = queue.poll();
            res.add(node.val);

            //然后将该节点的左右子树插入到队列尾部
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }

        return res;
    }
}
