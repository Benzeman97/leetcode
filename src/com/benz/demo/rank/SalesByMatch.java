package com.benz.demo.rank;

import java.util.*;

public class SalesByMatch {

    public void inputReader()
    {
        String[] arr = new Scanner(System.in).nextLine().split(" ");

        int[] ar=new int[arr.length];

        for(int i=0;i<arr.length;i++)
            ar[i]=Integer.valueOf(arr[i]);

      int count = sockMerchant(ar);

        System.out.println(count);

    }

    private int sockMerchant(int[] ar)
    {
        Map<Integer,Integer> values=new Hashtable<>();
        int pair=0;

        for(int i=0;i<ar.length;i++)
        {
            int key=ar[i];
            int count=0;

            for(int c=0;c<ar.length;c++)
            {
                if(ar[c]==key)
                    count++;
            }
            values.put(key,count);
        }

       for(int i : values.keySet())
       {
           int count= values.get(i);
            if(count>1)
                pair+=count/2;
       }
       return pair;
    }

}
