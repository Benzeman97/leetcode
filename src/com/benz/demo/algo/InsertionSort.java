package com.benz.demo.algo;

public class InsertionSort {

    /*public int[] insertionSort(int[] arr)//93,50,45,10,22
    {
        for (int i = 1; i < arr.length; i++) {
            int k = arr[i];
            int hole = i - 1;
            while (hole >= 0 && k < arr[hole]) {
                arr[hole + 1] = arr[hole];
                hole -= 1;
            }
            arr[hole + 1] = k;
        }
        return arr;
    }*/





  private int arr[];
  private int size;

  public InsertionSort()
  {
      arr=new int[]{78,45,23,12,57,87,65};
      size=arr.length;
  }

  public void insertionSort()
  {
       for(int i=1;i<size;i++)
       {
           int hole= i-1;
           int k=arr[i];

           while(hole>=0 && k<arr[hole])
           {
               arr[hole+1] = arr[hole];
               hole--;
           }
           arr[hole+1] = k;
       }
       traverse();
  }

  private void traverse()
  {
      for(int i : arr)
          System.out.printf("%d\t",i);
  }
}
