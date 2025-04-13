package com.company.medium;

public class SearchInRotatedSortedArray {
    // 4, 5, 6, 7, 0, 1, 2  , target=0, res=4
    // 4, 5, 6, 7, 0, 1, 2  , target=3, res=-3
    public int search(int[] nums, int target) {
        int res = -1;
        res = searchInt(nums, target, 0, nums.length-1);
        return res;
    }

    int searchInt(int[] nums, int target, int st, int end) {
        if (end < st || end==st && nums[st] != target) {
            return -1;
        } else if (nums[st] == target) {
            return st;
        } else if (nums[end] == target) {
            return end;
        } else {
            int pivot = st + (end - st)/2;
            int res = -1;

            if (nums[pivot] >= target) {
                res = searchInt(nums, target, st, pivot);
                if (res == -1) {
                    res = searchInt(nums, target, pivot+1, end);
                }
            } else {
                res = searchInt(nums, target, pivot+1, end);
                if (res == -1) {
                    res = searchInt(nums, target, st, pivot);
                }
            }



            return res;
        }
    }
}
