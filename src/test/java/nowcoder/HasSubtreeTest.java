package nowcoder;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HasSubtreeTest {

    @Test
    public void hasSubtree() {
        var s = new HasSubtree();
        var root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);

        var root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);

        System.out.println(s.HasSubtree(root1, root2));
    }
}