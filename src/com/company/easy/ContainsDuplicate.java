package com.company.easy;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
        {
            int current = nums[i];
            int j = i-1;
            while (j >= 0 && current < nums[j]) // move up greater
            {
                nums[j+1] = nums[j];
                j--;
            }
            if(j>=0  && nums[j]==current){
                return true;
            }
            nums[j+1] = current;
        }
        return false;
    }
}
