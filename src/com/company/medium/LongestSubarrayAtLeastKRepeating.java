package com.company.medium;

import sun.security.util.ArrayUtil;

import java.util.*;
import java.util.stream.Collectors;

public class LongestSubarrayAtLeastKRepeating {

    private List<Integer> groups;
    private List<Character> groupMap;
    public int longestSubstring(String s, int k) {
        if (s.length()==1) return 1 >= k ? 1: 0;
        if (k == 1) return s.length();

        groups = new ArrayList<>();
        groupMap = new ArrayList<>();

        char prev = '-';

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != prev) {
                groups.add(1);
                groupMap.add(s.charAt(i));
                prev = s.charAt(i);
            } else {
                groups.set(groups.size()-1, groups.get(groups.size()-1) + 1);
            }
        }

        return longSubstr(k, 0, groupMap.size()-1);
    }

    private int longSubstr(
            int k,
            int start,
            int end
    ) {
        if (end < start) return 0;
        if (start == end) {
            int res = groups.get(start);
            return res < k ? 0 : res;
        }

        Map<Character, Integer> mp = new HashMap<>();
        for (int i = start; i <=  end; i++) {
            int curval  = groups.get(i);
            mp.computeIfPresent(groupMap.get(i), (key, val) -> val + curval);
            mp.computeIfAbsent(groupMap.get(i), (key) -> curval);
        }
        int max = 0;
        int current = 0;

        Set<Character> exclusion = new HashSet<>();
        for (Map.Entry<Character, Integer> entry: mp.entrySet()) {
            if (entry.getValue() < k) {
                if (current > max) max = current;
                current = 0;
                exclusion.add(entry.getKey());
            } else {
                current += entry.getValue();
            }
        }
        if (current > 0 && current > max) max = current;

        if (exclusion.size() > 0) {
            max = 0;
            int last = start;
            List<int[]> ranges = new ArrayList<>();
            for (int i  = start; i <= end; i++) {
                if (exclusion.contains(groupMap.get(i))) {
                    ranges.add(new int[]{last, i-1});
                    last = i+1;
                }
            }
            if (last < groups.size()) {
                ranges.add(new int[]{last,  groups.size()-1});
            }
            for (int[] r: ranges) {
                current = longSubstr(k, r[0], r[1]);
                if (current > max) max= current;
            }
        }
        return max < k ? 0: max;
    }

    public int longestSubstring1(String s, int k) {
        if (s.length()==1) return 1 >= k ? 1: 0;
        int next = 0;

        int different = 0;

        int[] init_arr = new int[26];
        init_arr[s.charAt(0)-97] = 1;

        if (s.charAt(0) != s.charAt(1)) {
            init_arr[s.charAt(1)-97] = 1;
            next = longestSubstr(s, init_arr, 2, k);

            int[] diff_arr = new int[26];
            diff_arr[s.charAt(1)-97] = 1;
            different = longestSubstr(s, diff_arr, 2, k);
        } else {
            next = longestSubstr(s, init_arr, 1, k);
        }

//        Map<Character, Integer> init = new HashMap<Character, Integer>() {{
//            put(s.charAt(0), 1);
//        }};
//        if (s.charAt(0) != s.charAt(1)) {
//            init.put(s.charAt(1), 1);
//            next = longestSubstr(s, init, 2, k);
//
//            Map<Character, Integer> newMap = new HashMap<>();
//            newMap.put(s.charAt(1), 1);
//
//            different = longestSubstr(s, newMap, 2, k);
//        } else {
//            next = longestSubstr(s, init, 1, k);
//        }

        return Math.max(next, different);
    }

    private int longestSubstr(String s, Map<Character, Integer> groups, int start, int k) {
        do {
            Integer found = groups.get(s.charAt(start));
            if (found != null) {
                groups.put(s.charAt(start), found + 1);
                start++;
            } else {
                break;
            }
        } while (start < s.length()); //  && groups.containsKey(s.charAt(start))

        if (start < s.length()-1)
        {
            int current = count(groups, k); // count before new character a:9, start=9
            // System.out.println("current = "+ current + ", start= " + start + ", grp = "+ printMap(groups));
            // continue with new
            // groups.put(s.charAt(start), 1); // a:9,b:1, start=9+1

            Map<Character, Integer> continueMap = new HashMap<>(groups);
            continueMap.put(s.charAt(start), 1);
            int different = longestSubstr(s, continueMap, start + 1, k);

            int another = 0;
            // System.out.println("current = "+ current +", different=" + different + ", start= " + start + ", grp = "+ printMap(groups));
            if ( current > 0 && different == 0 || different >= 0 && current==0) {
                // System.out.println("here : current = "+ current +", different=" + different + ", start= " + start +" , nextcharacter=" + s.charAt(start));
                Map<Character, Integer> newMap = new HashMap<>();
                newMap.put(s.charAt(start), 1);
                another = longestSubstr(s, newMap, start + 1, k);
            }

            return Math.max(Math.max(current, different), another);
        }
        else
        {
            return count(groups, k);
        }
    }

    public String printMap(Map<Character, ?> map) {
        String mapAsString = map.keySet().stream()
                .map(key -> key + "=" + map.get(key))
                .collect(Collectors.joining(", ", "{", "}"));
        return mapAsString;
    }

    private int count(Map<Character, Integer> mp, int k) {
        int current = 0;
        for (Map.Entry<Character, Integer> entry: mp.entrySet()) {
            if (entry.getValue() < k) {
                current = 0;
                break;
            }
            current += entry.getValue();
        }
        return current;
    }

    private int count(int[] arr, int k) {
        int current = 0;
        for (int item: arr) {
            if (item > 0 && item < k) {
                current = 0;
                break;
            }
            current += item;
        }
        return current;
    }

    private int longestSubstr(String s, int[] groups, int start, int k) {
        do {
            int found = groups[(int)s.charAt(start)-97];
            if (found != 0) {
                groups[(int)s.charAt(start)-97] = groups[(int)s.charAt(start)-97] + 1;
                start++;
            } else {
                break;
            }
        } while (start < s.length()); //  && groups.containsKey(s.charAt(start))

        /*
        if (start < s.length()-1)
        {
            int currItem = groups[s.charAt(start-1) - 97];
            int current = currItem < k ? 0 : count(groups, k); // count before new character a:9, start=9
            //int current = count(groups, k);

            int[] new_arr = Arrays.copyOf(groups, 26);
            new_arr[s.charAt(start) -97] = 1;
            int different = longestSubstr(s, new_arr, start + 1, k);

            int another = 0;
            if ( current > 0 && different == 0 || different >= 0 && current==0) {
                int[] empty = new int[26];
                empty[s.charAt(start)-97] = 1;
                another = longestSubstr(s, empty, start + 1, k);
            }

            return Math.max(Math.max(current, different), another);
        }*/

        if (start < s.length()-1)
        {
            int currItem = groups[s.charAt(start-1) - 97];
            int current = currItem < k ? 0 : count(groups, k); // count before new character a:9, start=9
            //int current = count(groups, k);

            int different = 0;
            // if (currItem >= k) {
                int[] new_arr = Arrays.copyOf(groups, 26);
                new_arr[s.charAt(start) - 97] = 1;
                different = longestSubstr(s, new_arr, start + 1, k);
            //}

            int[] empty = new int[26];
            empty[s.charAt(start)-97] = 1;
            int another = longestSubstr(s, empty, start + 1, k);

            return Math.max(Math.max(current, different), another);
        }
        else
        {
            return count(groups, k);
        }
    }
}
