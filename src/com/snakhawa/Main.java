package com.snakhawa;

import com.snakhawa.homework.binarytrees.TreeNode;

import java.util.Arrays;


public class Main {

    static int result = 0;

    public static void main(String[] args) {

        coinChange(new int[]{1, 2, 5}, 11);

    }


    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


    public static int findTilt(TreeNode root) {
        postOrder(root);
        return result;
    }

    private static int postOrder(TreeNode root) {
        if (root == null) return 0;

        int left = postOrder(root.left);
        int right = postOrder(root.right);

        result += Math.abs(left - right);

        return left + right + root.val;
    }


}
