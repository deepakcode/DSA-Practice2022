package com.practice.dp.lcs;

public class LCS {
    public static void main(String[] args) {

        char []s1 = new char[]{'A','B','C','D','E'}; //abcde
        char []s2 = new char[]{'Z','B','C','Y','D'};
        int m = s1.length;
        int n = s2.length;

        //Recursion
        //int r= lcs(S1, S2, m, n);
        //Memoization
        int dp[][] = new int[m+1][n+1];
        initialize(dp,m,n);
        print(dp,m,n);
       // int r = recurstionAndStore(s1, s2, m, n,dp);
        tabulation(s1, s2, m, n,dp);
        print(dp,m,n);
        System.out.println("Result : "+dp[m][n]);

        StringBuilder sb= new StringBuilder();
        while(m>0 && n>0){
            if(s1[m-1]==s2[n-1]){
                sb.append(s1[m-1]);
                    m--;
                    n--;
            }else{
              if(s1[m-1]>s2[n-1])
                  m--;
              else
                  n--;
            }
        }

        System.out.println(sb.reverse());
    }

    private static void tabulation(char[] s1, char[] s2, int m, int n, int[][] dp) {

        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if(i==0 || j==0)
                    dp[i][j]=0;
            }
        }

        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
               if(s1[i-1]==s2[j-1]){
                   dp[i][j] = 1+dp[i-1][j-1];
               }else{
                   dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]    );
               }
            }
        }
    }

    private static void initialize(int[][] dp, int m, int n) {

        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                dp[i][j]=-1;
            }
        }
    }
    private static void print(int[][] dp, int m, int n) {
        System.out.println("\n");
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                System.out.print(dp[i][j]+" ");

            }
            System.out.println();
        }
    }


    /*private static int recurstionAndStore(char []s1, char []s2, int m, int n, int [][]dp){

        if(m==0 || n==0){
            return dp[m][n]=0;
        }
        // logic
        if(s1[m-1]==s2[n-1]){
            return dp[m][n]=1+ recurstionAndStore(s1,s2,m-1, n-1,dp);
        }else{
            return dp[m][n]=Math.max(recurstionAndStore(s1,s2,m-1, n,dp), recurstionAndStore(s1,s2,m, n-1,dp));
        }
    }*/

    /*private static int lcs(char []s1, char []s2, int m, int n) {
        //BASE condition
        if(m==0 || n==0){
            return 0;
        }
        // logic
        if(s1[m-1]==s2[n-1]){
            return 1+ lcs(s1,s2,m-1, n-1);
        }else{
            return Math.max(lcs(s1,s2,m-1, n), lcs(s1,s2,m, n-1));
        }
    }
*/

    /*private static int lcs(char []s1, char []s2, int m, int n, int dp[][]) {
        //BASE condition
        if(m==0 || n==0){
            return 0;
        }
        // logic
        if(s1[m-1]==s2[n-1]){
            return 1+ lcs(s1,s2,m-1, n-1);
        }else{
            return Math.max(lcs(s1,s2,m-1, n), lcs(s1,s2,m, n-1));
        }
    }*/
}
