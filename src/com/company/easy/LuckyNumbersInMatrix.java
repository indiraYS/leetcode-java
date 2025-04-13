package com.company.easy;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInMatrix {
    public List<Integer> luckyNumbers(int[][] matrix)
    {
        List<Integer> min = new ArrayList<>();
        List<Integer> max = new ArrayList<>();
        int cmax = 0;
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                if (j==0) {
                    cmax = matrix[i][j];
                } else {
                    if (matrix[i][j] > cmax) {
                        cmax = matrix[i][j];
                    }
                }

            }
            max.add(cmax);
        }

        return intersection(min, max);
    }

    private List<Integer> mins(int[][] matrix)
    {
        List<Integer> min = new ArrayList<>();
        int minval = 0;
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                if (j == 0) {
                    minval = matrix[i][j];
                } else {
                    if (matrix[i][j] < minval) {
                        minval = matrix[i][j];
                    }
                }

            }
        }
        return min;
    }

    public List<Integer> intersection(List<Integer> list1, List<Integer> list2) {
        List<Integer> list = new ArrayList<Integer>();
        for (Integer t : list1) {
            if (list2.contains(t)) {
                list.add(t);
            }
        }
        return list;
    }
}
