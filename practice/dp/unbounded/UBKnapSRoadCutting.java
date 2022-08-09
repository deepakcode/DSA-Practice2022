package com.practice.dp.unbounded;

public class UBKnapSRoadCutting {

    public static void main(String[] args) {

        int price[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};

        int n = price.length;

        int length[] = new int[n];

        for (int i = 0; i < n; i++) {
            length[i] = i + 1;
        }

        int dp[][] = new int[n + 1][n + 1];

        int maxLenght = n;
        int r = cutRod(length, price, n, dp, maxLenght);   // max price

        System.out.println("Result : " + r);


    }

    private static int cutRod(int[] length, int[] price, int n, int[][] dp, int maxLenght) {

        /*
        //--0, 1, 2--------------->price
        |0
        |1
        |2
        |.
        |.
        lenght
        */
        // Initilization
        for (int i = 0; i <=n; i++) { //lenght
            for (int j = 0; j <=n; j++) { //price
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = -1;
            }
        }

        // logic
        print(n,n,dp);

        for (int i = 1; i <=n; i++) { //price
            for (int j = 1; j <=n; j++) { //length
                if(length[i-1]<=j){
                    dp[i][j]= Math.max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j]= dp[i-1][j];
                }

            }
        }
        print(n,n,dp);


        return 0;
    }

    private static void print(int n, int sum, int[][] dp) {
        System.out.println("--------------------");
        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <=sum; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
