package nowcoder;

import leetcode.InstanceUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReBuildTreeTest {

    @Test
    public void reConstructBinaryTree() throws Exception {
        int[] pre = new int[]{1,2,4,7,3,5,6,8};
        int[] in = new int[]{4,7,2,1,5,3,8,6};
        TreeNode node = InstanceUtils.get(ReBuildTree.class).reConstructBinaryTree(pre,in);

        System.out.println("");
    }
}