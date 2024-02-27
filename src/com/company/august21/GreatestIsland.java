package com.company.august21;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GreatestIsland {

    private int large(int xGridLength, int cntZero, List<Pair<Integer, Integer>> zeroPos) {
        // todo calc diff between points
        Map<Integer, List<Pair<Integer, Integer>>> groupsH = zeroPos.stream().collect(Collectors.groupingBy(x -> x.fst, Collectors.toList()));
        Map<Integer, List<Pair<Integer, Integer>>> groupsL = zeroPos.stream().collect(Collectors.groupingBy(x -> x.snd, Collectors.toList()));

        if ( groupsH.size() > groupsL.size()) {

        } else if (groupsH.size() < groupsL.size()) {

        } else {
            // fixme mb its diagonally
        }

        // todo незнаю что дальше делать
        return -1;
    }

    /**
     * Input: grid = [[1,0],[0,1]]
     * Output: 3
     * Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
     * Example 2:
     *
     * Input: grid = [[1,1],[1,0]]
     * Output: 4
     * Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
     * Example 3:
     *
     * Input: grid = [[1,1],[1,1]]
     * Output: 4
     * Explanation: Can't change any 0 to 1, only one island with area = 4.
     * @param grid
     * @return
     */
    public int largestIsland(int[][] grid) {
        if (grid[0].length > 500 || grid[0].length < 1 ) return 0;
        if (grid.length != grid[0].length ) return 0;
        int i = 0, j;
        int cntZero = 0;
        int xGridLength = grid[0].length;

        List<Pair<Integer, Integer>> zeroPos = new ArrayList<>();

        while (i < grid.length) {
            j = 0;
            while (j < grid.length) {
                if (grid[i][j] == 0) {
                    cntZero++;
                    zeroPos.add(new Pair(i, j));
                }
                j++;
            }
            i++;
        }

        if (cntZero <= 1) return grid.length * grid.length;
        if (grid[0].length == 2) return grid.length * grid.length - cntZero + 1;

        return large(xGridLength, cntZero, zeroPos);
    }
}
