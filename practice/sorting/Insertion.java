package com.practice.sorting;

import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 8, 4, 2, 9};
        insertionSort(arr);
        //System.out.println("---after---");
        //Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }
    //3, 8, 4, 2, 9
    //3, 8,
    private static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;

            for (int k = 0; k < n; k++) {
                System.out.print(arr[k]+" ");
            }
            System.out.println("");

        }
    }
}
