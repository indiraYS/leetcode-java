package com.company.easy;

import java.util.HashMap;
import java.util.Map;

public class KWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int cnt = 0;
        for (int j = 0; j < mat.length; j++) {
            cnt = 0;
            for (int i = 0; i < mat[j].length; i++) {
                if (mat[j][i] != 0) cnt++;
            }
            mp.put(j, cnt);
        }
        int[] arr = mp.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(k)
                .map(x -> x.getKey())
                .mapToInt(i -> i)
                .toArray();
        return arr;
    }
}
