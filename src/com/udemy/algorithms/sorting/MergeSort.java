package com.udemy.algorithms.sorting;

import com.udemy.algorithms.helpers.ArrayHelper;

import java.util.Arrays;

public class MergeSort {

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= high) {
            if(arr[i] > arr[j]) {
                temp[k++] = arr[i++];
            }
            else {
                temp[k++] = arr[j++];
            }
        }

        while(i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= high) {
            temp[k++] = arr[j++];
        }

        k = 0;
        i = low;
        while (i <= high) {
            arr[i++] = temp[k++];
        }
    }

    private static void sort(int[] arr, int low, int high) {
        if(low >= high) {
            return;
        }

        int mid = (low + high)/2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void main(String[] args) {
        int[] input = ArrayHelper.generateArray(10, 100);
        System.out.println("Original array " + Arrays.toString(input));
        MergeSort.sort(input, 0, input.length - 1);
        System.out.println("Sorted array " + Arrays.toString(input));
    }
}
