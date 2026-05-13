package com.jrusco.demo.consultant.silvers20easyset;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * https://leetcode.com/problems/symmetric-tree
 *
 * Given the root of a binary tree, check whether it is a mirror of itself
 * (i.e., symmetric around its center).
 *
 * == My Notes ==
 * -
 */
public class SymmetricTreeTest {

    @Test
    public void test(){
        // CASE 1: root = [1,2,2,3,4,4,3] → true
        TreeNode root1 = new TreeNode(1,
            new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        assertTrue(isSymmetric(root1));

        // CASE 2: root = [1,2,2,null,3,null,3] → false
        TreeNode root2 = new TreeNode(1,
            new TreeNode(2, null, new TreeNode(3)),
            new TreeNode(2, null, new TreeNode(3)));
        assertFalse(isSymmetric(root2));
    }

    public boolean isSymmetric(TreeNode root) {
        
        if (root == null){
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left == null || right == null)) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }



    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
