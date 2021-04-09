package com.benz.demo.pattern.behavioral;
/*

import java.util.ArrayList;
import java.util.List;

interface Subject{
    void subscribe(Subscriber sub);
    void unSubscribe(Subscriber sub);
    void notifySubscriber();
    void upload(String title);
}
interface Observer{
    void channelSubscribe(Channel ch);
    void channelUnSubscribe(Channel ch);
    void update(String msg);
}
class Channel implements Subject{

    private String name;
    private final List<Subscriber> subscribers;
    private String title;

    public Channel(String name)
    {
        this.name=name;
        subscribers=new ArrayList<>();
    }

    @Override
    public void subscribe(Subscriber sub) {
         this.subscribers.add(sub);
    }

    @Override
    public void unSubscribe(Subscriber sub) {
         this.subscribers.remove(sub);
    }

    @Override
    public void notifySubscriber() {
          for(Subscriber sub : subscribers)
              sub.update(title);

    }

    @Override
    public void upload(String title) {
          this.title=title;
          notifySubscriber();
    }
}

class Subscriber implements Observer{

    private String name;
    private Channel channel;

    public Subscriber(String name)
    {
        this.name=name;
    }

    @Override
    public void channelSubscribe(Channel channel) {
        this.channel=channel;
        channel.subscribe(this);
    }

    @Override
    public void channelUnSubscribe(Channel channel) {
        this.channel=channel;
       channel.unSubscribe(this);
    }

    @Override
    public void update(String msg) {
        System.out.println(String.format("Hello %s, %s is uploaded!",name,msg));
    }
}

public class ObserverPattern {

    public void observer()
    {
        Channel ch1 = new Channel("Kelly");
        Channel ch2 = new Channel("Football");

        Subscriber sub1=new Subscriber("Nafaz Benzema");
        Subscriber sub2=new Subscriber("Doto Kama");

        sub1.channelSubscribe(ch1);
        sub2.channelSubscribe(ch1);
        sub1.channelSubscribe(ch2);
        sub2.channelSubscribe(ch2);

        sub1.channelUnSubscribe(ch1);
        sub2.channelUnSubscribe(ch2);

        ch1.upload("Kelly Video");

        ch2.upload("Ronaldo new game");
    }
}
*/

import java.util.ArrayList;
import java.util.List;

interface Subject{
    void upload(String title);
    void notifySubscribers();
    void subscribe(Subscriber subscriber);
    void unSubscribe(Subscriber subscriber);
    int numOfSubscribers();
}

interface Observer{
      void update(String msg);
      void channelSubscribe(Channel channel);
      void channelUnSubscribe(Channel channel);
      int numOfChannels();
}

class Channel implements Subject{
    private String name;
    private List<Subscriber> subscribers;
    private int numOfSubscribers;
    private String title;

    public Channel(String name)
    {
        this.name=name;
        subscribers=new ArrayList<>();
        this.numOfSubscribers=0;
    }

    @Override
    public void upload(String title) {
         this.title=title;
         notifySubscribers();
    }

    @Override
    public void notifySubscribers() {
         for(Subscriber sub : subscribers)
               sub.update(String.format("%s has been uploaded by %s",title,name));
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unSubscribe(Subscriber subscriber) {
        int index = subscribers.indexOf(subscriber);
        subscribers.remove(index);
    }

    @Override
    public int numOfSubscribers() {
        numOfSubscribers = subscribers.size();
        return numOfSubscribers;
    }

}

class Subscriber implements Observer{

    private String name;
    private List<Channel> channels;
    private int numOfChannels;

    public Subscriber(String name)
    {
        this.name=name;
        channels=new ArrayList<>();
        numOfChannels=0;
    }


    @Override
    public void update(String msg) {
        System.out.printf("Hello %s, %s\n",name,msg);
    }

    @Override
    public void channelSubscribe(Channel channel) {
         channel.subscribe(this);
         channels.add(channel);
    }

    @Override
    public void channelUnSubscribe(Channel channel) {
          channel.unSubscribe(this);
          int index = channels.indexOf(channel);
          channels.remove(index);
    }

    @Override
    public int numOfChannels() {
        int numOfChannels= channels.size();
        return numOfChannels;
    }
}


public class ObserverPattern{

    public void start()
    {
         Channel bro=new Channel("Bro");
         Channel xxx= new Channel("Porn Hub");


         Observer nafaz=new Subscriber("Nafaz");
         Observer kelly=new Subscriber("Kelly Brook");

         nafaz.channelSubscribe(bro);
         kelly.channelSubscribe(bro);
         nafaz.channelSubscribe(xxx);

     //   nafaz.channelUnSubscribe(bro);

        bro.upload("My Computer");
        xxx.upload("Julia Ann XXX");

       System.out.println("Bro Subscribers : "+bro.numOfSubscribers());
        System.out.println("XXX  Subscribers : "+xxx.numOfSubscribers());

        System.out.println("Nafaz Channels "+nafaz.numOfChannels());
        System.out.printf("Kelly Channels %d",kelly.numOfChannels());

    }
}

