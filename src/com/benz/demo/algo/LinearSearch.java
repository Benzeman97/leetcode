package com.benz.demo.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LinearSearch {

    private int[] arr;
    private int size;
    private BufferedReader reader;

    public LinearSearch()
    {
        arr=new int[]{76,43,56,22,34,78,90,54,23,22};
        size=arr.length;
        reader = new BufferedReader(new InputStreamReader(System.in));
        displayList();
    }

    private void displayList()
    {
        for(int i : arr)
            System.out.printf("%d\t",i);
        System.out.print("\n");
    }

    private int findKey() throws Exception
    {
        System.out.println("Enter the key value to find");
        int key = Integer.valueOf(reader.readLine());

        for(int i=0;i<size;i++)
            if (arr[i] == key)
                return i + 1;

          return -1;
    }

    public void search() throws Exception
    {
        int index = findKey();
        if(index!=-1)
            System.out.printf("%d is found at %d position",arr[index-1],index);
        else
            System.out.println("Key is not found in the list");

    }
}
