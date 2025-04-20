package com.company.three;

import java.util.List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BinaryTreeVerticalTraversal {
    /* https://leetcode.com/problems/binary-tree-vertical-order-traversal/ */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        List<List<Integer>> lst = new ArrayList<>();
        if (root != null) {
            LinkedList<Pair> q = new LinkedList<>();
            q.add(new Pair(root, 0));
            List<Integer> collector;
            Pair next;

            int min = 0;
            int max = 0;

            while (!q.isEmpty()) {
                next = q.poll();
                //final Integer key = next.node.val;
                collector = mp.getOrDefault(next.lvl, new ArrayList<>());
                collector.add(next.node.val);
                mp.put(next.lvl, collector);

                if (next.node.left != null) q.add(new Pair(next.node.left, next.lvl -1));
                if (next.node.right != null) q.add(new Pair(next.node.right, next.lvl +1));

                min = Math.min(min, next.lvl);
                max = Math.max(max, next.lvl);
            }

            while (min <= max) {
                lst.add(mp.get(min));
                min++;
            }
        }

        return lst;
    }

    class Pair {
        int lvl;
        TreeNode node;
        Pair(TreeNode node, int lvl) {
            this.node = node;
            this.lvl = lvl;
        }
    }
}
