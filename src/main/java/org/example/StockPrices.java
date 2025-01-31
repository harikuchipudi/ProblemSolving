package org.example;

import java.util.Arrays;

public class StockPrices {

    public static void maxProfit(int[] prices){
        //recursion
        int res = findMaxProfit(prices, 0, 0, 0);
        System.out.println("Recursion : " + res);

        int n = prices.length;

        //memoization
        int[][] dp = new int[n][2];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        int result = memoization(prices, 0, 0, 0, dp);
        System.out.println("Memoization : " + result);
    }

    //recursion
    public static int findMaxProfit(int[] prices, int i, int trades, int trade){
        if(trades == 2){
            return 0;
        }

        if(i==prices.length){
            return 0;
        }

        int profit = 0;
        //buy
        if(trade==0){
            profit = Math.max( -prices[i] + findMaxProfit(prices, i+1, trades, 1) , findMaxProfit(prices, i+1, trades, 0) );
        }
        else{
            profit = Math.max( prices[i] + findMaxProfit(prices, i+1, trades+1, 0), findMaxProfit(prices, i+1, trades, 1));
        }

        return profit;
    }


    //memoization
    public static int memoization(int[] prices, int i, int trades, int trade, int[][] dp){
        if(trades == 2){
            return 0;
        }
        if(i==prices.length){
            return 0;
        }

        if(dp[i][trade] != -1){
            return dp[i][ trade];
        }
        int profit = 0;
        //buy
        if(trade==0){
            profit = Math.max( -prices[i] + memoization(prices, i+1, trades, 1, dp) , memoization(prices, i+1, trades, 0, dp) );
        }
        else{
            profit = Math.max( prices[i] + memoization(prices, i+1, trades+1, 0, dp), memoization(prices, i+1, trades, 1, dp));
        }

        return dp[i][trade] = profit;
    }

    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        maxProfit(prices);
    }
}
