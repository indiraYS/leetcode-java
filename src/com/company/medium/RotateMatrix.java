package com.company.medium;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int n = matrix.length-1;
        int [][] copy = new int[matrix.length][matrix.length];
        for (int i = 0; i <= n;i++) {
            System.arraycopy(matrix[i], 0, copy[i], 0, n + 1);
        }

        for (int i = 0; i<=n; i++) {
            for (int j=0 ;j<=n; j++) {
                matrix[i][j]= copy[n-j][i];
            }
        }
    }
}
