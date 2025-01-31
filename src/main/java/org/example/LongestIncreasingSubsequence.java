package org.example;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void findLIS(int[] nums){
        int len = findLISRecursion(nums, 0, -1);
        System.out.println("Recursion : " + len);

        //memoization
        int n = nums.length;
        int[][] memo = new int[n][n+1];
        for(int i=0; i<n; i++){
            Arrays.fill(memo[i], -1);
        }
        int le = findLISMemoization(nums, 0, -1, memo);
        System.out.println("Memoization : " + le);

        //tabulation
        int length = findLisTabulation(nums);
        System.out.println("Tabulation : " + length);
    }

    //recursion
    public static int findLISRecursion(int[] nums, int index, int prev_index){

        if(index== nums.length){
            return 0;
        }

        int max_size = findLISRecursion(nums,index+1, prev_index);

        if(prev_index == -1 || nums[index] > nums[prev_index] ) {
            max_size = Math.max(max_size, 1 + findLISRecursion(nums, index + 1, index));
        }

        return max_size;

    }

    public static int findLISMemoization(int[] nums, int index, int prev_index, int[][] memo){
        if(index==nums.length){
            return  0;
        }

        if(memo[index][prev_index+1] != -1){
            return memo[index][prev_index+1];
        }

        int max_size = findLISMemoization(nums,index+1, prev_index, memo);

        if(prev_index == -1 || nums[index] > nums[prev_index] ) {
            max_size = Math.max(max_size, 1 + findLISMemoization(nums, index + 1, index, memo));
        }
        return memo[index][prev_index+1] = max_size;
    }

    //dp
    public static int findLisTabulation(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        int max = 0;
        Arrays.fill(dp, 1);
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }




    public static void main(String[] args){
        int[] nums = {1, 3, 2, 5, 7};
        findLIS(nums);
    }
}
