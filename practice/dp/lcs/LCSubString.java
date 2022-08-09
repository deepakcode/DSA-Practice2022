package com.practice.dp.lcs;

public class LCSubString {

    public static void main(String[] args) {
        char[] x = new char[]{'A', 'B', 'C', 'D', 'E'}; //BC
        char[] y = new char[]{'Z', 'B', 'C', 'Y', 'D'};
        int m = x.length;
        int n = y.length;
        System.out.println(lcSubString(x, y, m, n));
    }

    private static int lcSubString(char[] x, char[] y, int m, int n) {

        int dp[][] = new int[m + 1][n + 1];

        //Initialization - Default
        //logic
        int result =Integer.MIN_VALUE;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (x[i - 1] == y[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = 0;
                result = Math.max(result,dp[i][j]);
            }
        }
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return result;
    }

}
