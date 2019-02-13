package com.udemy.algorithms;

import com.udemy.algorithms.datastructures.DoublyLinkedList;
import com.udemy.algorithms.models.Employee;

public class DoublyLinkedListTest {

    public static void main(String[] args) {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marySmith = new Employee("Mary", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        DoublyLinkedList<Employee> list = new DoublyLinkedList<>();

        list.addToFront(janeJones);
        list.addToFront(johnDoe);
        list.addToFront(marySmith);
        list.addToFront(mikeWilson);
        list.printList();

        list.addBefore(billEnd, johnDoe);
        list.addBefore(new Employee("Someone", "Else", 1111), mikeWilson);

        list.addBefore(new Employee("Someone2", "Else2", 1111), marySmith);
        list.printList();

    }

}
