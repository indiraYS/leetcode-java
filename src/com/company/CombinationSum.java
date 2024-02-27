package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency
 *  of at least one of the chosen numbers is different.
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 */
public class CombinationSum {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                calc(0, i, target, new ArrayList<>(), candidates);
            }
        }
        return result;
    }

    private void calc(int sum, int next, int target, List<Integer> ints, int[] candidates) {
        if (sum + candidates[next] > target)  {
            return;
        }
        sum += candidates[next];
        ints.add(candidates[next]);

        if (sum == target) {
            result.add(ints);
        }
        else
        {
            for (int i = next; i < candidates.length; i++) {
                if (sum + candidates[i] <= target) {
                    List<Integer> clone = new ArrayList<>(ints);
                    calc(sum, i, target, clone, candidates);
                }
            }
            ints.clear();
        }
    }
    /**
     * System.out.println(new CombinationSum().combinationSum(new int[] {2,3,6,7}, 7));
     *         System.out.println(new CombinationSum().combinationSum(new int[] {2,3,5}, 8));
     *         System.out.println(new CombinationSum().combinationSum(new int[] {3,5,8}, 11));
     */
}
