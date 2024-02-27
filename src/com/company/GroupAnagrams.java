package com.company;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> datas = new HashMap<>();

        for (String str : strs) {
            String key = getKey(str);

            List<String> vals = datas.get(key);

            if (vals == null) {
                List<String> nArr = new ArrayList<>();
                nArr.add(str);
                datas.put(key, nArr);
            } else {
                vals.add(str);
            }
        }

        return new ArrayList<>(datas.values());
    }

    private String getKey(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
}
