package nowcoder.offer;

import nowcoder.offer.FindPath;
import nowcoder.offer.TreeNode;
import org.junit.Test;

public class FindPathTest {

    @Test
    public void findPath() {
        FindPath path = new FindPath();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        path.FindPath(root,8);
    }
}