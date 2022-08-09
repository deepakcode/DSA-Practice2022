package com.practice.dp.unbounded;

/**
 * int arr[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
 * int size = arr.length;
 * System.out.println("Maximum Obtainable Value is "
 * + cutRod(arr, size - 1, size));
 */
public class RoadCutting_P01 {

    public static void main(String[] args) {
        int
                arr[] = {1, 5, 8, 9, 10, 17, 17, 20},
                n = arr.length;

        System.out.println(maxValueRoadCutting(arr, n));
    }

    private static int maxValueRoadCutting(int[] price, int n) {
        int lenght[] = new int[n];

        for (int i = 0; i < n; i++) {
            lenght[i] = i + 1;
        }

        for (int a :
                lenght) {
            System.out.print(a + " ");
        }

        System.out.println("\n");

        int dp[][] = new int[n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }


        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (lenght[i - 1] <= j) {
                    System.out.println("i-1->" + (i - 1));
                    System.out.println("j->" + (j));
                    dp[i][j] = Math.max(
                            price[i - 1] + dp[i][j-lenght[i - 1]],
                            dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        return dp[n][n]; //TODO
    }
}
