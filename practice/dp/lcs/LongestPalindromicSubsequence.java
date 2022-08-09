package com.practice.dp.lcs;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {

        String str = "geeksforgeeks";

        //29 Print shortest common Supersequence

        char x[] = "HELLO".toCharArray();
        int m = x.length;
        char y[] = "GEEK".toCharArray();
        int n = y.length;

        int r = lcs(x, y, m, n);

        System.out.println("Result " + r);
        System.out.println(" dd -> "+((m+n)-r));
        System.out.println("GEHEKLLO".length());
    }

    private static int lcs(char[] x, char[] y, int m, int n) {
        int dp[][] = new int[m+1][n+1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (x[i - 1] == y[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[m][n];
    }
}
