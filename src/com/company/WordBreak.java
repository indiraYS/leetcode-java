package com.company;

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> words) {
        char[] alpha1 = groupAlpha(s.toCharArray());
        char[] alpha2 = groupAlpha(words);
        boolean found;
        for (char ch1: alpha1) {
            found = false;
            for (char ch2: alpha2) {
                if (ch1 == ch2) {
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }

        List<String> wordDict = new ArrayList<>(words);
        wordDict.sort((x , y) -> y.length() - x.length() );

        int start = 0;
        int k = 0;
        Stack<Integer> st = new Stack<Integer>();
        Set<Integer> searched = new HashSet<>();
        st.push(0);

        while (!st.isEmpty())
        {
            start = st.pop();
            for (int w =0 ; w < wordDict.size(); w++) {
                k = 0;

                for (int j = 0; j < wordDict.get(w).length(); j++)
                {
                    if (j > 0 && k == 0 || start + k > s.length() -1) break;

                    if (s.charAt(start + k) == wordDict.get(w).charAt(j)) {
                        k++;
                        if (k == wordDict.get(w).length()) {
                            break;
                        }
                    } else {
                        break;
                    }
                }

                if (k == wordDict.get(w).length()) {
                    if (!searched.contains(start + k)) {
                        if (start + k > s.length() - 1) return true;
                        st.push(start + k);
                        searched.add(start + k);
                    }
                }
            }

        }
        return false;
    }

    private char[] groupAlpha(char[] s) {
        Set<Character> set = new HashSet<>();

        for (char ch: s) {
            set.add(ch);
        }
        char[] arr = new char[set.size()];
        int i = 0;
        for (Character character : set) {
            arr[i] = character;
            i++;
        }
        return arr;
    }

    private char[] groupAlpha(List<String> chars2) {
        Set<Character> set = new HashSet<>();

        for (String s: chars2) {
            for (char ch : s.toCharArray()) {
                set.add(ch);
            }
        }
        char[] arr = new char[set.size()];
        int i = 0;
        for (Character character : set) {
            arr[i] = character;
            i++;
        }
        return arr;
    }

//    public boolean wordBreak11(String s, List<String> wordDict) {
//        List<int[]> windows = new ArrayList<>();
//        int cnt = 0;
//        int cntmatches;
//        boolean recheck;
//        int j, i;
//        char[] wPart;
//        windows.add(new int[]{0, s.length()-1});
//
//        for (String part: wordDict)
//        {
//            wPart = part.toCharArray();
//            i = 0;
//            recheck = false;
//            while (i < windows.size())
//            {
//                cntmatches = 0;
//                j = 0;
//                for (int k = windows.get(i)[0]; k <= windows.get(i)[1]; k++)
//                {
//                    if (s.charAt(k) == wPart[j])
//                    {
//                        cntmatches++;
//
//                        if (cntmatches == wPart.length) // full match
//                        {
//                            cnt++;
//                            if (cntmatches < (windows.get(i)[1] + 1 - windows.get(i)[0])) {
//
//                                if (k != windows.get(i)[1]) { // if not end part
//                                    windows.add(new int[]{k + 1, windows.get(i)[1]});
//                                }
//
//                                int new_offset = j - k; // k begins from zero
//
//                                if (windows.get(i)[0] != new_offset) {
//                                    windows.add(new int[]{ windows.get(i)[0], new_offset - 1});
//                                }
//                                windows.remove(i);
//                            } else {
//                                // equals
//                                windows.remove(i);
//                            }
//
//                            break;
//                        }
//                        j++;
//                    } else {
//                        j = 0;
//                        cntmatches = 0;
//                    }
//                }
//
//                if (cntmatches == wPart.length)
//                {
//                    if (recheck) return true;
//                    recheck = true;
//                } else {
//                    i++;
//                }
//            }
//        }
//        return cnt == wordDict.size();
//    }
//
//

}
