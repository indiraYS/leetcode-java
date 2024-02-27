package com.company;

import java.util.*;

public class DecodeWays {

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;

        int [] numbs = new int[s.length()];
        int [] dp = new int[s.length()];
        dp[s.length()-1] = 1;
        int nIdx = numbs.length-1;
        int x;
        try {
            for (int i = s.length()-1; i > -1; i--) {
                if (s.charAt(i) - '0' == 0) {
                    continue;
                } else {
                    x = s.charAt(i) - '0';
                    numbs[nIdx] = x;
                    if (i < s.length()-1)
                    {
                        if (s.charAt(i+1) - '0' == 0) {
                            if (i < s.length()-2 && s.charAt(i+2) - '0' == 0) {
                                throw new IllegalStateException("invalid seq");
                            }
                            if (x > 2) {
                                throw new IllegalStateException("invalid seq");
                            }
                            numbs[nIdx] = numbs[nIdx] * 10;
                        }
                    }
                }

                if (nIdx < s.length()-1) {
                    if (numbs[nIdx] == 20 || numbs[nIdx] == 10 ||
                            numbs[nIdx+1] == 20 || numbs[nIdx+1] == 10
                    ) {
                        dp[nIdx] = dp[nIdx+1];
                    } else {
                        if (numbs[nIdx]== 1 || numbs[nIdx] == 2 && numbs[nIdx+1] < 7) {
                            if (numbs.length - nIdx > 3) {
                                dp[nIdx] = dp[nIdx+1] + dp[nIdx+2];
                            } else {
                                dp[nIdx] = dp[nIdx+1] + 1;
                            }
                        } else {
                            dp[nIdx] = dp[nIdx+1];
                        }
                    }
                }
                nIdx--;
            }
        } catch (IllegalStateException e) {
            return 0;
        }
        nIdx = 0;

        while (nIdx < dp.length) {
            if (dp[nIdx] != 0) {
                return dp[nIdx];
            }
            nIdx++;
        }

        return 0;
    }
    public int numDecodings2(String s) {
        if (s.charAt(0) == '0') return 0;

        List<Integer> numbers;
        try {
            numbers = getNumbers(s);
        } catch (IllegalStateException e) {
            return 0;
        }
        int idx = numbers.size()-2;
        int[] dp = new int[numbers.size()];
        dp[numbers.size()-1] = 1;
        while (idx > -1) {
            if (numbers.get(idx) == 20 || numbers.get(idx) == 10 ||
                    numbers.get(idx+1) == 20 || numbers.get(idx+1) == 10
            ) {
                dp[idx] = dp[idx+1];
                idx--;
                continue;
            }

            if (numbers.get(idx) == 1 || numbers.get(idx) == 2 && numbers.get(idx+1) < 7) {
                if (numbers.size() - idx> 3) {
                    dp[idx] = dp[idx+1] + dp[idx+2];
                } else {
                    dp[idx] = dp[idx+1] + 1;
                }
            } else {
                dp[idx] = dp[idx+1];
            }
            idx --;
        }



        return dp[0];
    }

    private List<Integer> getNumbers(String s) {
        List<Integer> ints = new ArrayList<>();
        for (char ch : s.toCharArray())
        {
            if (ch - '0' == 0) {
                if (ints.get(ints.size()-1) == 10 || ints.get(ints.size()-1) == 20) {
                    throw new IllegalStateException("invalid seq");
                }
                if (ints.get(ints.size()-1) > 2) {
                    throw new IllegalStateException("invalid seq");
                }
                ints.set(ints.size()-1, ints.get(ints.size()-1) * 10);
            } else {
                ints.add(ch - '0');
            }
        }
        return ints;
    }
}
