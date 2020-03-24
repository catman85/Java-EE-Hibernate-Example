package com.jimmy;

/*
 * Hello world!
 *
 */

import java.util.List;


import com.jimmy.Entities.Employee;
import com.jimmy.Entities.Department;
import com.jimmy.Util.*;

import org.hibernate.*;

public class App {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Department department = new Department("java");
        session.save(department);

        session.save(new Employee("Jakab Gipsz", department));
        session.save(new Employee("Captain Nemo", department));

        session.getTransaction().commit();

        Query q = session.createQuery("From Employee ");
        List<Employee> resultList = q.list();

        Employee e = (Employee) session.get(Employee.class, (long) 2);
        System.out.printf("First Employees name: %s\n", e.getName());


        System.out.println("num of employess:" + resultList.size());
        for (Employee next : resultList) {
            System.out.println("next employee: " + next.toString());
        }
        session.close();
        HibernateUtil.shutdown();
    }

}
