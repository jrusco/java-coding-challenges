package com.jrusco.demo.silver.silver10mediumset;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * 
 *          ** This solution needs reviewing **
 * 
 * 
 * https://leetcode.com/problems/shopping-offers
 * 
 * In LeetCode Store, there are n items to sell. Each item has a price. However,
 * there are some special offers, and a special offer consists of one or more
 * different kinds of items with a sale price.
 * 
 * You are given an integer array price where price[i] is the price of the ith
 * item, and an integer array needs where needs[i] is the number of pieces of
 * the ith item you want to buy.
 * 
 * You are also given an array special where special[i] is of size n + 1 where
 * special[i][j] is the number of pieces of the jth item in the ith offer and
 * special[i][n] (i.e., the last integer in the array) is the price of the ith
 * offer.
 * 
 * Return the lowest price you have to pay for exactly certain items as given,
 * where you could make optimal use of the special offers. You are not allowed
 * to buy more items than you want, even if that would lower the overall price.
 * You could use any of the special offers as many times as you want.
 * 
 * 
 * == My Notes ==
 * - DFS + memoization: state is the current needs list. Multiple offer sequences
 *   can converge to the same remaining needs, so caching by needs eliminates redundant sub-trees.
 * - Baseline (buy individually) runs at every recursive level, not just at zero.
 *   This handles mixing an offer with individual purchases for the remainder.
 * - Apply-recurse-restore (backtracking): mutate needs, recurse, unmutate.
 *   needs is a shared mutable reference across the call stack. Without the restore,
 *   the next offer sees needs already consumed by the previous branch.
 * - Memo key must be a copy (new ArrayList<>(needs)), not the live reference.
 *   The reference changes value during backtracking and would corrupt the cache.
 * - Class-field memo is only safe when price and special are fixed across calls.
 *   Safer: local HashMap created per top-level call, passed to a private helper.
 */
public class ShoppingOffersTest {

    

    @Test
    public void test(){
        /**
         * Example 1:
         * 
         * Input: price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
         * Output: 14
         * Explanation: There are two kinds of items, A and B. Their prices are $2 and
         * $5 respectively.
         * In special offer 1, you can pay $5 for 3A and 0B
         * In special offer 2, you can pay $10 for 1A and 2B.
         * You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer
         * #2), and $4 for 2A.
         * 
         */
        assertEquals(14, shoppingOffers(
            Arrays.asList(2, 5),
            Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10)),
            Arrays.asList(3, 2)
        ));

        /**
         * Example 2:
         *
         * Input: price = [2,3,4], special = [[1,1,0,4],[2,2,1,9]], needs = [1,2,1]
         * Output: 11
         * Explanation: The price of A is $2, and $3 for B, $4 for C.
         * You may pay $4 for 1A and 1B, and $9 for 2A ,2B and 1C.
         * You need to buy 1A ,2B and 1C, so you may pay $4 for 1A and 1B (special offer
         * #1), and $3 for 1B, $4 for 1C.
         * You cannot add more items, though only $9 for 2A ,2B and 1C.
         *
         */
        assertEquals(11, shoppingOffers(
            Arrays.asList(2, 3, 4),
            Arrays.asList(Arrays.asList(1, 1, 0, 4), Arrays.asList(2, 2, 1, 9)),
            Arrays.asList(1, 2, 1)
        ));

        // Edge case: no special offers — pay full price per item
        assertEquals(7, shoppingOffers(
            Arrays.asList(2, 5),
            Arrays.asList(),
            Arrays.asList(1, 1)
        ));
    }

    private final Map<List<Integer>, Integer> memo = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

        // MEMO CHECK: if this needs state was already solved, return the cached result.
        // Each unique needs state is computed exactly once, regardless of how many paths lead to it.
        // This prevents the exponential blowup from recomputing identical sub-states.
        if (memo.containsKey(needs)) return memo.get(needs);

        // BASELINE: cost of buying every remaining item at its individual price.
        // Buying without any offer is always valid, so this is the starting minimum to beat.
        int sum = 0;
        for (int i = 0; i < needs.size(); i++) {
            sum += price.get(i) * needs.get(i);
        }

        // OFFER LOOP: try each special offer and update the minimum if it yields a lower cost.
        // Recursing after applying each offer naturally handles repeated use of the same offer.
        for (List<Integer> offer : special) {

            // APPLICABILITY CHECK: the problem forbids buying more items than needed.
            // An offer is only valid if every item quantity fits within what is still needed.
            // If any single item would be over-bought, the whole offer is skipped.
            boolean applicable = true;
            for (int i = 0; i < needs.size(); i++) {
                if (offer.get(i) > needs.get(i)) {
                    applicable = false;
                    break;
                }
            }
            if (!applicable) continue;

            // APPLY: subtract the offer quantities from needs.
            // needs[i] now reflects only what still needs to be purchased after this offer.
            for (int i = 0; i < needs.size(); i++) {
                needs.set(i, needs.get(i) - offer.get(i));
            }

            // RECURSE: find the minimum cost for the remaining needs after this offer.
            // offer.get(needs.size()) is the last element of the offer list, which is its price.
            // Adding it to the recursive result gives the total cost of this decision branch.
            int candidate = offer.get(needs.size()) + shoppingOffers(price, special, needs);
            sum = Math.min(sum, candidate);

            // BACKTRACK: restore needs so the next offer is evaluated against the original state.
            // Without this, each offer would see a needs list already modified by the previous one.
            for (int i = 0; i < needs.size(); i++) {
                needs.set(i, needs.get(i) + offer.get(i));
            }
        }

        // MEMO PUT: store a snapshot copy of needs as the key, not the live reference.
        // needs is mutated in-place during backtracking, so storing the reference would corrupt the cache.
        memo.put(new ArrayList<>(needs), sum);
        return sum;
    }

}
