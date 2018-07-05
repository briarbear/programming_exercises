package nowcoder;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrintFromTopToBottomTest {

    @Test
    public void print() {
        var s = new PrintFromTopToBottom();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        s.print(root);
    }
}