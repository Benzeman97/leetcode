package com.benz.demo.lambda;


public class LambdaDemo {

    public void start()
    {
       Home home=new Home();
        home.main();
    }
}

@FunctionalInterface
interface Inter{
    void perform();
}

@FunctionalInterface
interface Arithmetic{

    int sum(int x,int y,int c);
}

interface WSO2{
    void process(int x,int y);
}

class Student{

    private int stuId;
    private String name;
    private int age;

    public Student(){}

    public Student(int stuId,String name,int age)
    {
        this.stuId=stuId;
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "stuId = " + stuId +
                "\tname = '" + name+
                "\tage = " + age;
    }
}

@FunctionalInterface
interface Multiplication{
    void mul(int x,int y);
}

class Home{

    public void main()
    {

    }

}