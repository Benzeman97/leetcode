package com.benz.demo.pattern.creational;
/*
interface OS
{
     void name();
     void version();
}

class Windows implements OS{

    @Override
    public void name() {
        System.out.println("I am about to die");
    }

    @Override
    public void version() {
        System.out.println(10);
    }
}

class Android implements OS{

    @Override
    public void name() {
        System.out.println("Most Popular");
    }

    @Override
    public void version() {
        System.out.println(10);
    }
}

class IOS implements OS{

    @Override
    public void name() {
        System.out.println("Most Secured");
    }

    @Override
    public void version() {
        System.out.println(14);
    }
}

public class FactoryOS {

    public OS getInstance(String name)
    {
        if(name.toLowerCase().equals("windows"))
            return new Windows();
        else if(name.toLowerCase().equals("android"))
            return new Android();
        else
            return new IOS();
    }

    public void display()
    {
        OS os= this.getInstance("android");

        os.name();
        os.version();
    }
}*/

interface OS{
    void version();
    void name();
}

class Windows implements OS{

    @Override
    public void version() {
        System.out.println(10);
    }

    @Override
    public void name() {
        System.out.println("Windows");
    }
}

class IOS implements OS{

    @Override
    public void version() {
        System.out.println(14);
    }

    @Override
    public void name() {
        System.out.println("IOS");
    }
}

class Android implements OS{

    @Override
    public void version() {
        System.out.println(11);
    }

    @Override
    public void name() {
        System.out.println("Android");
    }
}

public class FactoryOS{

    public OS getInstance(String name)
    {
        if(name.toLowerCase().equals("windows"))
            return new Windows();
        else if(name.toLowerCase().equals("android"))
            return new Android();
        return new IOS();
    }

    public void display()
    {
        OS os = getInstance("windows");

        os.name();
        os.version();
    }
}

