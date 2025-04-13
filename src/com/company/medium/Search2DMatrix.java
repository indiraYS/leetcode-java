package com.company.medium;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i =0; int j=0;
        while (i < matrix.length && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            }

            if (j + 1 < matrix[0].length) {
                if (i + 1 < matrix.length) {
                    int buttom = target - matrix[i+1][j];
                    if (buttom >= 0 && buttom < target - matrix[i][j+1]) {
                        i+= 1;
                    } else {
                        j+=1;
                    }
                } else {
                    j+=1;
                }
            } else {
                i+=1;
            }
        }
        return false;
    }
}
