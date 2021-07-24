package com.jrusco.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class MaxProfitTest {
    
    @Test
    public void test(){
        assertEquals(0, maxProfit(new int[]{7}));
        assertEquals(7, maxProfit(new int[]{7,1,5,3,6,4}));
        assertEquals(4, maxProfit(new int[]{1,2,3,4,5}));
        assertEquals(0, maxProfit(new int[]{7,6,4,3,1}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2){
            return 0;
        }
        int profit = 0;
        for (int i = 0; i < prices.length -1; i++) {
            if (prices[i + 1] > prices[i]){
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
    
}
