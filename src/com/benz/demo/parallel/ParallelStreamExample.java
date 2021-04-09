package com.benz.demo.parallel;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ParallelStreamExample {

    public void parallelStream()
    {
        long start=0;
        long end=0;

      /*  start = System.currentTimeMillis();
        IntStream.range(1,100).forEach(System.out::println);
        end = System.currentTimeMillis();

        System.out.println("Execution Time with Single Stream : "+(end-start));

        System.out.println("==============================================");

        start=System.currentTimeMillis();
        IntStream.range(1,100).parallel().forEach(System.out::println);
        end=System.currentTimeMillis();

        System.out.println("Execution Time with Parallel Stream : "+(end-start));*/
/*
      IntStream.range(1,10).forEach(i->{
          System.out.println("Current Thread : "+Thread.currentThread().getName()+" : "+i);
      });

      IntStream.range(1,10).parallel().forEach(i->{
          System.out.println("Current Thread : "+Thread.currentThread().getName()+" : "+i);
      });*/

        List<Employee> employees = EmployeeDatabase.getEmployees();

       start=System.currentTimeMillis();
        double salaryWithSingleStream = employees.stream().map(Employee::getSalary).mapToDouble(s->s).average().getAsDouble();
       end=System.currentTimeMillis();

        System.out.println("Execution time with single stream : "+(end-start)+" and Average Salary : "+salaryWithSingleStream);

        System.out.println("=====================================================");

        start=System.currentTimeMillis();
        double salaryWithParallelStream = employees.parallelStream().map(Employee::getSalary).mapToDouble(s->s).average().getAsDouble();
        end = System.currentTimeMillis();

        System.out.println("Execution time with parallel stream : "+(end-start)+" and Average salary : "+salaryWithParallelStream);


    }
}
