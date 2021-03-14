package com.benz.demo.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinarySearch {

    private int[] arr;
    private int size;
    private BufferedReader reader;

    public BinarySearch()
    {
        arr=new int[]{45,56,34,22,78,65,98,54,32,12,13,45};
        size=arr.length;
        reader=new BufferedReader(new InputStreamReader(System.in));
        traverse();
    }

    private void traverse()
    {
         selectionSort();
         for(int i : arr)
             System.out.printf("%d\t",i);
        System.out.print("\n");
    }

    private int[] selectionSort()
    {
        for(int i=1;i<size;i++)
        {
            int hole = i-1;
            int key = arr[i];

            while(hole>=0 && key<arr[hole])
            {
                arr[hole+1]=arr[hole];
                hole--;
            }
            arr[hole+1] = key;
        }
        return arr;
    }

    private int findKey(int start,int end,int key) // recursive function
    {
        while(end>start)
        {
              int mid = (start+end-1)/2;
              if(key==arr[mid])
                  return mid+1;
              else if(key>arr[mid])
                  findKey(++start,end,key);
              else
                  findKey(start,--end,key);
        }
        return -1;
    }

    public void start() throws Exception
    {
            System.out.println("Enter the key to find");
            int key = Integer.valueOf(reader.readLine());
            int index = findKey(0, arr.length, key);
            if (index != -1)
                System.out.printf("%d is found at %d position \n", key, index);
            else
                System.out.println("Key is not found in the list");
    }
}
