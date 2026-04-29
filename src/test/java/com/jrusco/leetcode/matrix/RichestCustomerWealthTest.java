package com.jrusco.leetcode.matrix;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * https://leetcode.com/problems/richest-customer-wealth/description/?envType=problem-list-v2&envId=matrix
 * 
 * == Challenge ==
 * You are given an m x n integer grid accounts where accounts[i][j] is the
 * amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​
 * bank. Return the wealth that the richest customer has.
 * 
 * A customer's wealth is the amount of money they have in all their bank
 * accounts. The richest customer is the customer that has the maximum wealth.
 * 
 * == My notes ==
 * 
 *  
 */
public class RichestCustomerWealthTest {

    @Test
    public void test(){
        int[][] accounts = {{1,2,3},{3,2,1}};
        assertEquals(6, maximumWealth(accounts));

        int[][] accounts2 = { { 1, 5 }, { 7,3 }, {3,5} };
        assertEquals(10, maximumWealth(accounts2));

        int[][] accounts3 = { { 2,8,7 }, { 7,1,3 }, { 1,9,5 } };
        assertEquals(17, maximumWealth(accounts3));
    }

    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        //i = customer
        for (int i = 0; i < accounts.length; i++) {
            int customerWealth = 0;
            //j = bank account's balances (each j a different bank)
            for (int j = 0; j < accounts[i].length; j++) {
                customerWealth += accounts[i][j];
            }
            maxWealth = customerWealth > maxWealth ? customerWealth : maxWealth;
        }
        return maxWealth;
    }

    
}
