package com.company.hard;

import java.util.*;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        int empty=0;


        ListNode listNode = null;
        int minIdx;
        int minValue;
        while (empty != lists.length) {
            minIdx = -1;
            minValue = Integer.MAX_VALUE;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < minValue) {
                    minIdx = i;
                    minValue = lists[i].val;
                }
            }

            if (minIdx == -1) // if min not found
            {
                empty++;
                break;
            }

            if (listNode == null) {
                listNode = new ListNode(minValue);
            } else {
                ListNode newListNode = new ListNode(minValue);
                listNode.next = newListNode;
                listNode = newListNode;
            }

            if (lists[minIdx].next == null) {
                lists[minIdx] = null;
                empty++;
            } else {
                lists[minIdx] = lists[minIdx].next;
            }
        }
        return listNode;
    }
}