package com.company;

public class LargestSubstringBetweenTwo {
    public int maxLengthBetweenEqualCharacters(String s) {
        int max = -1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = chars.length-1; j > i; j--) {
                if (chars[i] == chars[j]) {
                    return j - i -1; // there were wrong
                }
            }
        }
        return max;
    }
    // fastest
    public int maxLengthBetweenEqualCharacters1(String s) {
        int max = -1;
        char[] chars = s.toCharArray();
        for (int j = chars.length-1; j > -1; j--) {
            for (int i = 0; i + j < chars.length; i++) {
                if (chars[i+j] == chars[i]) {
                    return j - 1;
                }
            }
        }
        return max;
    }
}
