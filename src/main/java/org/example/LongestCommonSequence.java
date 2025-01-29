package org.example;

import java.util.*;

public class LongestCommonSequence {

    public static void LCS(String a, String b){
        List<String> a_list = backtrack(a, 0, "", new ArrayList<>());


        List<String> b_list = backtrack(b, 0, "", new ArrayList<>());
        for(String s: b_list){
            for(String s1: a_list){
                if(s.equals(s1)){
                    System.out.println(s);
                }
            }
        }

        //dp table
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[a.length()+1][b.length()+1];
        for(int i=1; i<=a.length(); i++){
            for(int j=1; j<=b.length(); j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println("subsequence of maximum length is : " + dp[n][m]);

        Map<String, TreeSet<String>> memo = new HashMap<>();
        Set<String> result = printLCS(a, b, n, m, memo, dp);
        for(String s: result){
            System.out.println(s);
        }


        return;
    }

    public static List<String> backtrack(String a, int index, String curr, List<String> current){
        if(index==a.length()){
            current.add(curr);
            return new ArrayList<>(current);
        }

        backtrack(a, index+1, curr, current);
        backtrack(a , index+1, curr+a.charAt(index), current);
        return new ArrayList<>(current);
    }

    public static Set<String> printLCS(String a, String b, int i, int j, Map<String, TreeSet<String>> memo, int[][] dp){
        if(i==0 || j==0){
            return new TreeSet<>(Collections.singletonList(""));
        }

        String key = i + "," + j;
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        Set<String> result = new TreeSet<>();
        if(a.charAt(i-1) == b.charAt(j-1)){
            Set<String> prev = printLCS(a, b, i-1, j-1, memo, dp );
            for(String s : prev){
                result.add(s+a.charAt(i-1));
            }
        }
        else{
            if(dp[i-1][j] == dp[i][j]){
                result.addAll(printLCS(a, b, i-1, j, memo, dp));
            }
            if(dp[i][j-1] == dp[i][j]){
                result.addAll(printLCS(a, b, i, j-1, memo, dp));
            }
        }
        for (String s: result){
            System.out.println("Temporary:");
            System.out.println(s);
        }
        memo.put(key, (TreeSet<String>) result);
        return result;
    }

    public static void main(String[] args) {
        LCS("abcde", "ace");

    }
}
