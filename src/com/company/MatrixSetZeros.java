package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrixSetZeros {
    public void setZeroes(int[][] matrix) {
        Map<Integer,List<Integer>> pointX = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j< matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    int finalJ = j;

                    pointX.computeIfPresent(i , (key, val) -> {
                         val.add(finalJ); return val;
                    });

                    pointX.putIfAbsent(i , new ArrayList(){{
                        add(finalJ);
                    }});
                }
            }
        }

        for (Integer key:  pointX.keySet()) {
            zeroColumn(key, matrix);
            for (Integer row: pointX.get(key)) {
                zeroRow(row, matrix);
            }
        }
        pointX.clear();

    }

    private void zeroRow(int row, int[][] matrix) {
        for (int column = 1; column < matrix.length; column++) {
            matrix[column][row] = 0;
        }
    }

    private void zeroColumn(int column, int[][] matrix) {
        for (int row = 1; row < matrix[0].length; row++) {
            matrix[column][row] = 0;
        }
    }
}
