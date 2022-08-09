package com.practice.dp.lis;

import java.util.Arrays;

/**
 * nums = [10,9,2,5,3,7,101,18]
 * Output: 4 Explanation: The longest increasing subsequence is [2,3,7,101],
 * therefore the length is 4.
 */
public class LIS {

    public static void main(String[] args) {

        int[] arr = new int[]{102, 10, 9, 2, 5, 3, 7, 101, 18};

        int n = arr.length;

        int dp[][] = new int[n + 1][n + 1];

        for (int a[] : dp) {
            Arrays.fill(a, -1);
        }


        System.out.println("L " + f(arr, 0, -1, dp));

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }

    }

    public static int f(int[] arr, int cur_idx, int pre_idx, int[][] dp) {
        if (cur_idx == arr.length)
            return 0;

        if (dp[cur_idx][pre_idx + 1] != -1)
            return dp[cur_idx][pre_idx + 1];

        int len = 0;

        int notPick = f(arr, cur_idx + 1, pre_idx, dp);

        if (pre_idx == -1 || arr[cur_idx] > arr[pre_idx]) {
            dp[cur_idx][pre_idx + 1] = Math.max(1 + f(arr, cur_idx + 1, cur_idx, dp), notPick);
        }
        return dp[cur_idx][pre_idx + 1];//TODO
    }
}


