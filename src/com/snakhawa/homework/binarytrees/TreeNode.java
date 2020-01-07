package com.snakhawa.homework.binarytrees;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    this(x, null, null);
  }

  TreeNode(int x, TreeNode left, TreeNode right){
    this.val = x;
    this.left = left;
    this.right = right;
  }
}
