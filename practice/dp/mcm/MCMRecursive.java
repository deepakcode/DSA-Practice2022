package com.practice.dp.mcm;
import static java.lang.Math.min;
public class MCMRecursive {

    public static void main(String[] args) {

        int arr[] = new int[]{1, 2, 3, 4, 3};  //5
        int n = arr.length;
        int r = mcm(arr, 1, n - 1);
        System.out.println("Result : " + r);
    }

    private static int mcm(int[] arr, int i, int j) {
        //Base condition
        if (i >= j) {
            return 0;
        }

        int min = Integer.MAX_VALUE - 1;

        for (int k = i; k < j; k++) {
            int result = mcm(arr, i, k) +
                    mcm(arr, k + 1, j) +
                    arr[i - 1] * arr[k] * arr[j];
          min=min(result,min);
        }
        return min;
    }

}
