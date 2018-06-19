package leetcode.ch2;

import leetcode.InstanceUtils;
import leetcode.data_structure.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class S297Test {

    @Test
    public void depth() throws Exception {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        System.out.println(InstanceUtils.get(S297.class).depth(root, 1));
    }

    @Test
    public void serialize() throws Exception {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        InstanceUtils.get(S297.class).serialize(root);
    }
}