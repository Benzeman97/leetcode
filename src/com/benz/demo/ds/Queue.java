package com.benz.demo.ds;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Queue {

    private int[] queue;
    private int rear;
    private int front;
    private int size;
    private BufferedReader reader;

    public Queue()
    {
        queue=new int[5];
        rear=front=0;
        size=queue.length;
        reader=new BufferedReader(new InputStreamReader(System.in));
    }

    private boolean isFull()
    {
        return rear == size? true: false;
    }
    private boolean isEmpty()
    {
        return (rear==0 && front==0) ? true:false;
    }

    private void enqueue(int value)
    {
        if(isFull())
            System.out.println("Queue is overflow");
        else {
            queue[rear] = value;
            System.out.printf("%d is inserted\n",queue[rear]);
            rear += 1;
        }
    }

    private void dequeue()
    {
        if(isEmpty())
            System.out.println("Queue is underflow");
        else{
            int del = queue[front];
            System.out.printf("%d is deleted\n",del);
            for(int i=front;i<rear-1;i++)
                queue[i] = queue[i+1];
            rear--;
        }
    }

    private void top()
    {
        if(isEmpty())
            System.out.println("Queue is underflow");
        else
            System.out.printf("The top is %d\n",queue[rear-1]);
    }

    private void traverse()
    {
        if(isEmpty())
            System.out.println("Queue is underflow");
        else{
            for(int i=front;i<rear;i++)
                System.out.printf("%d -----> ",queue[i]);
            System.out.print("\n");
        }
    }

    public void start() throws Exception
    {
        while (true) {
            System.out.println("1.Enqueue");
            System.out.println("2.Dequeue");
            System.out.println("3.Top");
            System.out.println("4.Traverse");
            System.out.println("Enter you choice");
            int ch = Integer.valueOf(reader.readLine());

            switch (ch) {
                case 1:
                    System.out.println("Enter a value");
                    int value = Integer.valueOf(reader.readLine());
                    enqueue(value);
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    top();
                    break;
                case 4:
                    traverse();
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }

    }
}
