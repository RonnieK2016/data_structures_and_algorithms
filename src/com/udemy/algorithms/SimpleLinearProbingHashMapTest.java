package com.udemy.algorithms;

import com.udemy.algorithms.datastructures.SimpleLinearProbingHashMap;

public class SimpleLinearProbingHashMapTest {

    public static void main(String[] args) {
        SimpleLinearProbingHashMap<String, Integer> testMap = new SimpleLinearProbingHashMap<>();
        testMap.put("John Doe", 245);
        testMap.put("Jimm Hunt", 567);
        testMap.put("Helen James", 123);
        testMap.put("Jamie James", 563);
        testMap.put("Kelly Rogers", 563);
        testMap.put("Kelly Rogers", 124);
        testMap.put("Kerry King", 124);

        System.out.println("Getting size " + testMap.getSize());
        System.out.println("Verify existing for 'John Doe' " + testMap.containsKey("John Doe"));
        System.out.println("Verify non-existing for 'John Doe1' " + testMap.containsKey("John Doe1"));
        System.out.println("Removing key 'Jimm Hunt' " + testMap.remove("Jimm Hunt"));
        System.out.println("Verify non-existing for 'Jimm Hunt' " + testMap.containsKey("John Doe1"));
        System.out.println("Getting size " + testMap.getSize());
        System.out.println("Getting value by key 'Kelly Rogers' " + testMap.getValue("Kelly Rogers"));
    }

}
