package com.jrusco.demo.silver.silver10mediumset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator
 *
 * Implement the BSTIterator class that represents an iterator over the in-order
 * traversal of a binary search tree (BST):
 *
 * BSTIterator(TreeNode root) Initializes an object of the BSTIterator class.
 * The root of the BST is given as part of the constructor. The pointer should
 * be initialized to a non-existent number smaller than any element in the BST.
 * boolean hasNext() Returns true if there exists a number in the traversal to
 * the right of the pointer, otherwise returns false.
 * int next() Moves the pointer to the right, then returns the number at the
 * pointer.
 *
 * Notice that by initializing the pointer to a non-existent smallest number,
 * the first call to next() will return the smallest element in the BST.
 *
 * You may assume that next() calls will always be valid. That is, there will be
 * at least a next number in the in-order traversal when next() is called.
 * 
 * Follow up:
 * Could you implement next() and hasNext() to run in average O(1) time and use
 * O(h) memory, where h is the height of the tree?
 * 
 *
 * 
 * == My Notes ==
 * - pushLeftSpine() is the core pattern for in-order traversal. Push root and all its left descendants. It works in next() too because once a node is consumed, its right subtree is just another BST to run the same logic on.
 * - This way, space is O(h) not O(n): the stack only ever holds one root-to-leaf path at a time, so for a balanced BST that's O(log n). That's the whole point vs. flattening upfront.
 * 
 */
public class BinarySearchTreeIteratorTest {

    @Test
    public void test() {
        /**
         * Input: [7, 3, 15, null, null, 9, 20]
         *         7
         *        / \
         *       3   15
         *          /  \
         *         9   20
         *
         * Output: [null, 3, 7, true, 9, true, 15, true, 20, false]
         */
        TreeNode root = new TreeNode(7,
                new TreeNode(3),
                new TreeNode(15, new TreeNode(9), new TreeNode(20)));

        BSTIterator bSTIterator = new BSTIterator(root);
        assertEquals(3, bSTIterator.next());
        assertEquals(7, bSTIterator.next());
        assertTrue(bSTIterator.hasNext());
        assertEquals(9, bSTIterator.next());
        assertTrue(bSTIterator.hasNext());
        assertEquals(15, bSTIterator.next());
        assertTrue(bSTIterator.hasNext());
        assertEquals(20, bSTIterator.next());
        assertFalse(bSTIterator.hasNext());
    }

    class BSTIterator {

        private Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            pushLeftSpine(stack, root);
        }

        public int next() {
            TreeNode next = stack.pop();
            pushLeftSpine(stack, next.right);
            return next.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        private void pushLeftSpine(Stack<TreeNode> stack, TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
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
