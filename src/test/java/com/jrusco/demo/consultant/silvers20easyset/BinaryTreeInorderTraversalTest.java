package com.jrusco.demo.consultant.silvers20easyset;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal
 *
 * == My Notes ==
 * -
 */
public class BinaryTreeInorderTraversalTest {

    @Test
    public void test(){

        // CASE 1
        // Input: root = [1,null,2,3] Output: [1,3,2]
        TreeNode case1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        assertArrayEquals(new int[]{1, 3, 2}, toArray(inorderTraversal(case1)));

        // CASE 2
        // Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
        // Output: [4,2,6,5,7,1,3,9,8]
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8, node9, null);
        TreeNode node3 = new TreeNode(3, null, node8);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5, new TreeNode(6), new TreeNode(7));
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode case2 = new TreeNode(1, node2, node3);
        assertArrayEquals(new int[]{4, 2, 6, 5, 7, 1, 3, 9, 8}, toArray(inorderTraversal(case2)));
    }

    // ============= LeetCode answer =======================
    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null){
            return Collections.emptyList();
        }

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()){
            while (current != null){
                stack.push(current);
                current = current.left;
            }

            TreeNode node = stack.pop();
            list.add(node.val);
            current = node.right;
        }

        return list;
    }
    // ============= LeetCode answer =======================

    private int[] toArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public class TreeNode {
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
