package com.udemy.algorithms.sorting;

import com.udemy.algorithms.helpers.ArrayHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RadixSort {

    private static void sort(int[] arr) {
        boolean shouldRun = true;
        for(int i  = 0; i < 10 && shouldRun; i++) {
            shouldRun = radixSortSingle(arr, i, 10);
        }
    }

    private static boolean radixSortSingle(int[] arr, int iter,  int radix) {
        List[] indexed = new List[radix];
        boolean shouldRun = false;
        int divider = (int) Math.pow(10, iter);
        for(int num : arr) {
            int index = getDigit(num, divider, radix);
            if(index != 0) {
                shouldRun = true;
            }

            if(indexed[index] == null) {
                indexed[index] = new ArrayList();
            }

            indexed[index].add(num);
        }

        if(!shouldRun) {
            return false;
        }

        int k = 0;
        for (List list : indexed) {
            if (list != null) {
                for (Integer numb : (List<Integer>) list) {
                    arr[k++] = numb;
                }
            }
        }

        return true;
    }


    private static int getDigit(int number, int divider, int radix) {
        return (number/divider) % radix;
    }

    public static void main(String[] args) {
        int[] input = ArrayHelper.generateArray(10,10000);
        System.out.println("Original array " + Arrays.toString(input));
        RadixSort.sort(input);
        System.out.println("Sorted array " + Arrays.toString(input));

    }
}
