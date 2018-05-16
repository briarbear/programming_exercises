package leetcode.ch1;

import leetcode.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class S103Test {

    @Test
    public void zigzagLevelOrder() {

        S103 s = new S103();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left = new TreeNode(7);

        s.zigzagLevelOrder2(root);




    }
}