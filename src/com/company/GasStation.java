package com.company;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int left = 0;
        int startIdx = 0;
        int mvIdx = 0;
        int cnt =0;

        while (startIdx < gas.length)
        {
            left = gas[startIdx] - cost[startIdx];
            cnt = 1;
            mvIdx = startIdx + 1;
            if (mvIdx == gas.length) mvIdx = 0;

            if (left >= 0)
            {
                while (mvIdx != startIdx)
                {
                    left += gas[mvIdx] - cost[mvIdx];
                    cnt++;
                    if (left < 0) break;
                    mvIdx++;
                    if (mvIdx == gas.length) mvIdx = 0;
                }
                if (cnt == gas.length) break;
            }
            startIdx++;
        }

        if (left > -1 && cnt == gas.length) return startIdx;
        return -1;
    }
}
