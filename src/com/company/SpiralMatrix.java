package com.company;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> arr = new ArrayList<>();
        int n = 0;
        int m = 0;
        int curHeightIdx = 0;
        int curLenghIdx = 0;
        boolean toRight = true;
        boolean toUp = false;

        while ( arr.size() < matrix.length * matrix[0].length ) {
            if (toRight && !toUp) {
                arr.add(matrix[curHeightIdx][curLenghIdx]);

                if (curLenghIdx == matrix[0].length -1 -n) {
                    toRight = false;
                    curHeightIdx++;
                } else {
                    curLenghIdx++;
                }

            } else  if (!toUp && !toRight) {
                arr.add(matrix[curHeightIdx][curLenghIdx]);
                if (curHeightIdx == matrix.length - 1 -m) {
                    toUp = true;
                    curLenghIdx--;
                } else {
                    curHeightIdx++;
                }
            } else if (!toRight) {
                arr.add(matrix[curHeightIdx][curLenghIdx]);

                if (curLenghIdx == n) {
                    toRight = true;
                    m++;
                    curHeightIdx--;
                } else {
                    curLenghIdx--;
                }
            }
            else if (toUp) {
                arr.add(matrix[curHeightIdx][curLenghIdx]);
                if (curHeightIdx == m) {
                    n++;
                    toUp = false;
                    curLenghIdx++;
                } else {
                    curHeightIdx--;
                }
            }
        }

        return arr;
    }
}
