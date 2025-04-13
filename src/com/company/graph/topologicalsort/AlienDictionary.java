package com.company.graph.topologicalsort;

import java.util.*;

public class AlienDictionary {
    private int[] path;
    private int offset;
    private Set<Integer> toUse;

    public String alienOrder(String[] words) {
        List<int[]> prev = split(words[0].toCharArray());
        Map<Integer, List<Integer>> adjustment = new HashMap<>();
        List<Integer> ways;
        this.toUse = new TreeSet<>();
        this.offset = 0;

        for (int[] link : prev) {
            ways = adjustment.computeIfAbsent(link[0], k -> new ArrayList<>());
            ways.add(link[1]);
            this.toUse.add(link[0]);
            this.toUse.add(link[1]);
        }
        for (int i = 1; i < words.length; i++)
        {
            List<int[]> cur = split(words[1].toCharArray());

            for (int[] link : cur) {
                if (!isPossible(adjustment, link[0], link[1])) {
                    if (!isPossible(adjustment, link[1], link[0])) {
                        ways = adjustment.get(link[1]);
                        if (ways == null) {
                            ways = adjustment.computeIfAbsent(link[0], k -> new ArrayList<>());
                            ways.add(link[1]);
                        } else {
                            ways.add(link[0]);
                        }
                    } else {
                        return ""; //cycle
                    }
                    this.toUse.add(link[0]);
                    this.toUse.add(link[1]);
                }
            }
        }
        this.path = new int[this.toUse.size()];
        return "";
    }

    private boolean walk(int node, int from, Map<Integer, List<Integer>> dependencies) {
        if (!this.toUse.contains(node)) {
            return true;
        }

        int left = 0;

        if (dependencies.get(node) != null) {
            for (int nextDest : dependencies.get(node)) {
                if (this.toUse.contains(nextDest)) {
                    if (!walk(nextDest, node, dependencies)) {
                        return false;
                    }
                    left++;
                }
            }
        }

        if (left == 0 && this.toUse.contains(node)) {
            this.path[this.offset++] = node;
            this.toUse.remove(node);

            if (from != node && this.toUse.contains(from)) {
                int ll = 0;
                for (int nextDest : dependencies.get(from)) {
                    if (this.toUse.contains(nextDest)) {
                        ll++;
                    }
                }

                if (ll == 0) {
                    this.path[this.offset++] = from;
                    this.toUse.remove(from);
                }
            }
        }


        return true;
    }

    private boolean isPossible(Map<Integer, List<Integer>> adjustment, int a, int b) {
        List<Integer> link = adjustment.get(a);
        if (link == null) return false;
        if (link.contains(b)) return true;
        for (Integer next : link) {
            if (isPossible(adjustment, next, b)) {
                return true;
            }
        }
        return false;
    }

    private List<int[]> split(char[] chars) {
        List<int[]> links = new ArrayList<>();
        char prev = chars[0];
        for (char c : chars) {
            if (c != prev) {
                links.add(new int[]{prev - 97, c - 97});
            }
            prev = c;
        }
        return links;
    }
}

