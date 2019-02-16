package com.udemy.algorithms;

import com.udemy.algorithms.models.Employee;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class RemoveDuplicates {

    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));

        HashSet<Employee> unique = new HashSet<>();
        Iterator<Employee> iterator = employees.iterator();
        while(iterator.hasNext()) {
            Employee employee = iterator.next();
            if(unique.contains(employee)) {
                iterator.remove();
                continue;
            }
            unique.add(employee);
        }

        System.out.println("List w/o duplicates " + employees);

    }
}
