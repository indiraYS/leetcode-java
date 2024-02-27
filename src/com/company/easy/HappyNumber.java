package com.company.easy;

import java.util.HashMap;

public class HappyNumber {
    private HashMap<Integer, Boolean> nms = new HashMap<>();

    public boolean isHappy(int n) {
        if (n == 1 || n % 10 == 0 && n % 2 !=0 ) {
            return true;
        }

        if (nms.get(n) != null) {
            return false;
        }
        nms.put(n, false);
        String[] nums = String.valueOf(n).split("", 0);

        int newNum = 0;
        for (String num : nums) {
            newNum += Math.pow(Integer.valueOf(num), 2);
        }
        return isHappy(newNum);
    }
}
