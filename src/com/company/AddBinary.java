package com.company;

import java.util.LinkedList;

public class AddBinary {
    public String addBinary(String a, String b) {
        LinkedList<Boolean> lst = new LinkedList<Boolean>();

        int maxIdx = a.length()-1;

        if (b.length() > a.length()) {
            maxIdx = b.length()-1;
        }
        int cur = 0;
        for (int i = 0; i <= maxIdx; i++) {
            if (a.length()-1 >= i) {
                if (a.charAt(a.length() - 1 - i) == '1') {
                    cur++;
                }
            }
            if (b.length()-1 >= i) {
                if ( b.charAt(b.length() - 1 - i) == '1') {
                    cur++;
                }
            }

            if (cur > 0) {
                if (cur == 1) {
                    lst.addFirst(true);
                    cur=0;
                } else if(cur == 3) {
                    lst.addFirst(true);
                    cur=1;
                }
                else {
                    lst.addFirst(false);
                    cur=1;
                }
            } else {
                lst.addFirst(false);
            }
        }

        if (cur > 0) {
            lst.addFirst(true);
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < lst.size(); i++) {
            sb.append(lst.get(i) ? 1 : 0);
        }
        return sb.toString();
    }
}
