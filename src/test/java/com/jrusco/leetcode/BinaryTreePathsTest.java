package com.jrusco.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class BinaryTreePathsTest {
    
    @Test
    public void test(){
        TreeNode tree = new TreeNode(
        //root
        1, 
        //left
        new TreeNode(2, new TreeNode(), new TreeNode(5)), 
        //right
        new TreeNode(3));
        assertEquals(Arrays.asList("1->2->5","1->3"), binaryTreePaths(tree));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root.left == null && root.right == null){
            return Arrays.asList(root.val + "");
        }

        List<String> paths = new LinkedList<>();
        dfs(root, "", paths);
        return paths;
    }

    private void dfs(TreeNode node, String currentPath, List<String> paths) {
        currentPath += String.valueOf(node.val);
        if (node.left == null && node.right == null){
            paths.add(currentPath);
            return;
        } else {
            currentPath += "->";
        }
        if (node.left != null && node.left.val != 0){
            dfs(node.left, currentPath, paths);
        }
        if (node.right != null && node.right.val != 0){
            dfs(node.right, currentPath, paths);
        }
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
