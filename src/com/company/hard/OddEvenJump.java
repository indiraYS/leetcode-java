package com.company.hard;

import java.util.*;

public class OddEvenJump {
    /**
     * @param arr
     * @return
     * @link https://leetcode.com/problems/odd-even-jump/
     */
    public int oddEvenJumps(int[] arr) {
        TreeSet<Integer> st = new TreeSet<>(Comparator.comparingInt(x -> arr[x]));
        st.add(arr.length - 1);
        int[] greaterThan = new int[arr.length];
        int[] lowerThan = new int[arr.length];

        int cnt = 0;
        Stack<Integer> jump = new Stack<>();
        boolean isOdd;
        for (int i = arr.length - 1; i > -1; i--) {
            Integer ceiling = st.ceiling(i);
            if (ceiling != null) {
                greaterThan[i] = ceiling;

                if (lowerThan[greaterThan[i]] == -2) {
                    greaterThan[i] = -2;
                    cnt++;
                } else {
                    isOdd = true;
                    jump.add(i);
                    while (!jump.isEmpty()) {
                        int next = jump.peek();
                        if (next == arr.length - 1) next = -2;
                        if (next == -1 || next == -2) {
                            jump.pop();
                            while (!jump.isEmpty()) {
                                if (isOdd) {
                                    lowerThan[jump.pop()] = next;
                                } else {
                                    greaterThan[jump.pop()] = next;
                                }
                                isOdd = !isOdd;
                            }
                            if (next == -2) {
                                cnt += 1;
                            }
                        } else {
                            if (isOdd) {
                                jump.add(greaterThan[next]);
                            } else {
                                jump.add(lowerThan[next]);
                            }
                        }
                        isOdd = !isOdd;
                    }
                }

            } else {
                greaterThan[i] = -1;
            }

            if (ceiling != null && arr[ceiling] == arr[i]) {
                lowerThan[i] = ceiling;
                st.remove(ceiling);
            } else {
                Integer floor = st.lower(i);
                if (floor != null) {
                    lowerThan[i] = floor;
                } else {
                    lowerThan[i] = -1;
                }
            }
            st.add(i);
        }
        return cnt;
    }
}
