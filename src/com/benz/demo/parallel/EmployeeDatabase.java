package com.benz.demo.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeDatabase {

    public static List<Employee> getEmployees()
    {
         List<Employee> employees = new ArrayList<>();
        for(int i=1;i<=10;i++)
        {
           employees.add(new Employee(i,"Emp : 1","B grade",Double.valueOf((new Random().nextInt(100-10)+10+900)*100)));
        }
        return employees;
    }
}
