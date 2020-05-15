package com.jimmy;

/*
 * Hello world!
 *
 */

import java.util.List;
import java.util.logging.Level;


import com.jimmy.Entities.Employee;
import com.jimmy.Entities.Department;
import com.jimmy.Util.*;

import org.hibernate.*;

public class App {

    public static void main(String[] args) {
        Runnable func = () -> {
            System.out.println("whatever");
        };
        func.run();


        HibernateUtil.setLoggingLevel(Level.SEVERE);
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        //---TRANSACTION--//
        Department department = new Department("java");
        session.save(department);
        session.save(new Employee("Jakab Gipsz", department));
        session.save(new Employee("Captain Nemo", department));

        Query q = session.createQuery("From Employee ");
        List<Employee> resultList = q.list();
        System.out.println("num of employess:" + resultList.size());

        Employee e = (Employee) session.get(Employee.class, (long) 2);
        System.out.printf("Second Employees name: %s\n", e.getName());

        session.delete(e);

        for (Employee next : resultList) {
            System.out.println("next employee: " + next.toString());
            System.out.println("Department name:" + next.getDepartment().getName());
        }

        //---END---//
        session.getTransaction().commit();
        session.close();
        HibernateUtil.shutdown();
    }
}
