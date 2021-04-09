package com.benz.demo.algo;

public class QuickSort {

    /*public void quickSort(int[] arr, int start, int end) {
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
    }*/


    private int partition(int[] arr, int start, int end) {
        int pivot = end;
        int key = start - 1;


        for (int i = start; i < pivot; i++) { //O(n)
            if (arr[i] < arr[pivot]) {
                key++;
                swap(i, key, arr);
            }
        }
        swap(key + 1, pivot, arr); //O(1)
        return key + 1;
    }

    private int[] swap(int x, int y, int[] arr) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
        return arr;
    }


    public int[] quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return arr;
        int pIndex = partition(arr, start, end);
        quickSort(arr, start, pIndex - 1); //O(n log n)
        quickSort(arr, pIndex + 1, end); //O(n log n)
        return arr;
    }

}
