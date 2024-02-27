package com.company;

public class ArraySearch {
    /*
Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).

More formally check if there exists two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
-----------
Input: arr = [10,2,5,3]
Output: true
Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
     */
    public static boolean checkIfExist(int[] arr) {
        for (int i : arr) {
            if (i!=0) {
                if (i%2==0) {
                    for (int x : arr) {
                        if (x != 0 && (double) i / (double) x == 2) {
                            return true;
                        }
                    }
                }
            }
        }
        for (int i = 0 ; i < arr.length; i++) {
            if (arr[i]==0) {
                for (int x = i+1 ; x < arr.length; x++) {
                    if (arr[x] == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean validMountainArray(int[] arr) {
        if (arr.length <= 2) {
            return false;
        }

        int max = 0;
        boolean isUp = true;

        for (int i=1; i<arr.length; i++) {
            if (arr[i] ==arr[i-1]) return false;

            if (arr[i] > arr[i-1]) {
                if (!isUp) return false;
                max = i;
            } else {
                isUp = false;
                if (arr[i] >= arr[max] || arr[i] >= arr[i-1]) {
                    return false;
                }
            }
        }

        if (max == 0 || max + 1 == arr.length) {
            return false;
        }
        return  true;
    }
}
