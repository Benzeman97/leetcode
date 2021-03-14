package com.benz.demo.algo;

public class QuickSort {

    public void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pIndex = partition(arr, start, end);
            quickSort(arr, start, pIndex - 1);
            quickSort(arr, pIndex + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = end;
        int pIndex = start;

        for (int i = start; i < end; i++) {

            if (arr[i] <= arr[pivot]) {
                swap(i, pIndex, arr);
                pIndex += 1;
            }
        }
        swap(pIndex, pivot, arr);
        return pIndex;
    }

    private void swap(int x, int y, int[] arr) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
