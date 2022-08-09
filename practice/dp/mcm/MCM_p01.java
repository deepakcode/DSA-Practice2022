package com.practice.dp.mcm;

//Output: 26000
public class MCM_p01 {



    public static void main(String[] args) {
        int n = 5;
        int[] arr = new int[]{40, 20, 30, 10, 30};
        int r = mcm(arr, 1, n-1);
        System.out.println("Result : " + r);
    }//end main

    private static int mcm(int[] arr, int i, int j) {

        if(i==j)
            return 0;

        int min = Integer.MAX_VALUE - 1;

        for (int k = i; k < j; k++) {
            int currentMin = mcm(arr, i, k) +
                    mcm(arr, k +1, j) +
                    arr[i-1] * arr[k] * arr[j];
            min = Math.min(currentMin, min);
        }
        return min;
    }
}
