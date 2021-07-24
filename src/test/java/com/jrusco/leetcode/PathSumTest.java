package com.jrusco.leetcode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

//https://leetcode.com/problems/path-sum/
public class PathSumTest {
    
    @Test
    public void test0(){
        //root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        assertTrue(hasPathSum(
            new TreeNode(5, 
            new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), 
            new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))), 
            22));
    }

    @Test
    public void test1(){
      //root = [1,2,3], targetSum = 5
      assertFalse(hasPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 5));
    }

    @Test
    public void test2(){
      //root = [1,2], targetSum = 0
      assertFalse(hasPathSum(new TreeNode(1, new TreeNode(2), null), 0));
    }

    @Test
    public void test3(){
      //[-2,null,-3], targetSum = -5
      assertTrue(hasPathSum(new TreeNode(-2, null, new TreeNode(-3)), -5));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
          return false;
        } else if (root.left == null && root.right == null){
          return targetSum - root.val == 0;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
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
