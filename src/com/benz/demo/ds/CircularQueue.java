package com.benz.demo.ds;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CircularQueue {
/*
    private int[] queue;
    private int rear;
    private int front;
    private int size;
    private BufferedReader reader;

    public CircularQueue(int size) {
        this.size = size;
        queue = new int[this.size];
        front = rear = -1;
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void show() throws Exception {
        while (true) {
            System.out.println("1.Enqueue");
            System.out.println("2.Dequeue");
            System.out.println("3.Display");
            System.out.println("4.Exit");
            System.out.println("Enter Your Choice");
            int ch = Integer.valueOf(reader.readLine());

            switch (ch) {
                case 1:
                    System.out.println("Enter a value to insert");
                    int data = Integer.valueOf(reader.readLine());
                    enqueue(data);
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.exit(3);
                default:
                    System.out.println("Invalid Input");
            }
        }

    }

    private void enqueue(int data) {
        if (rear == size - 1 && front == 0 || rear + 1 == front)
            System.out.println("Queue is overflow");
        else if (rear == -1 && front == -1) {
            front = rear = 0;
            queue[rear] = data;
        } else if (rear == size - 1) {
            rear = 0;
            queue[rear] = data;
        } else {
            rear += 1;
            queue[rear] = data;
        }
    }

    private void dequeue() {
        if (rear == -1 && front == -1)
            System.out.println("Queue is underflow");
        else if (front == rear) {
            int del = queue[front];
            System.out.println(del + " is deleted");
            front = rear = -1;
        } else if (front == size - 1) {
            int del = queue[front];
            System.out.println(del + " is deleted");
            front = 0;
        } else {
            int del = queue[front];
            System.out.println(del + " is deleted");
            front += 1;
        }
    }

    private void display() {
        if (rear != -1 && front != -1) {
            if (rear >= front) {
                for (int i = front; i <= rear; i++)
                    System.out.print(queue[i] + "--->");
                System.out.print("\n");
            } else {
                for (int i = front; i < size; i++)
                    System.out.print(queue[i] + "--->");
                for (int i = 0; i <= rear; i++)
                    System.out.print(queue[i] + "--->");
                System.out.print("\n");
            }
        } else
            System.out.println("Queue is underflow");
    }*/

           private int[] cqueue;
           private int rear,front;
           private int size;
           private BufferedReader reader;

           public CircularQueue(int size){
               cqueue=new int[size];
               rear=front=-1;
               this.size=size;
               reader=new BufferedReader(new InputStreamReader(System.in));
           }

           private void enqueue(int value)
           {
               if(rear==size-1 && front==0 || front==rear+1)
                   System.out.println("Circular Queue is overflow");
               else if(rear==-1 && front==-1)
               {
                   rear=front=0;
                   cqueue[rear]=value;
               }else if(rear==size-1){
                   rear=0;
                   cqueue[rear]=value;
               }else{
                   rear++;
                   cqueue[rear]=value;
               }

           }

           private void dequeue()
           {
               if(rear==1 && front==-1)
                   System.out.println("Circular queue is underflow");
               else if(front==size-1)
               {
                   int del = cqueue[front];
                   System.out.printf("%d is deleted\n",del);
                   front=0;
               }else if(front==rear)
               {
                   int del = cqueue[front];
                   System.out.printf("%d is deleted\n",del);
                   front=rear=-1;
               }else{
                   int del = cqueue[front];
                   System.out.printf("%d is deleted\n",del);
                   front++;
               }
           }

           private void traverse()
           {
               if(rear==-1 && front==-1)
                   System.out.println("Circular queue is underflow");
               else{
                   if(rear>=front) {
                       for (int i = front; i <= rear; i++)
                           System.out.printf("%d ---> \t", cqueue[i]);
                   }else{
                       for(int i=front;i<size;i++)
                           System.out.printf("%d ---> \t", cqueue[i]);
                       for(int i=0;i<=rear;i++)
                           System.out.printf("%d ---> \t", cqueue[i]);
                   }
                   System.out.print("\n");
               }
           }

           public void start() throws Exception
           {


               while (true) {
                   System.out.println("1.Enqueue");
                   System.out.println("2.Dequeue");
                   System.out.println("3.Display");
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
                           traverse();
                           break;
                       default:
                           System.out.println("Invalid Input");
                   }
               }
           }
}
