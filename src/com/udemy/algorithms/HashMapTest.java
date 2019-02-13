package com.udemy.algorithms;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HashMapTest {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();

        Random random = new Random();

        try {
            Class cl = map.getClass();
            Field field = cl.getDeclaredField("table");
            field.setAccessible(true);

            for (int i = 0; i < 100; i++) {
                Integer integer = random.nextInt(1000);
                map.put(integer, integer);

                System.out.println("Length of map " + ((Object[])field.get(map)).length);
                System.out.println("Size of map " + map.size());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
