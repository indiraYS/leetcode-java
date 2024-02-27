package com.company;

import java.util.*;

public class InterleavingString {
    // todo
    // O(s3.length)
    public boolean isInterleave(String s1, String s2, String s3) {
        // x index of s3
        // y index of s1
        // z index of s2
        int x = 0, y = 0, z = 0;
        boolean isFirst = true;

        Stack<Variant> possible = new Stack<>();
        List<Variant> checked = new ArrayList<>();

        if (s3.length() > 0) {
            while (x < s3.length()) {

                if (isFirst) {
                    if (y < s1.length() && s3.charAt(x) == s1.charAt(y)) {
                        if (z < s2.length() && s3.charAt(x) == s2.charAt(z)) {
                            Variant variant = new Variant(0, x, y, z);
                            if (!checked.contains(variant)) {
                                possible.add(variant);
                            }
                        }
                        x++;
                        y++;
                    } else {
                        if (z < s2.length() && s3.charAt(x) == s2.charAt(z)) {
                            x++;
                            z++;
                            isFirst = false;
                        } else {
                            if (!possible.isEmpty()) {
                                Variant variant = possible.pop();
                                isFirst = variant.isFirst == 1;
                                x = variant.x;  y = variant.y; z = variant.z;
                                checked.add(variant);
                            } else {
                                break;
                            }
                        }
                    }
                } else {
                    if (z < s2.length() && s3.charAt(x) == s2.charAt(z)) {
                        if (y < s1.length() && s3.charAt(x) == s1.charAt(y)) {
                            Variant variant = new Variant(1, x, y, z);
                            if (!checked.contains(variant)) {
                                possible.add(variant);
                            }
                        }
                        x++;
                        z++;
                    } else {
                        if (y < s1.length() && s3.charAt(x) == s1.charAt(y)) {
                            x++;
                            y++;
                            isFirst = true;
                        } else {
                            if (!possible.isEmpty()) {
                                Variant variant = possible.pop();
                                isFirst = variant.isFirst == 1;
                                x = variant.x;  y = variant.y; z = variant.z;
                                checked.add(variant);
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return x == s3.length() && y == s1.length() && z == s2.length();
    }

    class Variant {
        private Integer isFirst;
        private Integer x;
        private Integer y;
        private Integer z;

        public Variant(Integer isFirst, Integer x, Integer y, Integer z) {
            this.isFirst = isFirst;
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Variant variant = (Variant) o;
            return Objects.equals(isFirst, variant.isFirst) && Objects.equals(x, variant.x) && Objects.equals(y, variant.y) && Objects.equals(z, variant.z);
        }

        @Override
        public int hashCode() {
            return Objects.hash(isFirst, x, y, z);
        }
    }

    public boolean isInterleaveMySimpleBeautiful(String s1, String s2, String s3) {
        // x index of s3
        // y index of s1
        // z index of s2
        int x = 0, y = 0, z = 0;
        char[] arr_s3 = s3.toCharArray();
        Arrays.sort(arr_s3);

        char[] arr_s1 = s1.toCharArray();
        Arrays.sort(arr_s1);

        char[] arr_s2 = s2.toCharArray();
        Arrays.sort(arr_s2);

        while (x < s3.length()) {
            if (y < arr_s1.length && arr_s3[x] == arr_s1[y]) {
                x++;
                y++;
            } else if (z < arr_s2.length && arr_s3[x] == arr_s2[z]) {
                x++;
                z++;
            } else {
                break;
            }
        }
        return x == s3.length();
    }
}
