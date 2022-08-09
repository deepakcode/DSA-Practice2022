package com.practice.sorting;

/**
 * int arr[] = {12, 11, 13, 5, 6, 7};
 * 12
 * 11    13
 * 5,  6 | 7
 */
public class HeapSort {


    public void sort(int arr[]) {
        int n = arr.length;
        // rest are child nodes
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] =arr[i];
            arr[i]=temp;

            heapify(arr,i,0);

        }
    }

    void heapify(int arr[], int n, int i) {

        //Assuming largest as root
        int largest = i;

        int left = i * 2 + 1;
        int right = i * 2 + 2;

        // if left child is larger then root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // if right child is larger then largest
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // if largest is not largest
        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;

            heapify(arr,n,largest);  //Recursivly heapify largest
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
