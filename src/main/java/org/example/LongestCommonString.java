package org.example;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonString {
    public static void printLongestCommonString(String a, String b){
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            dp[i][0] = 0;
        }

        for(int i=0; i<=n; i++){
            dp[0][i] = 0;
        }
        int max = 0;

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }

        }

        System.out.println("LONGEST COMMON SUBSTRING LENGTH = " + max);


        //printing the longest common substrings
        Set<String> lcsSet = new HashSet<>();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] == max) {
                    // Extract substring of length `max`
                    lcsSet.add(a.substring(i - max, i));
                }
            }
        }

        // Print all unique longest common substrings
        System.out.println("Longest Common Substrings:");
        for (String lcs : lcsSet) {
            System.out.println(lcs);
        }
    }

    public static void main(String[] args) {
        printLongestCommonString("ABCDGH", "ACDGHR");
    }
}
