package com.practice.dp.bounded;

import java.util.Arrays;

/**
 * Input:  arr[] = {1, 6, 11, 5}
 * Output: 1
 * Explanation:
 * Subset1 = {1, 5, 6}, sum of Subset1 = 12
 * Subset2 = {11}, sum of Subset2 = 11
 */
public class KnapsackSubsetSumMinDiff_P01 {

    public static void main(String[] args) {
        int
                arr[] = {1, 6, 15, 5},
                n = arr.length;

        System.out.println(getMinSubsetSumDiff(arr, n));

    }

    private static int getMinSubsetSumDiff(int[] arr, int n) {

        //sum= sum/2;

        int sum = Arrays.stream(arr).sum() / 2;

        System.out.println("Sum "+sum);
        //subset sum exist for sum/2?
        boolean dp[][] = new boolean[n + 1][sum + 1];


        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (j == 0)
                    dp[i][j] = true;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <=j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int arrSum=Arrays.stream(arr).sum();
        System.out.println("asum "+arrSum);
        int diff=0;
        for (int j = sum; j>=0; j--) {
            if(dp[n][j]==true){
                diff=arrSum-2*j;
                break;
            }
        }

        System.out.println("diff "+diff);

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return diff; //TODO
    }
}
