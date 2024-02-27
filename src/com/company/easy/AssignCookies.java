package com.company.easy;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        System.out.println(Arrays.toString(g));
        Arrays.sort(s);
        System.out.println(Arrays.toString(s));
        if (g.length > s.length) {
            return findInt(g, s);
        } else {
            return findInt(s, g);
        }
    }

    public int findInt(int[] g, int[] s) {
        int cnt = 0;
        int prev_j = 0;
        for (int i = 0; i < g.length; i++)
        {
            for (int j = prev_j; j < s.length; j++)
            {
                if (g[i] > s[j]) continue;
                if (g[i] == s[j]) {
                    cnt++;
                    prev_j = j+1;
                }
                break;
            }
        }
        return cnt;
    }
}
