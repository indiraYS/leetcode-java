package com.company.august21;

import java.util.*;


public class AugustChalange21 {
    /**
     * Example 1:
     *
     * Input: s = "ADOBECODEBANC", t = "ABC"
     * Output: "BANC"
     * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
     * Example 2:
     *
     * Input: s = "a", t = "a"
     * Output: "a"
     * Explanation: The entire string s is the minimum window.
     * Example 3:
     *
     * Input: s = "a", t = "aa"
     * Output: ""
     * Explanation: Both 'a's from t must be included in the window.
     * Since the largest window of s only has one 'a', return empty string.
     * @return
     */
    /**
     * Constraints:
     *
     * m == s.length
     * n == t.length
     * 1 <= m, n <= 105
     * s and t consist of uppercase and lowercase English letters.
     *
     *
     * Follow up: Could you find an algorithm that runs in O(m + n) time?
     * @return
     */
    public static String minimumSubstring(String s, String t) {
        if (t.length() > s.length()) return "";
        if (s.contains(t)) return t;
        char[] arr = t.toCharArray();
        Arrays.parallelSort(arr);
        List<String> strs = new ArrayList<>();
        int[] intersects = new int[arr.length];
        String tmp;
        int x;

        for (int i = t.length(); i <= s.length() ; i++) {
            tmp = s.substring(s.length()-i);
            if (tmp.length() < arr.length) break;

            Arrays.fill(intersects, -1);
            int cnt = 0;
            for (char c : arr) {
                // if array not empty
                if (cnt > 0 && tmp.charAt(intersects[cnt-1])==c) {
                    x = tmp.indexOf(c, intersects[cnt-1]+1);
                } else {
                    x = tmp.indexOf(c);
                }
                if (x > -1) {
                    intersects[cnt++] = x;
                }
            }
            /*for (int z = cnt; z < arr.length; z++) {
                intersects[z] = -1;
            }*/
            if (intersects[intersects.length-1] > -1) {
                Arrays.parallelSort(intersects);
                strs.add(tmp.substring(intersects[0], intersects[intersects.length-1]+1));
            }
        }
        if (strs.size() > 0) {
            //strs.sort(Comparator.comparing(String::length));
            Collections.sort(strs, Comparator.comparing(String::length));
            return strs.get(0);
        } else {
            return "";
        }
    }

    /**
     * how to load
    try {
            String str = readFile("/Users/indira/work/test/totalstr.txt", StandardCharsets.UTF_8);
            String search = readFile("/Users/indira/work/test/searchstr.txt", StandardCharsets.UTF_8);
            String shortest212 = (new AugustChalange21()). minimumSubstring2(str, search);
            System.out.println(shortest212.length());
            System.out.println(shortest212);

        } catch (Exception e) {
            e.printStackTrace();
        }
     */


    public String minimumSubstring2(String s, String t) {
        if (t.length() > s.length()) return "";
        if (s.contains(t)) return t;
        char[] arr = t.toCharArray();
        Arrays.parallelSort(arr);

        int diff = s.length() - t.length(); // 90000
        int x = -1, max, min;

        StrPair minPair = new StrPair(0, s.length()-1);

        for (int i = diff; i >= 0 ; i--) {
            //Arrays.fill(intersects, -1);
            max = i; min = s.length()-1;
            x = -1;
            for (char c : arr) {
                // if array not empty
                if (x > -1 && s.charAt(x)==c) {
                    x = s.indexOf(c, x+1);
                } else {
                    x = s.indexOf(c, i);
                }
                if (x > -1) {
                    if (x > max) max = x;
                    if (x < min) min = x;
                } else {
                    break;
                }
            }

            if (x > -1) {
                if (max - min < minPair.snd - minPair.fst) {
                    minPair.fst = min;
                    minPair.snd = max;
                }
            }
        }
        if (x > -1) {
            return s.substring(minPair.fst, minPair.snd+1);
        } else {
            return "";
        }
    }

    private class StrPair implements Comparable<StrPair>{
        int fst;
        int snd;

        public StrPair(int fst, int snd) {
            this.fst = fst;
            this.snd = snd;
        }

        @Override
        public int compareTo(StrPair o) {
            return Integer.compare(this.snd - this.fst, o.snd - o.fst);
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }

    private class ItemSearch  {
        private Character character;
        private int pos;

        public Character getCharacter() {
            return character;
        }

        public void setCharacter(Character character) {
            this.character = character;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }

        public ItemSearch(Character character, int pos) {

            this.character = character;
            this.pos = pos;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ItemSearch that = (ItemSearch) o;
            return pos == that.pos &&
                    Objects.equals(character, that.character);
        }

        @Override
        public int hashCode() {
            return Objects.hash(character, pos);
        }
    }

   /* public static String minimumSubstring2(String s, String t) {
        if (t.length() > s.length()) return "";
        if (s.contains(t)) return t;



        Map<Integer,Character> tMap = IntStream.range(0, t.length())
                .boxed().collect(Collectors.toMap(Function.identity(), t::charAt));

        Map<Integer, Character> sMap = IntStream.range(0, s.length())
                .boxed().collect(Collectors.toMap(Function.identity(), s::charAt));

        List<Character> uqList = tMap.values()
                .stream()
                .distinct()
                .collect(Collectors.toList());

        //System.out.println(s.length());
        sMap = sMap
                .entrySet()
                .stream()
                .filter(x-> uqList.contains(x.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
        ;
        // System.out.println(sMap.size());
        // System.out.println(sMap);
        // return "Ok";
        int[] intersects = new int[tMap.size()];
        Map<Integer, Character> tmpMap = null;

        int diff = sMap.size() - tMap.size();

        //System.out.println(sMap.size() +" - " +  tMap.size());
        System.out.println(diff);
        tmpMap = sMap.entrySet().stream()
                .filter( xx -> xx.getKey() > diff )
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(tmpMap);
        return "Ok";

        for (int i = 0; i <= diff ; i++) {
            Arrays.fill(intersects, -1);
            tmpMap.put()

        }
    }*/

}
