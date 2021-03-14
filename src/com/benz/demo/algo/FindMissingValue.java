package com.benz.demo.algo;

public class FindMissingValue {
/*
    public void find()
    {
        int[] arr=new int[]{1,2,5,4};
        int value = missingValue(arr,arr.length);
        System.out.println(value);

    }

    private int missingValue(int[] arr,int n)
    {
      int total = (n+1)*(n+2)/2;
      for(int i=n-1;i>=0;i--)
          total -=arr[i];
      return total;

    }*/

public void find()
{
    int[] arr = new int[]{1,2,3,4,6,7,8,5,9,10};
    int m_value = missingValue(arr);
    System.out.printf("The missing value is %d",m_value);
}

public int missingValue(int[] arr)
{
     int sum=0;
     int n = arr.length;

     for(int i=0;i<arr.length;i++)
         sum += arr[i];

      return ((n+1)*(n+2))/2 - sum;
}

}
