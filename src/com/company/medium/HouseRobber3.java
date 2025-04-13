package com.company.medium;

import com.company.three.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class HouseRobber3 {
    int max = 0;
    List<Integer> cost = new ArrayList<>();
    public int rob(TreeNode root) {


        // return  helper(root, false);
       // cost.add(root.val);
        int[] res = help(root);

        return Math.max(res[0], res[1]);
    }
 // n-2 , n-1
    private int[] help(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0, 0};
        }

        int[] left = help(root.left);
        int[] right = help(root.right);
        int cur = Math.max(root.val + Math.max(left[1], left[2]) + Math.max(right[1], right[2]),
                left[0] + right[0]
        );

        left[2] = left[1] + right[1];
        left[1] = left[0] + right[0]; // shift array
        left[0] = cur;
        return left;
    }

    // others
    public int[] helper(TreeNode node){
        if(node == null){
            return new int[]{0, 0};
        }


        int[] left = helper(node.left);
        int[] right = helper(node.right);

        int rob = node.val + left[1] + right[1];
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{rob, notRob};
    }
}
