package com.company;

import java.util.Arrays;

public class ArrayDuplicateZeros {
    public static void duplicateZeros(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int i = 0;
        while (true) {
            if (i < arr.length - 1) {
                if (arr[i] == 0) {
                    for (int j = arr.length - 1;
                         j > i;
                         j--) {
                        arr[j] = arr[j-1];
                    }
                    i+=2;
                } else {
                    i+=1;
                }
            } else {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
