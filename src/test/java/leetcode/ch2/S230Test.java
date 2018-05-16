package leetcode.ch2;

import leetcode.data_structure.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class S230Test {

    @Test
    public void kthSmallest() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        S230 s = new S230();
        Assert.assertEquals(4,s.kthSmallest(root,3));
        System.out.println(s.kthSmallest(root, 3));
    }
}