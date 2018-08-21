package nowcoder.offer;

import org.junit.Test;

public class ConvertTest {

    @Test
    public void convert() {
        TreeNode root = TreeUtils.t1();
        Convert s = new Convert();
//        s.convert(root);

        TreeNode n = new TreeNode(5);
        n.left = new TreeNode(4);
        n.left.left = new TreeNode(3);
        n.left.left.left = new TreeNode(2);
        n.left.left.left.left = new TreeNode(1);
        s.convert(n);
    }
}