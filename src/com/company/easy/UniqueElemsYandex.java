package com.company.easy;

import java.util.Arrays;

public class UniqueElemsYandex {
    public int calc(int[] items) {
        boolean flag=false;
        int dup=0;
        Arrays.sort(items);
        for (int i=1;i < items.length;  i++) {
            if (items[i] != items[i-1]) {
                flag=false;
            } else {
                if (!flag) {
                    dup++;
                }
                dup++;
                flag=true;
            }
        }
        return items.length-dup;
    }
}
