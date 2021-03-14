package com.benz.demo.pattern.structural;

import java.util.ArrayList;
import java.util.List;

interface Component{

    double showPrice();
}

class Leaf implements Component
{
    private String name;
    private double price;

    public Leaf(String name,double price)
    {
        this.name=name;
        this.price=price;
    }

    @Override
    public double showPrice() {
        System.out.println(String.format(" %s \t %f",name,price));
        return price;
    }


}

class Composite implements Component{

    private String name;
    private final List<Component> components;
    private double total;

    public Composite(String name)
    {
        this.name=name;
        components=new ArrayList<>();
    }

    public void addComponents(Component com)
    {
        components.add(com);
    }

    @Override
    public double showPrice() {
        System.out.println(name);

        for(Component com : components) {
            total += com.showPrice();
        }

        System.out.println(name+" total is "+total);

        return total;
    }


}

public class CompositePattern {

    public void calculate()
    {
        Component hd = new Leaf("Hard Drive",12000.00);
        Component ram = new Leaf("RAM",16000.00);
        Component cpu = new Leaf("CPU",45000.00);

        Composite mb =new Composite("Mother Board");
        mb.addComponents(ram);
        mb.addComponents(cpu);

        Composite id= new Composite("Internal Device");
        id.addComponents(hd);
        id.addComponents(mb);

        Component mo=new Leaf("Mouse",2500.00);
        Component kb = new Leaf("Key Board",4000.00);
        Component sp=new Leaf("Speaker",6000.00);

        Composite ed=new Composite("External Device");
        ed.addComponents(mo);
        ed.addComponents(kb);
        ed.addComponents(sp);

        Composite com =new Composite("Computer");
        com.addComponents(id);
        com.addComponents(ed);

        com.showPrice();

    }

}
