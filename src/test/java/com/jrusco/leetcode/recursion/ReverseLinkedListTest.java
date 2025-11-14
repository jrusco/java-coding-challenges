package com.jrusco.leetcode.recursion;

import static org.junit.Assert.assertEquals;

import java.util.Objects;

import org.junit.Test;

//https://leetcode.com/problems/reverse-linked-list
public class ReverseLinkedListTest {
    
    @Test
    public void test(){
        ListNode expected = new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1)))));
        ListNode original = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        assertEquals(expected, reverseList(original));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * Provided definition for singly-linked list.
     */
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        //added this to work with test assertions
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            ListNode other = (ListNode) obj;
            return val == other.val && 
                Objects.equals(next, other.next);
        }
        
        // added this to work with test assertions
        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }
}
