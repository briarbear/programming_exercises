package leetcode.ch9;

import leetcode.data_structure.TreeNode;
import org.junit.Test;

import java.util.List;

public class S94Test {

    @Test
    public void inorderTraversal() {

        S94 s = new S94();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> res = s.inorderTraversal2(root);
        System.out.println("");
    }
}