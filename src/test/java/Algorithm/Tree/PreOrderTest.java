package Algorithm.Tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class PreOrderTest {

    @Test
    public void order() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        PreOrder o = new PreOrder();
        o.order2(root);

    }
}