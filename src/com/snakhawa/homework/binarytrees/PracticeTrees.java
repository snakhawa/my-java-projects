package com.snakhawa.homework.binarytrees;

import java.util.Stack;

public class PracticeTrees {

    /**
     * Generates a sample tree
     * 4
     * /   \
     * 2     7
     * / \   / \
     * 1   3 6   9
     */
    public static TreeNode generateBalancedTree() {
        TreeNode t5 = new TreeNode(5, null, null);
        TreeNode t7 = new TreeNode(7, null, null);

        TreeNode t1 = new TreeNode(1, null, null);
        TreeNode t3 = new TreeNode(3, null, null);

        TreeNode t2 = new TreeNode(2, t1, t3);
        TreeNode t6 = new TreeNode(6, t5, t7);

        TreeNode root = new TreeNode(4, t2, t6);

        return root;
    }

    /**
     * Generates a sample tree
     * 4
     * /   \
     * 2     6
     */
    public static TreeNode generate2NodeTree() {

        TreeNode t2 = new TreeNode(2, null, null);
        TreeNode t6 = new TreeNode(6, null, null);

        TreeNode root = new TreeNode(4, t2, t6);

        return root;
    }

    public static int getDiameter(TreeNode root) {
        if (root == null) return 0;
        int ldepth = maxDepth(root.left);
        int rdepth = maxDepth(root.right);

        int ldiameter = getDiameter(root.left);
        int rdiameter = getDiameter(root.right);

        int finalDiameter = Math.max((ldepth + rdepth + 1), Math.max(ldiameter, rdiameter));

        return finalDiameter;
    }

    /*
    Given a binary tree, compute its 'maxDepth'
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int ldepth = maxDepth(root.left);
        int rdepth = maxDepth(root.right);

        return (Math.max(ldepth, rdepth) + 1);

    }

    public static void printPaths(TreeNode root) {
        printPaths(root, new Stack<TreeNode>());
    }

    public static void printPaths(TreeNode current, Stack<TreeNode> path) {
        if (current == null) return;
        path.add(current);
        if (current.left == null && current.right == null) {

            PrintStack(path);
            System.out.println("");
        }
        printPaths(current.left, path);
        printPaths(current.right, path);
        path.pop();

    }


    /*
    Given a non-empty binary search tree, return minimum data value found in the tree
     */
    public static int minValue(TreeNode root) {
        TreeNode curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr.val;
    }

    public static void printPreorder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        printInorder(root.left);
        printInorder(root.right);
    }

    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.println(root.val);
        printInorder(root.right);
    }

    public static void printPostOrder(TreeNode root) {
        if (root == null) return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.println(root.val);
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return sum == 0;
        int subSum = sum - root.val;
        return (hasPathSum(root.left, subSum) || hasPathSum(root.right, subSum));
    }

    public static int countSubPathSum(TreeNode root, int sum) {

        if (root == null) return 0;
        return (root.val == sum ? 1 : 0) + countSubPathSum(root.left, sum - root.val) + countSubPathSum(root.right, sum - root.val);

    }

    public static boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        else if (a != null && b != null) {
            return (a.val == b.val)
                    && isSameTree(a.left, b.left)
                    && isSameTree(a.right, b.right);
        } else return false;
    }

    public static void printChildNode(TreeNode root) {
        if (root == null) return;
        printChildNode(root.left);
        printChildNode(root.right);
        if (root.left == null && root.right == null) {
            System.out.println(root.val);
        }
    }

    // Print the stack from bottom to top
    static void PrintStack(Stack<TreeNode> s) {
        // If stack is empty then return
        if (s.isEmpty())
            return;

        int x = s.peek().val;

        // Pop the top element of the stack
        s.pop();

        // Recursively call the function PrintStack
        PrintStack(s);

        // Print the stack element starting
        // from the bottom
        System.out.print(x + " ");

        // Push the same element onto the stack
        // to preserve the order
        s.push(new TreeNode(x));

    }

}
