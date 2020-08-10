package com.isabinarytree;

import java.util.Stack;

class Main {

    public static void main(String[] args) {

    }

    private static boolean checkBST(Node node) {
        return checkBST(node, node.data, node.data);
    }

    private static boolean checkBST(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.data <= min || root.data >= max)
            return false;

        return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
