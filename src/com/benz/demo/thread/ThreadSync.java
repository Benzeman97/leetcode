package com.benz.demo.thread;

public class ThreadSync {

    private int count;

    public ThreadSync()
    {
        count=0;
    }

    private synchronized void counter()
    {
        count=count+1;
    }

    public void start() throws Exception
    {


        Runnable counter_1=new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=1000;i++)
                    counter();
            }
        };

        Runnable counter_2 =new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=1000;i++)
                    counter();
            }
        };



        Thread count_1=new Thread(counter_1);
        count_1.setName("Counter 1");

        Thread count_2=new Thread(counter_2);
        count_2.setName("Counter 2");

        count_1.start();
        count_2.start();
        count_1.join();
        count_2.join();

        System.out.println("The count is "+count);
    }
}

