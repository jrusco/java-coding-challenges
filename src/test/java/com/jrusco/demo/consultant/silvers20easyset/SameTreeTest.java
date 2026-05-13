package com.jrusco.demo.consultant.silvers20easyset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * https://leetcode.com/problems/same-tree
 * 
 * Given the roots of two binary trees p and q, write a function to check if
 * they are the same or not.
 * 
 * Two binary trees are considered the same if they are structurally identical,
 * and the nodes have the same value.
 * 
 * == My Notes ==
 * -
 */
public class SameTreeTest {

    @Test
    public void test(){

        // CASE 1: p = [1,2,3], q = [1,2,3] → true
        TreeNode p1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertTrue(isSameTree(p1, q1));

        // CASE 2: p = [1,2], q = [1,null,2] → false
        TreeNode p2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode q2 = new TreeNode(1, null, new TreeNode(2));
        assertFalse(isSameTree(p2, q2));

        // CASE 3: p = [1,2,1], q = [1,1,2] → false
        TreeNode p3 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode q3 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        assertFalse(isSameTree(p3, q3));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // BASE CASES: one or both are null, or they arent and they have different values
        if (p == null && q == null){
            return true;
        }
        //i know both are not null, so if one of them is null at this point, means they differ.
        if ((p == null || q == null)){
            return false;
        }
        if (p.val != q.val){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
