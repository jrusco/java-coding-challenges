package com.jrusco.demo.silver.silver10mediumset;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

/**
 * https://leetcode.com/problems/keys-and-rooms
 * 
 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except
 * for room 0. Your goal is to visit all the rooms. However, you cannot enter a
 * locked room without having its key.
 * 
 * When you visit a room, you may find a set of distinct keys in it. Each key
 * has a number on it, denoting which room it unlocks, and you can take all of
 * them with you to unlock the other rooms.
 * 
 * Given an array rooms where rooms[i] is the set of keys that you can obtain if
 * you visited room i, return true if you can visit all the rooms, or false
 * otherwise.
 * 
 * 
 * == My Notes ==
 * - "Collecting all keys" != reachability: a flat scan (for loop) answers "do keys exist?", not "can I reach this room?"
 * - Linear for-loop can't model graph traversal! backward edges (high index unlocks low index) get missed.
 * - Pattern: visited Set + Stack as worklist → seed with start node, pop and process, push unvisited neighbors.
 * - Trees use the same pattern but skip the visited set (no cycles by definition).
 * 
 * 
 * - Why this is DFS?
 * 
A Stack gives you LIFO (last in, first out). When you push multiple keys and then pop, you go deeper into the most recently discovered path before backtracking. You're diving deep into one branch before exploring others.
 *
 */
public class KeysAndRoomsTest {
    
    @Test
    public void test(){
        /**
         * Example 1:
         *
         * Input: rooms = [[1],[2],[3],[]]
         * Output: true
         * Explanation:
         * We visit room 0 and pick up key 1.
         * We then visit room 1 and pick up key 2.
         * We then visit room 2 and pick up key 3.
         * We then visit room 3.
         * Since we were able to visit every room, we return true.
         */
        assertTrue(canVisitAllRooms(List.of(
            List.of(1),
            List.of(2),
            List.of(3),
            List.of()
        )));

        /**
         * Example 2:
         *
         * Input: rooms = [[1,3],[3,0,1],[2],[0]]
         * Output: false
         * Explanation: We can not enter room number 2 since the only key that unlocks
         * it is in that room.
         */
        assertFalse(canVisitAllRooms(List.of(
            List.of(1, 3),
            List.of(3, 0, 1),
            List.of(2),
            List.of(0)
        )));

        /**
         * Test case 3
         * 
         * rooms = [[6,7,8],[5,4,9],[],[8],[4],[],[1,9,2,3],[7],[6,5],[2,3,1]]
         * output = true
         */
        assertTrue(canVisitAllRooms(List.of(
            List.of(6, 7, 8),
            List.of(5, 4, 9),
            List.of(),
            List.of(8),
            List.of(4),
            List.of(),
            List.of(1, 9, 2, 3),
            List.of(7),
            List.of(6, 5),
            List.of(2, 3, 1)
        )));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Stack<Integer> toVisit = new Stack<>();
        toVisit.addAll(rooms.get(0));

        while (!toVisit.isEmpty()) {
            Integer keyFound = toVisit.pop();
            if (!visited.contains(keyFound)){
                visited.add(keyFound);
                toVisit.addAll(rooms.get(keyFound));
            }
        }

        return visited.size() == rooms.size();
    }
}
