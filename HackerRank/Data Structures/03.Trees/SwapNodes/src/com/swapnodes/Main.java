package com.swapnodes;

import java.io.*;
import java.util.*;

class Solution {
    static void swapNodes(int[][] indexes, int[] queries) {
        TreeNode tree = new TreeNode();
        Queue<TreeNode> nodes = new LinkedList<>();
        int N = 0;

        nodes.offer(tree);

        while (!nodes.isEmpty() && N < indexes.length) {
            TreeNode current = nodes.remove();

            if (indexes[N][0] != -1) {
                TreeNode left = new TreeNode(indexes[N][0]);
                current.leftChild = left;
                nodes.offer(left);
            }
            else
                current.leftChild = null;

            if (indexes[N][1] != -1) {
                TreeNode right = new TreeNode(indexes[N][1]);
                current.rightChild = right;
                nodes.offer(right);
            }
            else
                current.rightChild = null;

            N++;
        }

        for (int i = 0; i < queries.length; i++) {
            swap(tree, queries[i], 0, 1);
            inorder(tree);
            System.out.println();
        }
    }

    private static void swap(TreeNode node, int k, int current, int mul) {
        if (node == null)
            return;

        current++;
        if (current == mul * k) {
            TreeNode temp = node.leftChild;
            node.leftChild = node.rightChild;
            node.rightChild = temp;

            mul++;

            swap(node.leftChild, k, current, mul);
            swap(node.rightChild, k, current, mul);
        }
        else {
            swap(node.leftChild, k, current, mul);
            swap(node.rightChild, k, current, mul);
        }
    }

    private static void inorder(TreeNode tree)
    {
        if (tree == null)
            return;

        inorder(tree.leftChild);
        System.out.print(tree.data+" ");
        inorder(tree.rightChild);
    }

    private static class TreeNode
    {
        private int data;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode() {
            this.data = 1;
            leftChild = null;
            rightChild = null;
        }

        public TreeNode(int data) {
            super();
            this.data = data;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(scanner.nextLine().trim());
        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        swapNodes(indexes, queries);
    }
}

