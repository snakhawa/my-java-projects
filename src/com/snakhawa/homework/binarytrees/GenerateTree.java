package com.snakhawa.homework.binarytrees;

import java.util.HashMap;

public class GenerateTree {

    public static void main(String[] args) {
        int[] inorder = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] postorder = new int[]{1, 3, 2, 5, 7, 6, 4};
        buildTree(inorder, postorder);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        HashMap<Integer, Integer> inorderMap = getInorderMap(inorder);
        return construct(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inorderMap);

    }

    public static TreeNode construct(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> inorderMap) {

        if (postStart > postEnd || inStart > inEnd) return null;

        //create root node
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);
        //Find the root value index in inorder
        int rootIndex = inorderMap.get(rootValue);

        //add the left and right subtrees to the root node
        root.left = construct(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + (rootIndex - inStart - 1), inorderMap);

        root.right = construct(inorder, rootIndex + 1, inEnd, postorder, postStart + (rootIndex - inStart), postEnd - 1, inorderMap);

        return root;
    }

    public static HashMap<Integer, Integer> getInorderMap(int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return map;
    }
}
