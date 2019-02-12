package com.udemy.algorithms.sorting;

import com.udemy.algorithms.helpers.ArrayHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSortChar {

    private static void sort(String[] arr) {

        int maxLen = getMaxLength(arr);

        for(int i  = 1; i <= maxLen; i++) {
            radixSortSingle(arr, i, 26);
        }
    }

    private static int getMaxLength(String[] arr) {
        int maxLength = 0;
        for(String str : arr) {
            if(str.length() > maxLength) {
                maxLength= str.length();
            }
        }
        return maxLength;
    }

    private static void radixSortSingle(String[] arr, int iter,  int radix) {
        List[] indexed = new List[radix];

        for(String str : arr) {
            int index = getCharAt(str, iter);

            if(indexed[index] == null) {
                indexed[index] = new ArrayList();
            }

            indexed[index].add(str);
        }

        int k = 0;
        for (List list : indexed) {
            if (list != null) {
                for (String str : (List<String>) list) {
                    arr[k++] = str;
                }
            }
        }
    }

    private static int getCharAt(String str, int i) {
        int pos = str.length() - i;
        pos = pos >= 0 ? pos : 0;
        return str.charAt(pos) - 'a';
    }

    public static void main(String[] args) {
        String[] inputStr = new String[]{"ertoiuritu","sfdgsg","dsgsdgdg", "sdggwtewpot", "peiproiyr", "aeiemlb", "ertoiuritu"};
        System.out.println("Original array " + Arrays.toString(inputStr));
        RadixSortChar.sort(inputStr);
        System.out.println("Sorted array " + Arrays.toString(inputStr));

    }
}
