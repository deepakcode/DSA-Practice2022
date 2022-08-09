package com.practice.dp.lis;

import java.util.*;

public class LIS_P01 {
    public static void main(String[] args) {

        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60};

        int n = arr.length;
        int lis[] = new int[n];

       int track[] = new int[n];

        for (int i = 0; i < n; i++) {
            track[i]=i;
        }

        Arrays.fill(lis, 1);

        int lisValue = Integer.MIN_VALUE;

        for (int cur_idx = 1; cur_idx < n; cur_idx++) {
            for (int prev_idx = 0; prev_idx < cur_idx; prev_idx++) {
                if (arr[cur_idx] > arr[prev_idx] && lis[cur_idx] < lis[prev_idx] + 1) {
                    lis[cur_idx] = lis[prev_idx] + 1;
                    track[cur_idx]=prev_idx;
                }
            }
            lisValue = Math.max(lis[cur_idx], lisValue);
        }
        System.out.println("LIS is " + lisValue);

        for (int i = 0; i < n; i++) {
            System.out.print(track[i]+" ");
        }
        System.out.println("");
    }
}
