package com.jrusco.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

//https://leetcode.com/problems/range-sum-of-bst/submissions/
public class RangeSumBstTest {

    @Test
    public void test(){
        TreeNode left = new TreeNode(5, new TreeNode(3), new TreeNode(7));
        TreeNode right = new TreeNode(15, new TreeNode(), new TreeNode(18));
        TreeNode root = new TreeNode(10, left, right);
        assertEquals(32, rangeSumBST(root,7,15));
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        int rangeSum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            rangeSum += node.val >= low && node.val <= high? node.val : 0;

            if (node.left != null && node.val > low){
                stack.push(node.left);
            }
            if (node.right != null && node.val < high){
                stack.push(node.right);
            }
        }

        return rangeSum;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
