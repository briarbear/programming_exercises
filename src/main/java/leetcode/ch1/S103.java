package leetcode.ch1;

import leetcode.TreeNode;

import java.util.*;

/**
 * 103
 * 二叉树的锯齿形层次遍历
 */
public class S103 {

    /**
     * 原始实现版
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //二叉树的层次遍历 借助两个队列与标记标量，实现层次遍历
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queueTemp = new LinkedList<>();
        boolean flag = false;

        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        queue.offer(root);

        while (!queue.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queueTemp.offer(node.left);
                if (node.right != null)
                    queueTemp.offer(node.right);

                list.add(node.val);
            }


            if (flag)
                Collections.reverse(list);
            res.add(list);
            queue = (Queue<TreeNode>) ((LinkedList<TreeNode>) queueTemp).clone();
            queueTemp.clear();
            flag = !flag;
        }

        return res;

    }

    /**
     * leetcode 讨论版 递归思路
     * 二叉树的先序遍历-递归方案
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        help(root, 0, res, false);
        return res;
    }

    public void help(TreeNode root, int level, List<List<Integer>> res, boolean flag) {
        if (root == null)
            return;
        List<Integer> list = null;
        if (res.size() == level) {
            list = new ArrayList<>();
            res.add(list);
        } else {
            list = res.get(level);
        }
        if (flag)
            list.add(0, root.val);
        else
            list.add(root.val);

        help(root.left, level + 1, res, !flag);
        help(root.right, level + 1, res, !flag);

    }

    /**
     * 原始版优化版
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder3(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left!=null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            if (flag)
                Collections.reverse(list);
            flag = !flag;
            res.add(list);
        }

        return res;
    }
}
