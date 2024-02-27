package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0;
        int minHeight = 0;
        int minHeightCalc = 0;
        int sq = 0;

        for (int i = 0; i < height.length; i++)
        {
            if (height[i] < minHeight ) continue;
            minHeight = height[i];

            for (int j = height.length-1; j >= i+1; j--)
            {
                if (height[i] < height[j]) {
                    minHeightCalc = height[i];
                } else {
                    minHeightCalc = height[j];
                }
                sq = minHeightCalc * (j - i); // calc square
                if ( sq > max) {
                    max = sq;
                }
            }
        }
        return max;
    }
    public int maxAreaLong(int[] height) {
        int max = 0;
        int minHeight = 0;
        int sq = 0;

        int iStat = 0;

         for (int i = 0; i< height.length-1; i++)
         {
             for (int j = height.length-1; j >= i+1; j--)
             {
                 if (height[i] > height[j]) {
                     minHeight = height[j];
                 } else {
                     minHeight = height[i];
                 }
                 sq = minHeight * (j - i); // calc square
                 if ( sq > max) {
                     max = sq;
                 }
             }
         }
        return max;
    }
}
