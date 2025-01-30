package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Stocks {

    public static void maxProfit(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        //recursion
        int res = findMaxProfit(prices, 0, 0);
        System.out.println("Recursion: " + res);

        //memoization
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        int r = findMaxProfitMemo(prices, 0, dp, 0);

        System.out.println("Memoization:" + r);

        //tabulation
        int re = findMaxProfitTabulation(prices);
        System.out.println("Tabulation: " + re);
    }

    //recursion
    public static int findMaxProfit(int[] prices, int i, int trade){
        if(i==prices.length){
            return 0;
        }

        int curr_profit = 0;
        //buy
        if(trade == 0){
            curr_profit = Math.max( findMaxProfit(prices, i+1, 1) - prices[i], findMaxProfit(prices, i+1, 0) );
        }
        else{
            curr_profit = Math.max(prices[i] + findMaxProfit(prices, i+1, 0), findMaxProfit(prices, i+1, 1));
        }

        return curr_profit;
    }


    //memoization
    public static int findMaxProfitMemo(int[] prices, int i, int[][] dp, int trade){
        if(i==prices.length){
            return 0;
        }

        if(dp[i][trade] != -1){
            return dp[i][trade];
        }

        int curr_profit = 0;
        if(trade == 0){
            curr_profit = Math.max( findMaxProfit(prices, i+1, 1) - prices[i], findMaxProfit(prices, i+1, 0) );
        }
        else{
            curr_profit = Math.max(prices[i] + findMaxProfit(prices, i+1, 0), findMaxProfit(prices, i+1, 1));
        }
        return dp[i][trade] = curr_profit;
    }

    //tabulation
    public static int findMaxProfitTabulation(int[] prices){
        int n = prices.length;
        int[][] dp = new int[prices.length+1][2];
        dp[n][0] = dp[n][1] = 0;
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<=1; j++){
                int profit = 0;
                if(j==1){
                    profit = Math.max(dp[i+1][0] - prices[i], dp[i+1][1]);
                }
                else{
                    profit = Math.max(dp[i+1][1] + prices[i], dp[i+1][0] );
                }
                dp[i][j] = profit;
            }
        }
        return dp[0][1];
    }

    public static void main(String[] args){
        int[] prices = {7, 1, 5, 3, 6, 4};
        maxProfit(prices);

    }
}
