package com.company;

import java.util.Arrays;

public class ArraysMergeSorted {
    //Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    //Output: [1,2,2,3,5,6]
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        /*if (nums1.length > m && m != 0 && n <= (nums1.length - m)) {
            fillArray(nums1, nums2, m);
            System.out.println(Arrays.toString(nums1));
        } else if (nums2.length > n && n!=0 && m <= (nums2.length - n)) {
            fillArray(nums2, nums1, n);
            System.out.println(Arrays.toString(nums2));
        } else {*/
            int[] a = new int[m+n];
            int x = 0;
            for (int num: nums1) {
                if (num!=0) {
                    a[x++] = num;
                }
            }
            for (int num: nums2) {
                if (num!=0) {
                    a[x++] = num;
                }
            }
            Arrays.sort(a);
            System.out.println(Arrays.toString(a));
        // }

    }

    private static void fillArray(int[] arr1, int[] arr2, int size1) {
        for (int i = (arr1.length - size1), j=0 ; i < arr1.length; i++, j++) {
            if (j < arr2.length) {
                arr1[i] = arr2[j];
            }
        }
        Arrays.sort(arr1);
    }
}
