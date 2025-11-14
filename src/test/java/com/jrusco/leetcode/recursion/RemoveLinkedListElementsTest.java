package com.jrusco.leetcode.recursion;

import static org.junit.Assert.assertEquals;

import java.util.Objects;

import org.junit.Test;

//https://leetcode.com/problems/remove-linked-list-elements
public class RemoveLinkedListElementsTest {
    
    @Test
    public void test(){
        /*
         * Input: head = [1,2,6,3,4,5,6], val = 6
         * Output: [1,2,3,4,5]
         */
        ListNode expected = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode original = new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6)))))));
        assertEquals(expected, removeElements(original, 6));
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }

        head.next = removeElements(head.next, val);

        return val == head.val ? head.next : head;
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
