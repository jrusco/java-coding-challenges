package com.jrusco.demo.silver.silver10mediumset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * https://leetcode.com/problems/find-duplicate-subtrees
 *
 * Given the root of a binary tree, return all duplicate subtrees.
 * For each kind of duplicate subtrees, you only need to return the root node of
 * any one of them.
 * Two trees are duplicate if they have the same structure with the same node
 * values.
 *
 * == My Notes ==
 * - Post-order's left,right,val places the value last as a natural terminator,
 * keeping subtree boundaries unambiguous. In-order would place the node's value
 * in the middle of the string (not clear / prone to further parsing therefore
 * building an artificial `post-order` type of result).
 * - parameter-passing pattern in recursion: use when you not only need a
 * "local" result (i.e. the output of the recursion) but also a "global" result
 * the whole traversal builds as it goes (i.e. contributing to a states that
 * outlives any single method call -like recurrence tracking-)
 * - `if (ocurrences.get(key) == 2) ...` happens only once for repeating results, which helps avoiding having duplicated entries in the outbound List.
 */
public class FindDuplicateSubtreesTest {

    @Test
    public void test() {
        /**
         * Case 1
         *
         * Input: root = [1,2,3,4,null,2,4,null,null,4]
         * Output: [[2,4],[4]]
         *
         *         1
         *        / \
         *       2   3
         *      /   / \
         *     4   2   4
         *        /
         *       4
         */
        TreeNode root1 = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), null),
            new TreeNode(3,
                new TreeNode(2, new TreeNode(4), null),
                new TreeNode(4)));
        List<TreeNode> result1 = findDuplicateSubtrees(root1);
        assertEquals(2, result1.size());
        assertTrue(result1.stream().anyMatch(n -> n.val == 2));
        assertTrue(result1.stream().anyMatch(n -> n.val == 4));

        /**
         * Case 2
         *
         * Input: root = [2,1,1]
         * Output: [[1]]
         *
         *     2
         *    / \
         *   1   1
         */
        TreeNode root2 = new TreeNode(2, new TreeNode(1), new TreeNode(1));
        List<TreeNode> result2 = findDuplicateSubtrees(root2);
        assertEquals(1, result2.size());
        assertEquals(1, result2.get(0).val);

        /**
         * Case 3
         *
         * Input: root = [2,2,2,3,null,3,null]
         * Output: [[2,3],[3]]
         *
         *       2
         *      / \
         *     2   2
         *    /   /
         *   3   3
         */
        TreeNode root3 = new TreeNode(2,
            new TreeNode(2, new TreeNode(3), null),
            new TreeNode(2, new TreeNode(3), null));
        List<TreeNode> result3 = findDuplicateSubtrees(root3);
        assertEquals(2, result3.size());
        assertTrue(result3.stream().anyMatch(n -> n.val == 2));
        assertTrue(result3.stream().anyMatch(n -> n.val == 3));
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        if (root == null) return new ArrayList<>();

        List<TreeNode> duplicated = new ArrayList<>();
        Map<String, Integer> ocurrences = new HashMap();

        postOrderSerialization(root, ocurrences, duplicated);
        
        return duplicated;
    }

    String postOrderSerialization(TreeNode root, Map<String, Integer> ocurrences, List<TreeNode> duplicated){
        if (root == null) return "#";

        String key = postOrderSerialization(root.left, ocurrences, duplicated)
                + ","
                + postOrderSerialization(root.right, ocurrences, duplicated)
                + ","
                + root.val;

        ocurrences.put(key, ocurrences.getOrDefault(key, 0) + 1);

        if (ocurrences.get(key) == 2){
            duplicated.add(root);
        }

        return key;
    }

    public class TreeNode {
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
