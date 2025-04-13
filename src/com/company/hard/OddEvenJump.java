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
        for (int i = arr.length - 1; i > -1; i--) {
            Integer ceiling = st.ceiling(i);
            Integer higher = st.higher(i);
            if (ceiling != null) {
                if (higher != null && higher < ceiling) {
                    greaterThan[i] = higher;
                } else {
                    greaterThan[i] = ceiling;
                }
            } else {
                greaterThan[i] = -1;
            }
            Integer floor = st.lower(i);
            if (floor != null) {
                lowerThan[i] = floor;
            } else {
                if (ceiling != null && arr[ceiling] == arr[i]) {
                    lowerThan[i] = ceiling;
                } else {
                    lowerThan[i] = -1;
                }
            }
            st.remove(i);
            st.add(i);
        }
        System.out.println(Arrays.toString(greaterThan));
        System.out.println(Arrays.toString(lowerThan));
        //int[] greaterJumps = new int[arr.length];
        // -1 cant finish, -2 yes you can

        int cnt = 0;
        Stack<Integer> jump = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (greaterThan[i] == -1) {
                continue;
            }
            if (greaterThan[i] == -2) {
                cnt += 1;
                continue;
            }

            boolean isOdd = true;
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
                    break;
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
        return cnt;
    }
}
