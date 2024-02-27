package com.company;

import java.util.*;

public class InPlaceOperations {
    /**
    Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
Explanation:
- index 0 --> the greatest element to the right of index 0 is index 1 (18).
- index 1 --> the greatest element to the right of index 1 is index 4 (6).
- index 2 --> the greatest element to the right of index 2 is index 4 (6).
- index 3 --> the greatest element to the right of index 3 is index 4 (6).
- index 4 --> the greatest element to the right of index 4 is index 5 (1).
- index 5 --> there are no elements to the right of index 5, so we put -1.
     */
    public static int[] replaceElements(int[] arr) {

        int idx = arr.length-1;
        int max = -1;
        int tmp;


        while (idx > -1) {
            if (arr[idx] > max) {
                tmp = arr[idx];
                arr[idx] = max;
                max = tmp;
            } else {
                arr[idx] = max;
            }
            idx--;
        }
        return arr;
    }
    /**
     * Input: heights = [1,1,4,2,1,3]
     * Output: 3
     * Explanation:
     * heights:  [1,1,4,2,1,3]
     * expected: [1,1,1,2,3,4]
     * Indices 2, 4, and 5 do not match.
     */
    public static int heightChecker(int[] heights) {
        int [] newArr = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != newArr[i]) {
                count++;
            }
        }
        return count;
    }


    // 4, 3
    public static void swap(int a, int b, int[] heights) {
        heights[a] = heights[a] - heights[b]; // 1, 3
        heights[b] = heights[a] + heights[b]; //
        heights[a] = heights[b] - heights[a];
    }

    /**
     * Given integer array nums, return the third maximum number in this array. If the third maximum does not exist, return the maximum number.
     * Example 1:
     *
     * Input: nums = [3,2,1]
     * Output: 1
     * Explanation: The third maximum is 1.
     * Example 2:
     *
     * Input: nums = [1,2]
     * Output: 2
     * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
     * @param nums
     * @return
     */

    public static int thirdMax(int[] nums) {
        int idx = 1;
        Arrays.sort(nums);
        if (nums.length < 3) {
            return nums[nums.length-1];
        }

        for (int x = 1; x < nums.length; x++) {
            if (nums[x]!=nums[x-1]) {
                nums[idx]=nums[x];
                idx += 1;
            }
        }

        if (idx - 3 > -1) {
            return nums[idx - 3];
        } else {
            return nums[idx-1];
        }
    }

    /**
     * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
     * Example 1:
     *
     * Input: nums = [4,3,2,7,8,2,3,1]
     * Output: [5,6]
     * Example 2:
     *
     * Input: nums = [1,1]
     * Output: [2]
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        int idx = 1;

        for (int x = 1; x < nums.length; x++) {
            if (nums[x]!=nums[x-1]) {
                nums[idx]=nums[x];
                idx += 1;
            }
        }
        /*for (int x = idx; x < nums.length; x++) {
            nums[x]=-1;
        }*/

        List<Integer> absent = new ArrayList<>();
        // heromantia
        for (int x = 1; x < nums.length - idx + 1; x++) {
            if (nums[idx-1] + x <= nums.length) {
                absent.add(nums[idx - 1] + x);
            }
        }

        if (nums[0] !=1) {
            for (int x = nums[0]-1; x > 0; x--) {
                absent.add(x);
            }
        }


        for (int x = 1; x < idx; x++) {
            if (nums[x] - nums[x-1] > 1) {
                int diff = nums[x] - nums[x-1] - 1;
                while (diff > 0) {
                    absent.add(nums[x] - diff--);
                }
            }
        }

        return absent;
    }
}
