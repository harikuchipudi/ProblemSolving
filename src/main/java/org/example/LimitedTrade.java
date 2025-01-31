package org.example;

import java.util.Arrays;

public class LimitedTrade {

    public static void maxProfit(int[] prices){
        //recursion
        int result = findMaxProfit(prices, 0, 0, 2);
        System.out.println("Recursion : " + result);

        //memoization
        int[][][] memo = new int[prices.length][2][3];
        for(int i=0; i<prices.length; i++){
            for(int j=0; j<2; j++){
                Arrays.fill(memo[i][j], -1);
            }
        }
        int res = findMaxProfitByMemoization(prices, 0, 0, 2, memo);
        System.out.println("Memoization : " + res);

        int r = maxProfitTabulation(prices);
        System.out.println("Tabulation : " + r);


    }

    //recursion
    public static int findMaxProfit(int[] prices, int index, int trade, int transactions){
        if(index==prices.length || transactions == 0){
            return 0;
        }

        if(trade==0){
            return Math.max( -prices[index] + findMaxProfit(prices, index+1, 1, transactions),
                    findMaxProfit(prices, index+1, 0, transactions));
        }

        return Math.max( prices[index] + findMaxProfit(prices, index+1, 0, transactions-1),
                    findMaxProfit(prices, index+1, 1, transactions));

    }

    public static int findMaxProfitByMemoization(int[] prices, int index, int trade, int transactions, int[][][] memo){
        if(index==prices.length || transactions == 0){
            return 0;
        }

        if(memo[index][trade][transactions] != -1){
            return memo[index][trade][transactions];
        }

        if(trade==0){
            return Math.max( -prices[index] + findMaxProfitByMemoization(prices, index+1, 1, transactions, memo),
                    findMaxProfitByMemoization(prices, index+1, 0, transactions, memo));
        }

        return Math.max( prices[index] + findMaxProfitByMemoization(prices, index+1, 0, transactions-1, memo),
                findMaxProfitByMemoization(prices, index+1, 1, transactions, memo));

    }

    public static int maxProfitTabulation(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];

        int[][] curr = new int[2][3];
        int[][] after = new int[2][3];
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<=1; j++){
                for(int k=1; k<=2; k++){

                    if(j==1){
                        curr[j][k] = Math.max( -prices[i] + after[0][k], after[1][k] );
                    }
                    else{
                        curr[j][k] = Math.max( prices[i] + after[1][k-1], after[0][k] );
                    }

                }
            }
            after = curr;
        }

        return after[1][2];


    }


    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        maxProfit(prices);
    }
}
