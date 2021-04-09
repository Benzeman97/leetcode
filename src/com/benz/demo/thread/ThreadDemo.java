package com.benz.demo.thread;

public class ThreadDemo {

   private int count;

   public ThreadDemo()
   {
     count=0;
   }

    public void start() throws Exception
    {
      Thread th1=new Thread(() ->{
        for(int i=0;i<=1000;i++)
        System.out.println("Hello Kelly Brook");});

      th1.setName("Kelly");
     th1.setPriority(Thread.NORM_PRIORITY);

      Thread th2=new Thread(() -> {
        for(int i=1;i<=1000;i++) {
          if(i==100)
            count=i;
          System.out.println("Welcome Benzema");
        }
        });
      th2.setPriority(Thread.MIN_PRIORITY);
      th2.setName("Benz");

      Thread th3=new Thread(() -> {
        for(int i=1;i<=count;i++)
        System.out.println("The kama");
        });

      th3.setName("Doto");
      th3.setPriority(9);

      th1.start();
      th2.start();
      th2.join();
      th3.start();
    }

}
