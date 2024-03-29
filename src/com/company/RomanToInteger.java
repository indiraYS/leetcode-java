package com.company;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> romans = new HashMap<>();
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);
        int res = romans.get(s.charAt(s.length()-1));
        for (int i = s.length()-2; i > -1; i--) {
            if (s.charAt(i) == 'I') {
                if (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X' ) {
                    res -= 1;
                } else {
                    res += 1;
                }
            } else if (s.charAt(i) == 'X') {
                if (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C') {
                    res -= 10;
                } else {
                    res += 10;
                }
            } else if (s.charAt(i) == 'C') {
                if (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M') {
                    res -= 100;
                } else {
                    res += 100;
                }
            } else {
                res += romans.get(s.charAt(i));
            }
        }
        return res;
    }

    /**
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * For example, 2 is written as II in Roman numeral, just two ones added together.
     * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
     * Roman numerals are usually written largest to smallest from left to right.
     * However, the numeral for four is not IIII. Instead, the number four is written as IV.
     * Because the one is before the five we subtract it making four.
     * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given a roman numeral, convert it to an integer.
     */
}
