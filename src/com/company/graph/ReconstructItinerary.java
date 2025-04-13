package com.company.graph;

import java.util.List;

import java.util.*;

public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {

        Comparator<List<String>> compare = new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int res = o1.get(0).compareTo(o2.get(0));
                if (res == 0) return o1.get(1).compareTo(o2.get(1));
                return res;
            }
        };
        tickets.sort(compare);

        int i = 0;
        String prev = "";
        String cur;
        String prevVal = "";
        String curVal;
        ArrayList<List<Integer>> adjustment = new ArrayList<>();
        HashMap<Integer, Integer> copies = new HashMap<>();
        HashMap<String, Integer> dictionary = new HashMap();
        for (; i < tickets.size(); i++) {
            cur = tickets.get(i).get(0);
            curVal = tickets.get(i).get(1);
            if (!cur.equals(prev)) {
                List<Integer> ln = new ArrayList<>();
                ln.add(i);
                copies.put(i, 1);
                adjustment.add(ln);
                dictionary.put(tickets.get(i).get(0), adjustment.size() - 1);
            } else {
                if (curVal.equals(prevVal)) {
                    int idx = adjustment.get(adjustment.size() - 1).get(adjustment.get(adjustment.size() - 1).size() - 1);
                    copies.compute(idx, (k, v) -> {
                        v = v + 1;
                        return v;
                    });
                } else {
                    adjustment.get(adjustment.size() - 1)
                            .add(i);
                    copies.put(i, 1);
                }
            }
            prev = cur;
            prevVal = curVal;
        }


        List<String> path = new ArrayList<>();
        path.add("JFK");
        List<String> res = dfs(adjustment, copies, dictionary, tickets, path, 1);

        return res;
    }

    public List<String> dfs(
            ArrayList<List<Integer>> adjustment,
            HashMap<Integer, Integer> copies,
            HashMap<String, Integer> dictionary,
            List<List<String>> tikets,
            List<String> path,
            int used
    ) {
        List<String> res;
        List<String> newPath;
        String key = path.get(path.size() - 1);
        List<Integer> links = dictionary.get(key) != null ? adjustment.get(dictionary.get(key)) : null;

        if (links != null) {
            for (int i = 0; i < links.size(); i++) {
                Integer left  = copies.get(links.get(i));
                if (left == null) continue;

                newPath = new ArrayList<>(path);
                newPath.add(tikets.get(links.get(i)).get(1));
                HashMap<Integer, Integer> newCopies = (HashMap) copies.clone();
                if (left == 1) {
                    newCopies.remove(links.get(i));
                } else {
                    newCopies.put(links.get(i), left-1);
                }
                res = dfs(adjustment, newCopies, dictionary, tikets, newPath, used + 1);
                if (res != null) return res;
            }
        }

        if (used == tikets.size()) {
            return path;
        }
        return null;
    }
}
