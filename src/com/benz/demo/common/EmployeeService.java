package com.benz.demo.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

class Employee{

    private int eid;
    private String ename;
    private double salary;

    public Employee()
    {

    }

    public Employee(int eid,String ename,double salary)
    {
        this.eid=eid;
        this.ename=ename;
        this.salary=salary;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

public class EmployeeService {

    private List<Employee> employees;

    public EmployeeService()
    {
        employees=new ArrayList<>(Arrays.asList(new Employee(1001,"Nafaz Benzema",75000.0),
                new Employee(1002,"Kelly Brook",60000.0),new Employee(1003,"Doto Kama",45000.0),
                new Employee(1004,"Chopa Malli",23000.0)));
    }

    public void display()
    {
        double total = employees.stream().map(emp->emp.getSalary()).mapToDouble(s->s).sum();
        double min =  employees.stream().map(emp->emp.getSalary()).mapToDouble(s->s).min().getAsDouble();
        double max =  employees.stream().map(emp->emp.getSalary()).mapToDouble(s->s).max().getAsDouble();

        System.out.printf("The total salary is %.2f\n",total);
        System.out.printf("The minimum wage is %.2f\n",min);
        System.out.printf("The maximum wage is %.2f\n",max);

        employees.sort((e1,e2) -> {
            if(e1.getSalary()>e2.getSalary())
                return -3;
            else if(e1.getSalary()<e2.getSalary())
                return 3;
            else
                return 0;
        });
        employees.stream().filter(emp->emp.getEname().toUpperCase().startsWith("K")).forEach(emp->{
            System.out.printf("Id : %d\tName : %s\tSalary : %.2f\n",emp.getEid(),emp.getEname(),emp.getSalary());
        });
    }


}

