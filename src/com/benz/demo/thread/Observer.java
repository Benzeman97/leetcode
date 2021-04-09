package com.benz.demo.thread;

public class Observer {

    private int count;
    private boolean flag;

    public Observer()
    {
        count=0;
        flag=false;
    }

    public synchronized void getCount() throws Exception
    {
        while (!flag)
            wait();
        System.out.println("Get "+count);
        flag=false;
        Thread.sleep(5000);
        notify();
    }

    public synchronized void setCount(int count) throws Exception
    {
        while (flag)
            wait();
        this.count = count;
        System.out.println("Set "+count);
        flag=true;
        Thread.sleep(5000);
        notify();

    }

    public void start() throws Exception
    {
        Observer observer=new Observer();
        new Producer(observer);
        new Consumer(observer);
    }
}

class Producer{

    Observer observer;

    public Producer(Observer observer)
    {
        this.observer=observer;
        new Thread( () -> {
            try {
                putCount();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Producer").start();
    }

    public void putCount() throws Exception
    {
        int count=0;

        while (true)
        {
             observer.setCount(++count);
           // Thread.sleep(5000);
        }
    }

}

class Consumer extends Thread{

    Observer observer;

    public Consumer(Observer observer)
    {
        this.observer=observer;
        new Thread(this,"Consumer").start();
    }

    public void getCount() throws Exception
    {
        while(true)
        {
            observer.getCount();
          //  Thread.sleep(5000);
        }
    }

    @Override
    public void run() {
        try {
            getCount();
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}