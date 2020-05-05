package com.snakhawa.homework.binarytrees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SerializeBtree {

    private static final String NN = "NULL";
    private static final String SPLIT = "/";


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        buildString(root, sb);

        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(SPLIT)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Queue<String> nodes) {
        String value = nodes.remove();
        if (value.equals(NN)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(value));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(SPLIT);
        } else {
            sb.append(node.val).append(SPLIT);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }
}
