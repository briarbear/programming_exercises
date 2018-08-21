package nowcoder.offer;

import nowcoder.offer.HasSubtree;
import nowcoder.offer.TreeNode;
import org.junit.Test;

public class HasSubtreeTest {

    @Test
    public void hasSubtree() {
        HasSubtree s = new HasSubtree();
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);

        System.out.println(s.HasSubtree(root1, root2));
    }
}