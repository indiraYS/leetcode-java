package com.company.medium;

public class JudgeSquareSum {
    public boolean solution(int c) {
        if (c==0) return false;


        int end = (int) Math.ceil( Math.sqrt(c)); // 2 /// 1 + 1
        int start = 0;

        while (start <= end) {
            long res = (long) start *start + (long) end *end;


            if (res > c) {
                end -= 1;
            } else {
                if (res==c) return true;
                start +=1;
            }
        }
        return false;
    }
}
