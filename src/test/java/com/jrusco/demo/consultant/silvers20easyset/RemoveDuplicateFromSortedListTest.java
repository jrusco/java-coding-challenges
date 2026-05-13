package com.jrusco.demo.consultant.silvers20easyset;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list
 * 
 * == My Notes ==
 * - 
 */
public class RemoveDuplicateFromSortedListTest {
    
    @Test
    public void test(){
        // CASE 1
        // Input: head = [1,1,2] Output: [1,2]
        ListNode case1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        assertArrayEquals(new int[]{1, 2}, toArray(deleteDuplicates(case1)));

        // CASE 2
        // Input: head = [1,1,2,3,3] Output: [1,2,3]
        ListNode case2 = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        assertArrayEquals(new int[]{1, 2, 3}, toArray(deleteDuplicates(case2)));
    
        // CASE 3
        // Input: head = [1,1,1] Output: [1]
        ListNode case3 = new ListNode(1, new ListNode(1, new ListNode(1)));
        assertArrayEquals(new int[] {1}, toArray(deleteDuplicates(case3)));

    }

    /**
     * This is the LeetCode solution
     */
    public ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val){
                current.next = current.next.next;
            } else {
                //only move forward when the next one is not duplicate
                //so, if next is rewired, stay on current and re-check its next
                current = current.next;
            }
        }
        return head;
    }

    /**
     * aux method for asserting test cases
     */
    private int[] toArray(ListNode node) {
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Definition provided in the challenge
     */
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
