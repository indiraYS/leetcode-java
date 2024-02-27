package com.company.linked;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedCycledList {
    public boolean hasCycle(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        LinkedList<Integer> linkedList = new LinkedList<>();

        return cycled(head, 0, linkedList);
    }

    private boolean cycled(ListNode cur, List<Integer> vals) {
        if (cur != null) {

            if (!vals.contains(cur.val)) {
                vals.add(cur.val);
                return cycled(cur.next, vals);
            } else {
                return true;
            }
        }

        return false;
    }

    private boolean cycled(ListNode cur, int pos, LinkedList<Integer> vals) {
        if (cur != null) {

            if (!vals.contains(cur.val)) {
                vals.add(cur.val);
                return cycled(cur.next, pos + 1, vals);
            } else {
                int idx = vals.lastIndexOf(cur.val);
                ListNode nNode = cur;

                for (int i = idx; i <= pos; i++) {
                    if (nNode == null) {
                        break;
                    }
                    if (nNode.val != vals.get(i)) {
                        break;
                    }
                    nNode = nNode.next;
                }
                return true;
            }
        }

        return false;
    }

 /*   private boolean cycled(ListNode cur, int pos, List<Integer> vals) {
        if (cur != null) {

            if (!vals.contains(cur.val)) {
                vals.add(cur.val);
                return cycled(cur.next, pos + 1, vals);
            } else {
                int iterator = 0;
                int idx = vals.lastIndexOf(cur.val);

                ListNode next = cur;
                while (next != null) {
                    if (vals.get(idx) != next.val) {
                        break;
                    }
                    next
                }
            }
        }

        return false;
    }*/
}
