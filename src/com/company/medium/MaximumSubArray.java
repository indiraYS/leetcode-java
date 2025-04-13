package com.company.medium;

public class MaximumSubArray {
    public int maxSubArray1(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i=0; i< nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) sum = 0;

        }
        return max;
    }
    public int maxSubArray(int[] nums) {
        return findMaxSubarray(nums, 0, nums.length -1);
    }

    private int findMaxSubarray(int[] arr, int low, int high) {
        if (high == low) {
            return arr[low]; // base case
        }
        int mid = (int) Math.floor(  ((double) low + high)/2);
        int left = findMaxSubarray(arr, low, mid);
        int right = findMaxSubarray(arr, mid+1, high);
        int cross = findMaxCrossingSubarray(arr, low, mid, high);

        if (left >= right && left >= cross) {
            return left;
        } else if (right >= left && right >= cross) {
            return right;
        } else {
            return cross;
        }
    }

    private int findMaxCrossingSubarray(int[] arr, int low, int mid, int high)
    {
        int left_sum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > left_sum) {
                left_sum = sum;
            }
        }

        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int j = mid+1; j <= high; j++) {
            sum += arr[j];
            if (sum > right_sum) {
                right_sum = sum;
            }
        }
        return left_sum + right_sum;
    }
}
