package com.benz.demo.rank;

public class Swap {

    public void swapWithoutTemp(int x,int y)
    {
        // x=30 y=20
        System.out.println("Before Swap");
        System.out.printf("x = %d\n",x);
        System.out.printf("y = %d\n",y);

        x=x+y; //50
        y=x-y;
        x=x-y;

        System.out.println("After Swap");
        System.out.printf("x = %d\n",x);
        System.out.printf("y = %d\n",y);
    }
}
