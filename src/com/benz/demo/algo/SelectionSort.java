package com.benz.demo.algo;

public class SelectionSort {

   /* public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int c = i + 1; c < arr.length; c++)
                if (arr[c] < arr[min])
                    min = c;
            swap(min, i, arr);
        }
    }

    private void swap(int x, int y, int[] arr) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }*/

   private int[] arr;
   private int size;

   public SelectionSort()
   {
       arr = new int[]{78,45,23,87,32,10,32};
       size = arr.length;
   }

   public void selectionSort()
   {

       for(int i=0;i<size;i++) {
             int min=i;
             for(int c=i+1;c<size;c++)
                 if (arr[c] < arr[min])
                        min = c;
           swap(i,min);
       }
       traverse();
   }

   private void swap(int x,int y)
   {
      int temp =arr[x];
       arr[x] = arr[y];
       arr[y]=temp;
   }

  private void traverse()
  {
      for(int i : arr)
          System.out.printf("%d\t",i);
  }

}
