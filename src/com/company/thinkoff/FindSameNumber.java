package com.company.thinkoff;

public class FindSameNumber {
/*
Даны три неубывающих массива чисел. Найти число, которое присутствует во всех трех массивах.

Input: [1,2,4,5], [3,3,4], [2,3,4,5,6]
Output: 4

Input: [2,2,5], [1,1,2], [1,1,1,1,2]
Output: 2

Целевое решение работает за O(p + q + r), где p, q, r – длины массивов, доп. память O(1), но эту информацию интервьюер не сообщает.


{1, 2, 3, 5}, {1,3,4,5,6,9}, {2,2,4,4,5,8,7}
 */

    public int find(int[] a, int[] b, int[] c) {
        int i = 0, j = 0, k = 0;
        int curInt = 0;
        for ( ; curInt < a.length + b.length +c.length; curInt++) {
            if (a[i] < b[j] || a[i] < c[k]) {
                i++;
            } else if (a[i] > b[j]) {
                if (j <= b.length - 1) {
                    j++;
                }
            } else if (a[i] > c[k]) {
                if (k <= c.length - 1) {
                    k++;
                }
            } else {
                printResults(i,j,k);
                return a[i];
            }
        }
        printResults(i,j,k);
        return -1;
    }

    private void printResults (int i, int j, int k) {
        System.out.println("-----------");
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        System.out.println("-----------");
    }
}
