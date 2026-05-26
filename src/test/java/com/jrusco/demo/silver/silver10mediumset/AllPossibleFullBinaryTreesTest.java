package com.jrusco.demo.silver.silver10mediumset;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 *      ** This solution needs reviewing **
 * 
 * 
 * https://leetcode.com/problems/all-possible-full-binary-trees
 *
 * Given an integer n, return a list of all possible full binary trees with n
 * nodes. Each node of each tree in the answer must have Node.val == 0.
 *
 * Each element of the answer is the root node of one possible tree. You may
 * return the final list of trees in any order.
 *
 * A full binary tree is a binary tree where each node has exactly 0 or 2
 * children.
 *
 * == My Notes ==
 * - Full binary trees always have an odd number of nodes (root + pairs of children), so even n always returns empty.
 * - Fix the root, then try every odd split of the remaining n-1 nodes between left and right subtrees.
 * - right = n - 1 - left (the -1 accounts for the root itself).
 * - left += 2 skips even splits since both subtrees must also be full binary trees (odd node count).
 * - Combine results with a nested loop: every left tree paired with every right tree under a new root (cartesian product).
 */
public class AllPossibleFullBinaryTreesTest {

    @Test
    public void test() {

        /**
         * Input: n = 1
         * Output: [[0]]
         */
        assertEquals(1, allPossibleFBT(1).size());

        /**
         * Input: n = 3
         * Output: [[0,0,0]]
         */
        assertEquals(1, allPossibleFBT(3).size());

        /**
         * Input: n = 7
         * Output:
         * [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
         */
        assertEquals(5, allPossibleFBT(7).size());

        // Edge case: even n —> no full binary tree possible
        assertEquals(0, allPossibleFBT(2).size());
    }

    private List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) return new ArrayList<>();
        if (n == 1) return Arrays.asList(new TreeNode(0));

        List<TreeNode> result = new ArrayList<>();

        for (int left = 1; left < n; left += 2) {
            int right = n - 1 - left;
            for (TreeNode l : allPossibleFBT(left)) {
                for (TreeNode r : allPossibleFBT(right)) {
                    result.add(new TreeNode(0, l, r));
                }
            }
        }

        return result;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val; this.left = left; this.right = right;
        }
    }
}
