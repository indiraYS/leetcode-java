package com.company.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreeSumClosest {
    // someones solution
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int closest = 0;
        int max = Integer.MAX_VALUE;
        Arrays.sort(nums);


        for(int i=0; i<n-2; i++){
            int j=i+1;
            int k  = n-1;
            while( j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == target)
                    return sum;

                else if(sum < target)
                    j++;

                else
                    k--;
                int diff = Math.abs(sum - target);
                if (diff < max) {
                    max = diff;
                    closest = sum;
                }
            }
        }

        return closest;
    }


    public int threeSumClosestq(int[] nums, int target) {
        Arrays.sort(nums);
        int max = 0;
        int diff = Integer.MAX_VALUE;
        int curdiff;
        int j, k, res;
        for (int i = 0; i < nums.length-2; i++) {
            k=i+1;
            j = nums.length-1;
            while( j < k) {
                res = nums[i] + nums[k] + nums[j];

                if (res == target) return res;

                if (res < target) {
                    k++;
                } else {
                    j--;
                }

                curdiff = Math.abs(res - target);

                if (curdiff < diff) {
                    max = res;
                    diff = curdiff;
                }
            }
        }
        return max;
    }

    public int threeSumClosest111(int[] nums, int target) {

        Arrays.sort(nums);
        Set<String> mins = new HashSet<>();
        String key ;
        int max = nums[0] + nums[1] + nums[nums.length-1];
        int sum;
        int maxdiff = Math.abs(target - nums[0] + nums[1] + nums[nums.length-1]);
        int i=0, j= 2, k=1;

        do {
            sum = nums[i] + nums[k] + nums[j];

//if (sum == target) return sum;
            if (Math.abs(target - sum) < maxdiff) {
                key = i +"" +j + "" + k;
                if (mins.contains(key)) {
                    break;
                }
                max = sum;
                //
                maxdiff = Math.abs(target - sum);
                mins.add(key);

            } else if (Math.abs(target - sum) == maxdiff){
                key = i +"" +j + "" + k;
                if (mins.contains(key)) {
                    break;
                }
                mins.add(key);
                max = sum;
            }

            if (sum < target) {
                if (k + 1 < j) {
                    k++;
                } else if (k-i>1){
                    i++;
                } else if (j== nums.length-1) {
                    break;
                } else {
                    j++;
                }
            } else if (sum > target){
                if (k-i>1 ) {
                    k--;
                } else if (i > 0) {
                    i--;
                } else if (j-k>1) {
                    j--;
                } else {
                    break;
                }
            } else {
                return sum;
            }
        } while (i<k && k < j);
        return max;
    }
}
