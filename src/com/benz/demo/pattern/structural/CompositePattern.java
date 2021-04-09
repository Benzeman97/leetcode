package com.benz.demo.pattern.structural;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*

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
*/

interface Component{
    double display();
}

class Leaf implements Component{

    private String name;
    private String brand;
    private double price;

    public Leaf(String name,String brand,double price)
    {
        this.name=name;
        this.brand=brand;
        this.price=price;
    }

    @Override
    public double display() {
        System.out.printf("Name : %s\tBrand : %s\tPrice : %.2f\n",name,brand,price);
        return price;
    }
}

class Composite implements Component{

    private String name;
    private List<Component> components;
    private double price;

    public Composite(String name)
    {
        this.name=name;
        components=new ArrayList<>();
        price=0.0;
    }

    public void addComponent(Component component)
    {
        components.add(component);
    }

    @Override
    public double display() {

        System.out.println(name);
        for(Component com : components)
           price += com.display();

        System.out.printf("The total price is %.2f\n",price);
        return price;
    }
}

public class CompositePattern{

    public void show() {
        Component ram = new Leaf("RAM", "Sony", 5000.0);
        Component cpu = new Leaf("CPU", "SnapDragon", 67000.0);
        Component vga = new Leaf("VGA", "Samsung", 14500.0);

        Component hd = new Leaf("Hard Drive","ComBack",14500.0);
        Component battery = new Leaf("Battery","LifeTime",9500.0);

        Component os =new Leaf("Windows","Microsoft",24000.0);


        Composite motherBoard = new Composite("MotherBoard");
        motherBoard.addComponent(ram);
        motherBoard.addComponent(cpu);
        motherBoard.addComponent(vga);

        Composite hardware = new Composite("Hardware");
        hardware.addComponent(motherBoard);
        hardware.addComponent(hd);
        hardware.addComponent(battery);

        Composite software=new Composite("Software");
        software.addComponent(os);

        Composite computer=new Composite("Computer");
        computer.addComponent(hardware);
        computer.addComponent(software);

        computer.display();

    }


}