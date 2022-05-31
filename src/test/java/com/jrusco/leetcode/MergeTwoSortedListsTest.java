package com.jrusco.leetcode;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

//https://leetcode.com/problems/merge-two-sorted-lists/submissions/
public class MergeTwoSortedListsTest {
    
    @Test
    public void test(){
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3));
        // ListNode expected = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        assertNotNull(mergeTwoLists(l1, l2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode merged = node;
        while(l1 != null && l2 != null){
            if (l1.val < l2.val){
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        if (l1 == null){
            node.next = l2;
        } else if (l2 == null){
            node.next = l1;
        }

        return merged.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
