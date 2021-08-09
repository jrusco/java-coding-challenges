package com.jrusco.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

//https://leetcode.com/problems/intersection-of-two-linked-lists/
public class IntersectionOfTwoLinkedListsTest {
    
    @Test
    public void test(){
        ListNode listA = new ListNode(1, new ListNode(9));
        ListNode listB = null;
        assertEquals(null, getIntersectionNode(listA, listB));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        
        Set<ListNode> nodesSet = new HashSet<>();
        while (headA != null) {
            nodesSet.add(headA);
            headA = headA.next;
        }

        while (!nodesSet.contains(headB) && headB != null) {
            headB = headB.next;
        }

        return headB;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode(int x, ListNode n) {
            val = x;
            next = n;
        }
    }
}
