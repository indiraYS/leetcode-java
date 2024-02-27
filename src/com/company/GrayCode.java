package com.company;

import java.util.*;

public class GrayCode
{
    List<Integer> res = new ArrayList<>();
    Set<String> set = new HashSet<>();

    // mySolution
    public List<Integer> grayCode(int n)  {
        int cnt = (int) Math.pow(2,n);
        int i = n-1;
        char[] symbols = new char[n];
        res.add(0);
        Arrays.fill(symbols, '0');
        String search = String.valueOf(symbols);
        set.add(search);

        int top = n-1;
        while (res.size() < cnt) {
            change(symbols, i);
            search = String.valueOf(symbols);

            if (!set.contains(search)) {
                set.add(search);
                res.add(Integer.parseInt(search,2));
                i = n-1;
                continue;
            } else {
                change(symbols, i); // return old value
            }
            if (i == top) {
                top--;
                i = n-1;
            } else {
                i--;
            }
        }
        return res;
    }

    // 000
    // 001
    // 011
    // 010
    // 110
    // 111
    // 101
    // 100

    void change(char[] symbols, int i) {
        if (symbols[i] == '0') {
            symbols[i] = '1';
        } else {
            symbols[i] = '0';
        }
    }

    boolean isAll(char[] symbols, int top) {
        for (int i = symbols.length -1; i >= top; i --) {
            if (symbols[i] != '1') {
                return false;
            }
        }
        return true;
    }

    //
    //
    //   0  0 0
    // 0 1  0 1
    // ----------
    // 1 1  1 0
    //   0  1 1
    //
}
