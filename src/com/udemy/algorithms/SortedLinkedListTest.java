package com.udemy.algorithms;

import com.udemy.algorithms.datastructures.SortedLinkedList;

public class SortedLinkedListTest {

    public static void main(String[] args) {

        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;

        SortedLinkedList<Integer> list = new SortedLinkedList<>();
        list.insertSorted(three);
        list.printList();
        list.insertSorted(two);
        list.printList();
        list.insertSorted(one);
        list.printList();
        list.insertSorted(four);
        list.printList();
    }


}
