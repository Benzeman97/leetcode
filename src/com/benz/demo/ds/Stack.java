package com.benz.demo.ds;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Stack {

    private int[] stack;
    private int topic;
    private int size;
    private BufferedReader reader;


    public Stack()
    {
        stack=new int[5];
        topic=-1;
        size=stack.length;
        reader=new BufferedReader(new InputStreamReader(System.in));
    }

    private boolean isEmpty()
    {
        return topic==-1 ? true : false;
    }

    private boolean isFull()
    {
        return topic==size-1 ? true : false;
    }

    private void push(int value)
    {
         if(isFull())
             System.out.println("Stack is overflow");
         else {
             topic +=1;
             stack[topic]=value;
             System.out.printf("%d is inserted \n",stack[topic]);
         }
    }

    private void pop()
    {
        if(isEmpty())
            System.out.printf("Stack is underflow \n");
        else {
            int del = stack[topic];
            System.out.printf("%d is deleted \n", del);
            topic -= 1;
        }
    }

    private void top()
    {
        if(isEmpty())
            System.out.printf("Stack is underflow ]\n");
        else
            System.out.printf("The top is %d \n",stack[topic]);
    }

    private void display()
    {
        if(isEmpty())
            System.out.printf("Stack is underflow \n");
        else{
            for(int i=0;i<=topic;i++)
                System.out.printf("%d -----> ",stack[i]);
            System.out.print("\n");
        }
    }

    public void start() throws Exception
    {
        while(true) {
            System.out.println("1.Push");
            System.out.println("2.Pop");
            System.out.println("3.Top");
            System.out.println("4.Traversing");
            System.out.println("Enter Your Choice");
            int ch = Integer.valueOf(reader.readLine());

            switch (ch) {
                case 1:
                    System.out.println("Enter a value");
                    int value = Integer.valueOf(reader.readLine());
                    push(value);
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    top();
                    break;
                case 4:
                    display();
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }
}
