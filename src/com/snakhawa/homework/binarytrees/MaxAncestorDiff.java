package com.snakhawa.homework.binarytrees;

/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 */
public class MaxAncestorDiff {

    public static void main(String[] args) {
            maxAncestorDiff(PracticeTrees.generateBalancedTree());
    }

    public static int maxAncestorDiff(TreeNode root) {
        int result =  dfs(root, root.val, root.val);
        return result;
    }

    public static int dfs(TreeNode root, int mn, int mx) {
        if (root == null) return mx - mn;
        mx = Math.max(mx, root.val);
        mn = Math.min(mn, root.val);
        System.out.println(String.format("Root: %s (min=%s ,  max=%s)",root.val, mn, mx));
        return Math.max(dfs(root.left, mn, mx), dfs(root.right, mn, mx));
    }
}
