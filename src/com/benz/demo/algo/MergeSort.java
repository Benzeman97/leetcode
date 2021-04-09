package com.benz.demo.algo;

public class MergeSort {

    /*public int[] mergeSort(int[] arr) {
        if (arr.length < 2)
            return arr;
        else {
            int mid = (arr.length - 1) / 2;
            int[] right = new int[mid + 1];
            int[] left = new int[arr.length - (mid + 1)];

            for (int i = 0; i <= mid; i++)
                right[i] = arr[i];
            for (int i = mid + 1; i < arr.length; i++)
                left[i - (mid + 1)] = arr[i];


            mergeSort(right);
            mergeSort(left);
            return merge(right, left, arr);

        }

    }

    private int[] merge(int[] right, int[] left, int[] arr) {

        int r, l, k;
        r = l = k = 0;

        while (r < right.length && l < left.length) {
            if (right[r] < left[l]) {
                arr[k] = right[r];
                r += 1;
            } else {
                arr[k] = left[l];
                l += 1;
            }
            k += 1;
        }

        while (r < right.length) {
            arr[k] = right[r];
            r++;
            k++;
        }

        while (l < left.length) {
            arr[k] = left[l];
            ++l;
            ++k;
        }
        return arr;

    }*/

    public int[] mergeSort(int[] arr)
    {
         int length = arr.length;

        if(length<2)
            return arr;
        int mid=(length-1)/2;
        int[] right=new int[mid+1];
        int[] left=new int[(length-1)-mid];

        for(int i=0;i<=mid;i++)
            right[i] = arr[i]; //O(n)

        for(int i=mid+1;i<length;i++)
            left[i-(mid+1)] = arr[i]; //O(n)

        mergeSort(right); //O(log n)
        mergeSort(left); //O(log n)
        return merge(arr,right,left);  //O(n)

    }

    private int[] merge(int[] arr,int[] right,int[] left)
    {
        int i,j,k;
        i=j=k=0;

        while(i<right.length && j<left.length)
        {
            if(right[i]<=left[j])
            {
                arr[k]=right[i];
                i++;
            }else{
                arr[k]=left[j];
                j++;
            }
            k++;
        }

        while (i<right.length)
        {
            arr[k]=right[i];
            i++;
            k++;
        }

        while (j<left.length)
        {
            arr[k]=left[j];
            j++;
            k++;
        }
        return arr;
    }


}
