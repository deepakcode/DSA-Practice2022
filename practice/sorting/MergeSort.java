package com.practice.sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 8, 4, 2};

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println();

        mergesort(arr, 0, arr.length-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println();
    }

    private static void mergesort(int[] arr, int l, int r) {
        if(r>l){
            int m = (r - l) / 2;
            mergesort(arr, l, m);
            mergesort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        //left = 0
        //right =4
        //mid=2

        int n1 = m - l; //2-0=2
        int n2 = r - m; //4-2=2

        int L[] = new int[n1];

        int R[] = new int[n2];


        for (int i = 0; i < n1; ++i)
            L[i] = arr[i+l];



        for (int j = 0; j < n2; ++j)
            R[j] = arr[j+m+1];



        int i = 0;
        int j = 0;

        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;

            } else {
                arr[k] = R[j];
                j++;

            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}

