package com.company.hakerrank;

import java.util.Collections;
import java.util.List;
//todo
public class SubarrayDivision {
    public int birthday(List<Integer> s, int d, int m)
    {   // Write your code here
        int cnt = 0;
        Collections.sort(s);
        for (int i = 0; i < s.size(); i++) {
            cnt += birthday_internal(s, d - s.get(i), m-1, i+1);
        }
        return cnt;
    }

    private static int birthday_internal(
            List<Integer> s,
            int d,
            int m,
            int nextidx
    ) {
        if (d == 0 && m == 0) return 1;

        if (nextidx >= s.size()-1 ||
                d <= 0 && m != 0 ||
                m <= 0 && d != 0) {
            return 0;
        }

        return birthday_internal(s,d-s.get(nextidx), m-1, nextidx+1) +
                birthday_internal(s, d-s.get(nextidx), m-1, nextidx+2);
    }
}
