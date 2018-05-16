package leetcode.ch9;

import leetcode.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

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