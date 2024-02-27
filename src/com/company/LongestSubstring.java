package com.company;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() > 0) {
            int max = 1;
            int cnt = 0;
            int zz = 0;

            for (int i = 1; i < s.length(); i++) {
                cnt = 0;
                for (int j = zz; j < i; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        zz = j + 1; // and start from next
                        cnt = 0;
                    } else {
                        cnt++;
                    }
                }
                cnt++;
                if (cnt > max) max = cnt;
            }
            return max;
        } else {
            return 0;
        }
    }
}
