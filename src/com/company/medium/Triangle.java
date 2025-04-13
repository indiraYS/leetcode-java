package com.company.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/triangle/
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle)
    {
        int min = Integer.MAX_VALUE;
        Stack<List<Integer>> maps = new Stack<>();
        List<Integer> current;
        List<Integer> newList;

        current = new ArrayList<Integer>();
        current.add(triangle.get(0).get(0)); // sum
        current.add(0); // current index
        current.add(0); // level
        maps.push(current);

        while (!maps.isEmpty())
        {
            current = maps.pop();

            if (current.get(2) == triangle.size() - 1) // 0 = 1 - 1 ?
            {
                if (current.get(0) + triangle.get(current.get(2)).get(current.get(1)) < min) {
                    min = current.get(0) + triangle.get(current.get(2)).get(current.get(1));
                }

                if (current.get(1) + 1 < triangle.get(current.get(2)).size()
                        && (current.get(0) + triangle.get(current.get(2)).get(current.get(1)+1) < min)) {
                    min = current.get(0) + triangle.get(current.get(2)).get(current.get(1)+1);
                }
            }
            else
            {
                newList = new ArrayList<Integer>(current);
                List<Integer> nextLevel = triangle.get(current.get(2)+1); // 0 + 1

                System.out.println("level: " +
                        (current.get(2) + 1) + ", prev_sum: " +
                        current.get(0) + ", current_idx: " + current.get(1) + ", current_sum: " +
                        triangle.get(current.get(2) + 1).get(current.get(1))
                );

                newList.set(0, current.get(0) + nextLevel.get(current.get(1)+1)); // prev amount + next level amount
                newList.set(1, newList.get(1) + 1);
                newList.set(2, current.get(2) + 1);
                maps.push(newList);

                current.set(0, current.get(0) + nextLevel.get(current.get(1)));
                current.set(2, current.get(2) + 1);
                maps.push(current);
            }
        }

        return min;
    }

    public int minimumTotal1111(List<List<Integer>> triangle)
    {
        int min = Integer.MAX_VALUE;
        Stack<List<Integer>> maps = new Stack<>();
        List<Integer> current;
        List<Integer> newList;

        current = new ArrayList<Integer>();
        current.add(triangle.get(0).get(0)); // sum
        current.add(0); // current index
        current.add(0); // level
        maps.push(current);

        while (!maps.isEmpty())
        {
            current = maps.pop();

            if (current.get(2) == triangle.size() - 1) // 0 = 1 - 1 ?
            {
                if (current.get(0) + triangle.get(current.get(2)).get(current.get(1)) < min) {
                    min = current.get(0) + triangle.get(current.get(2)).get(current.get(1));
                }

                if (current.get(1) + 1 < triangle.get(current.get(2)).size()
                        && (current.get(0) + triangle.get(current.get(2)).get(current.get(1)+1) < min)) {
                    min = current.get(0) + triangle.get(current.get(2)).get(current.get(1)+1);
                }
            }
            else
            {
                newList = new ArrayList<Integer>(current);
                List<Integer> nextLevel = triangle.get(current.get(2)+1); // 0 + 1

                System.out.println("level: " +
                        (current.get(2) + 1) + ", prev_sum: " +
                        current.get(0) + ", current_idx: " + current.get(1) + ", current_sum: " +
                        triangle.get(current.get(2) + 1).get(current.get(1))
                );

                newList.set(0, current.get(0) + nextLevel.get(current.get(1)+1)); // prev amount + next level amount
                newList.set(1, newList.get(1) + 1);
                newList.set(2, current.get(2) + 1);
                maps.push(newList);

                current.set(0, current.get(0) + nextLevel.get(current.get(1)));
                current.set(2, current.get(2) + 1);
                maps.push(current);
            }
        }

        return min;
    }
}
