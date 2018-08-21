package nowcoder.offer;

import java.util.*;

/**
 * 二叉树中 和为某一值的路径
 *
 * @auther briarbear
 * @blog http://briarbear.github.io
 * @create 2018-07-12-22:11
 */
public class FindPath {


    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private int target;
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        this.target = target;

        LinkedList<Integer> list = new LinkedList<>();
        if (root == null)
            return res;
        helper(root,0,list);

        //再对list排序
        res.sort(Comparator.comparingInt(o -> -1*o.size()));



        return res;


    }


    //DFS深度优先遍历 + 回溯
    public void helper(TreeNode node,int temp,LinkedList<Integer> list){

        list.add(node.val);
        temp += node.val;
        if (node.left == null && node.left == null){
            //则为叶子节点
            if (temp == target)
                res.add(new ArrayList<>(list));
            return;
        }

        if (temp > target)
            return;



        if (node.left != null){
            helper(node.left,temp,list);
            list.removeLast();
        }
        if (node.right != null){
            helper(node.right,temp,list);
            list.removeLast();
        }


    }


}
