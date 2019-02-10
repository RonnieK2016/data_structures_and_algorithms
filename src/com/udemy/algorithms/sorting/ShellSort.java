package com.udemy.algorithms.sorting;

import com.udemy.algorithms.helpers.ArrayHelper;

import java.util.Arrays;

public class ShellSort {

    private static void sort(int[] array) {
        for(int gap = array.length/2; gap > 0; gap /= 2) {
            for(int i = gap; i < array.length; i += gap) {
                int j = i;
                while((j > gap - 1) && array[j - gap] > array[j]) {
                    ArrayHelper.swap(array, j - gap, j);
                    j -= gap;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] input = ArrayHelper.generateArray(10,100);
        System.out.println("Original array " + Arrays.toString(input));
        ShellSort.sort(input);
        System.out.println("Sorted array " + Arrays.toString(input));
    }
}
