package com.snakhawa.homework.binarytrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PracticeTrees {


    public static void main(String[] args) {

        inOrderIterative(generateBalancedTree());
    }

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

    public static boolean findTarget(TreeNode node, int target) {
        if (node == null) return false;

        if (node.val == target) return true;

        if (target > node.val) {
            return findTarget(node.right, target);
        }
        if (target < node.val) {
            return findTarget(node.left, target);
        }
        return false;
    }

    public static TreeNode buildBST(int[] arr, int start, int end) {
        if (start > end || isOOB(arr, start) || isOOB(arr, end)) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = buildBST(arr, start, mid - 1);
        root.right = buildBST(arr, mid + 1, end);
        return root;

    }

    public static boolean isOOB(int[] arr, int index) {
        return index < 0 || index > arr.length - 1;
    }

    public static List<Integer> findRange(TreeNode root, TreeNode start, TreeNode end) {
        if (root == null || start == null || end == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        TreeNode successor = findSuccessor(root, start);
        while (successor != null && successor.val < end.val) {
            result.add(successor.val);
            successor = findSuccessor(root, successor);
        }
        return result;
    }

    public static TreeNode findSuccessor(TreeNode root, TreeNode node) {
        if (node.right != null) {
            TreeNode current = node.right;
            while (current.left != null) {
                current = current.left;
            }
            return current;
        } else {
            TreeNode successor = null;
            TreeNode current = root;
            while (current != null) {
                if (current.val > node.val) {
                    successor = current;
                    current = current.left;
                } else if (current.val < node.val) {
                    current = current.right;
                } else if (current.val == node.val) {
                    break;
                }
            }
            return successor;
        }
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

    public static List<Integer> inOrderIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;

    }

    public static List<Integer> preOrderIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        stack.push(curr);
        while (!stack.isEmpty()) {
            curr = stack.pop();
            list.add(curr.val);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        return list;

    }

    public static List<Integer> postOrderIterative(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            stack2.push(curr);
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
        while (!stack2.isEmpty()) {
            list.add(stack2.pop().val);
        }
        return list;

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
