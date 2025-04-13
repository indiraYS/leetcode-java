package com.company.graph;

import java.util.Arrays;

/**
 * https://leetcode.com/explore/learn/card/graph/618/disjoint-set/3845/
 */
public class NumberOfProvinces {


    public int findCircleNum(int[][] isConnected) {
        int[] provinces = new int[isConnected.length];
        for (int i=1;i<isConnected.length; i++) {
            provinces[i]=i;
        }

        for (int i=0; i < isConnected.length-1; i++) {
            for (int j=i+1; j < isConnected.length;j++) {
                if (isConnected[i][j]==1) {
                    int a = provinces[j];

                    for (int k = 0; k < provinces.length; k++) {
                        if (provinces[k] == a) {
                           provinces[k] = provinces[i];
                        }
                    }
                }
            }
        }
        int cnt=1;
        Arrays.sort(provinces);
        System.out.println(Arrays.toString(provinces));

        for (int i=1;i<isConnected.length; i++) {
            if(provinces[i]!=provinces[i-1]) {
                cnt++;
            }
        }


        return cnt;
    }
}
