package com.practice.dp.lcs;

public class LCS_Memoisation_p01 {

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " + lcs(X, Y, m, n));
        //Answer is 4
    }

    private static int lcs(char[] x, char[] y, int m, int n) {

        int dp[][] = new int[m + 1][n + 1];

        //Logic
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (x[i - 1] == y[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i=m;
        int j=n;
        while(i>0 && j>0){
            if(x[i-1]==y[j-1]){
                sb.append(x[i-1]);
                i--;
                j--;
            }else if (dp[i-1][j] >dp[i][j-1]){
                i--;
            }else {
               j--;
            }
        }

        System.out.println(" output-> "+sb.reverse());
        //int result = lcsCount(x, y, m, n, dp);
        //print
        print(m, n, dp);
        return dp[m][n];
    }

    private static void print(int m, int n, int[][] dp) {
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

   /* private static int lcsCount(char[] x, char[] y, int m, int n, int[][] dp) {
        if (m == 0 || n == 0)
            return dp[m][n] = 0;
        if (x[m - 1] == y[n - 1]) {
            return dp[m][n] = 1 + lcsCount(x, y, m - 1, n - 1, dp);
        } else {
            int partA;
            int partB;

            if (dp[m][n - 1] == -1)
                partA = dp[m][n - 1] = lcsCount(x, y, m, n - 1, dp);
            else
                partA = dp[m][n - 1];

            if (dp[m - 1][n] == -1)
                partB = dp[m - 1][n] = lcsCount(x, y, m - 1, n, dp);
            else
                partB = dp[m - 1][n];

            return Math.max(partA, partB);
        }
    }*/
}

