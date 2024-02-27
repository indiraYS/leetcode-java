package com.company.linked;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode first = null;

        if (list1 != null && (list2 == null || list1.val <= list2.val)) {
            first = new ListNode(list1.val);
            list1 = list1.next;
        } else if (list2 != null) {
            first = new ListNode(list2.val);
            list2 = list2.next;
        }

        ListNode next = first;
        if (next != null) {
            do {
                if (list1 != null && (list2 == null || list1.val <= list2.val)) {
                    next.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else if (list2 != null) {
                    next.next = new ListNode(list2.val);
                    list2 = list2.next;
                } else {
                    break;
                }
                next = next.next;
            } while (true);
        }

        return first;
    }

    public ListNode mergeTwoLists__(ListNode list1, ListNode list2) {
        List<Integer> numbs = new ArrayList<>();
        ListNode next = list1;
        do {
            if (next != null) {
                numbs.add(next.val);
                next = next.next;
            }
        } while (next != null);

        next = list2;
        do {
            if (next != null) {
                numbs.add (next.val);
                next = next.next;
            }
        } while (next != null);

        if (numbs.size()>0) {
            Collections.sort(numbs);
            next = new ListNode(numbs.get(0));
            for (int i = 1; i < numbs.size(); i++) {
                next.next = new ListNode(numbs.get(i));
                next = next.next;
            }
            return next;
        }
        return null;
    }
}
