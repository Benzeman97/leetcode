package com.benz.demo.algo;

public class Fibonacci {

    private int size;
    private int prev,next;

    public Fibonacci(int size)
    {
        this.size=size;
        prev=next=1;
    }

    public void printFibonacci()
    {
        System.out.printf("%d\t",1);


        for(int i=1;i<=size;i++)
        {
            System.out.printf("%d\t",next);
            int total = prev+next;
            prev=next;
            next=total;
        }

    }

}
