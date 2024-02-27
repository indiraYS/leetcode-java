package com.company.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Flatten {
    Stack<TreeNode> stack = new Stack<>();
    List<TreeNode> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        if (root == null) return;
        flattenInternal(root);
        TreeNode prev = root; root.left = null;
        for (int i = 1; i < list.size(); i++) {
            prev.right = list.get(i);
            prev.right.left = null;
            prev = list.get(i);
        }
    }

    public void flattenInternal(TreeNode root) {
        list.add(root);
        if (root.right != null) stack.add(root.right);
        if (root.left != null) stack.add(root.left);
        if (!stack.isEmpty()) {
            flattenInternal(stack.pop());
        }
    }

//todo look at this

    public void flattenNotMySolution(TreeNode root)
    {
        TreeNode current = root;
        while(current != null)
        {
            if(current.left != null)
            {
                TreeNode temp = current.left;
                while(temp.right != null)
                { temp = temp.right;    }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
}
