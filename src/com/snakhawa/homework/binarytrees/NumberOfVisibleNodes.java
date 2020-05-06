package com.snakhawa.homework.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfVisibleNodes {


    public static void main(String[] args) {

        visibleNodes(PracticeTrees.generateBalancedTree());
    }

    /**
     * Number of Visible Nodes
     * There is a binary tree with N nodes.
     * You are viewing the tree from its left side and can see only the leftmost nodes at each level.
     * Return the number of visible nodes.
     *
     * Note: You can see only the leftmost nodes, but that doesn't mean they have to be left nodes.
     * The leftmost node at a level could be a right node
     */
    public static int visibleNodes(TreeNode root) {
        // Write your code here
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int result = 0;
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.remove();
                if (i == 0) {
                    result += result;
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

        return result;
    }
}
