package com.benz.demo.algo;

import java.util.Arrays;

public class BubbleSort {
/*

    public void bubbleSort() {
        int[] arr = new int[]{34, 54, 12, 32, 56, 76, 43, 23, 45};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int c = 0; c < arr.length - 1 - i; c++) {

                if (arr[c] > arr[c + 1]) {

                    int temp = arr[c + 1];
                    arr[c + 1] = arr[c];
                    arr[c] = temp;
                }
            }
        }
        display(arr);
    }

    public void selectionSort() {
        int[] arr = new int[]{34, 54, 12, 32, 56, 76, 43, 23, 45};

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int c = i + 1; c < arr.length; c++)
                if (arr[c] < arr[min])
                    min = c;

            swap(i, min, arr);
        }
        display(arr);

    }

    public void swap(int index, int min, int[] arr) {
        int temp = arr[min];
        arr[min] = arr[index];
        arr[index] = temp;

    }

    public void insertionSort() {
        int[] arr = new int[]{34, 54, 12, 32};

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];//12
            int hole = i - 1;//1

            while (hole >= 0 && key < arr[hole]) {
                arr[hole + 1] = arr[hole];//34
                hole -= 1;//0
            }
            arr[hole + 1] = key;
        }
        display(arr);

    }


    public void display(int[] dis) {
        Arrays.stream(dis).forEach(v -> System.out.print(v + "\t"));
    }
*/

   private int[] arr;
   private int size;

   public BubbleSort()
   {
       arr=new int[]{45,32,67,12,45,54,22,90,13,12};
       size=arr.length;
   }

   public void bubbleSort()
   {
        for(int i=0;i<size-1;i++)
            for(int c=1;c<size-i;c++)
                 if(arr[c-1]>arr[c])
                     swap(c-1,c);
        traverse();
   }

   private void swap(int x,int y)
   {
       int temp = arr[y];
       arr[y] = arr[x];
       arr[x] = temp;
   }

   private void traverse()
   {
       for(int i : arr)
           System.out.printf("%d\t",i);
   }

}
