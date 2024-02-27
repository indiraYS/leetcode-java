package com.company;

public class MinPathSum {
    int minSum = Integer.MAX_VALUE;

    public int minPathSum(int[][] grid) {
        // System.out.println("max y: " + (grid.length-1));
        // System.out.println("max x: " + (grid[0].length-1));
        int min = Integer.MAX_VALUE;
        for (int y = grid.length-1;y > -1; y--) // hight
        {
            for (int x = grid[0].length-1; x > -1; x--) // depth
            {
                if (y == grid.length-1 && x == grid[0].length-1) {
                    continue;
                }

                min = Integer.MAX_VALUE;

                // check bottom
                // System.out.println("x: " +x + ", y: " + y +", val: " + grid[y][x]);

                if (y < grid.length-1) {
                    //System.out.println("bottom: " + grid[y+1][y]);
                    if (grid[y+1][x] < min) {
                        min = grid[y+1][x];
                    }
                }

                // check right
                if (x < grid[0].length-1) {
                    // System.out.println("right: " + grid[y][x+1]);
                    if (grid[y][x+1] < min) {
                        min = grid[y][x+1];
                    }
                }

                grid[y][x] += min;
                // System.out.println("---");
            }
        }
        return grid[0][0];
    }

    private void count(int[][] grid, int m, int n, int sum) {
        sum += grid[m][n];
        if (m < grid.length-1) {
            if (sum < minSum)  {
                count(grid, m+1, n, sum);
            }
        }

        if (n < grid[0].length-1) {
            if (sum < minSum)  {
                count(grid, m, n+1, sum);
            }
        }

        if (m == grid.length-1 && n == grid[0].length-1) {
            if (sum < minSum) minSum = sum;
            return;
        }
    }
}
