package leetcode.ch1;

import leetcode.data_structure.TreeNode;
import org.junit.Test;

public class S105Test {

    @Test
    public void buildTree() {

        S105 s  = new S105();
        int[] preOrder = new int[]{1,2,4,5,8,3,6,7};
        int[] inOrder = new int[]{4,2,8,5,1,6,3,7};

        TreeNode root = s.buildTree(preOrder,inOrder);

        System.out.println("              ");
    }
}