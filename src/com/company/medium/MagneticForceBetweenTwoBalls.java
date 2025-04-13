package com.company.medium;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length - 1;
        int min = (position[n] - position[0]) / (m-1);
        int start = 1;

        while (start <= min) {
            int mid = (min - start)/2;
            if (canPlace(position, mid, m)) {
                start = mid+1;
            } else {
                min = start-1;
            }
        }

        return min;
    }

    private boolean canPlace(int[] position, int distance, int m) {
        int lastPos = position[0];
        int cnt = 1;

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= distance) {
                lastPos = position[i];
                cnt++;
                if (cnt == m) {
                    return true;
                }
            }
        }
        return false;
    }
}
