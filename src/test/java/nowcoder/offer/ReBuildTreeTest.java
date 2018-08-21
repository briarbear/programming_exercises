package nowcoder.offer;

import leetcode.InstanceUtils;
import nowcoder.offer.ReBuildTree;
import nowcoder.offer.TreeNode;
import org.junit.Test;

public class ReBuildTreeTest {

    @Test
    public void reConstructBinaryTree() throws Exception {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        TreeNode node = InstanceUtils.get(ReBuildTree.class).reConstructBinaryTree(pre,in);

        System.out.println("");
    }
}