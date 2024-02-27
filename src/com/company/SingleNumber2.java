package com.company;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber2 {
    Map<Integer, Integer> groups = new HashMap<>();

    public int singleNumber(int[] nums) {
        int triples = nums.length/3+1;
        Integer key;
        for (int i = 0; i < triples; i++) {
            if (i == triples-1) {
                key = nums[3*i];
                calc(key);
            } else {
                calc(nums[3*i]);
                calc(nums[3*i+1]);
                calc(nums[3*i+2]);
            }
        }

        return groups.entrySet().iterator().next().getKey();
    }

    private void calc(int key) {
        Integer vals = groups.get(key);
        if (vals != null) {
            if (vals + 1 == 3) {
                groups.remove(key);
            } else {
                groups.put(key, vals+1);
            }
        } else {
            groups.put(key, 1);
        }
    }
}
