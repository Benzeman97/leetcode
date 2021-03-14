package com.benz.demo.pattern.behavioral;

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
