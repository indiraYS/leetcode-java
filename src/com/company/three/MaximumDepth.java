package com.company.three;

public class MaximumDepth {
    public int maxDepth(TreeNode root) {
        return get(root);
    }

    private int get(TreeNode node) {
        int res = 0;
        if (node != null) {
            int left = 0;
            if (node.left != null) {
                left = get(node.left);
            }

            int right = 0;
            if (node.right != null) {
                right = get(node.right);
            }

            if (right > left) {
                return right + 1;
            } else  {
                return left + 1;
            }
        }
        return res;
    }
}
