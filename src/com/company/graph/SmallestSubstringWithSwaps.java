package com.company.graph;

import java.util.*;

public class SmallestSubstringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        Set seen = new HashSet(); // save time by realesing untouched nodes

        DJS djs = new DJS(s.length());
        for (List<Integer> pair:pairs) {
            djs.union(pair.get(0),pair.get(1));
            seen.add(pair.get(0));
            seen.add(pair.get(1));
        }

        int[] comp = new int [s.length()];

        Map<Integer , int[]> map = new HashMap();
        for (int i=0; i< s.length(); i++) {
            if (!seen.contains(i)) continue;
            comp[i] = djs.find(i);
            map.putIfAbsent(comp[i],new int[26]);
            map.get(comp[i])[(s.charAt(i)) - 'a']++;
        }

        StringBuilder sol = new StringBuilder();
        for (int i=0; i< s.length(); i++) {
            if (!seen.contains(i)) {
                sol.append(s.charAt(i));
                continue;
            }
            int [] chars = map.get(comp[i]);
            char next = '~';
            for (int j=0;j<26;j++){
                if (chars[j]>0){
                    chars[j]--;
                    next = (char) ('a' + j);
                    break;
                }
            }
            sol.append (next);
        }

        return sol.toString();
    }


    public class DJS{

        int[] parent;
        int[] rank;
        int[] wells;


        public DJS(int size){
            parent = new int[size];
            for (int i = 0; i<size; i++) parent[i]=i;
        }

        public void union(int a, int b){
            int aParent = find(a), bParent = find(b);
            if (aParent < bParent) parent[bParent] = aParent;
            else parent[aParent] = bParent;
        }

        public int find (int a){
            if (parent[a]==a) return a;
            return find (parent[a]);
        }
    }
}
