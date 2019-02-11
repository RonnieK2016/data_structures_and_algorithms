package com.udemy.algorithms.sorting;

import com.sun.istack.internal.NotNull;
import com.udemy.algorithms.helpers.ArrayHelper;

import java.util.Arrays;

public class InsertionSort {

    private static void sort(@NotNull int[] arr, int i) {
        if(i > 1) {
            sort(arr, i - 1);
        }

        int j = i;
        while(j > 0 && arr[j] < arr[j - 1]) {
            ArrayHelper.swap(arr, j, j - 1);
            j--;
        }
    }

    public static void main(String[] args) {
        int[] input = ArrayHelper.generateArray(10, 100);

        System.out.println("Input array: " + Arrays.toString(input));

        InsertionSort.sort(input, input.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(input));
    }
}
