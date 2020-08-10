package com.selfbalancingtrees;

public class Main {

    public static void main(String[] args) {

    }

    private static class Node {
        int val;
        int ht;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
            this.ht = 0;
        }
    }

    private static class AVLTree {
        Node root;

        public int height(Node node) {
            if (node == null)
                return 0;

            return node.ht;
        }

        public Node rightRotate(Node node) {
            Node x = node.left;
            Node t2 = x.right;

            x.right = node;
            node.left = t2;

            node.ht = Math.max(height(node.left), height(node.right)) + 1;
            x.ht = Math.max(height(x.left), height(x.right)) + 1;

            return x;
        }

        public Node leftRotate(Node node) {
            Node x = node.right;
            Node t2 = x.left;

            x.left = node;
            node.right = t2;

            node.ht = Math.max(height(node.left), height(node.right)) + 1;
            x.ht = Math.max(height(x.left), height(x.right)) + 1;

            return x;
        }

        int getBalance(Node node) {
            if (node == null)
                return -1;

            return height(node.left) - height(node.right);
        }

        Node insert(Node node, int key) {
            if (node == null)
                return (new Node(key));

            if (key < node.val)
                node.left = insert(node.left, key);
            else if (key > node.val)
                node.right = insert(node.right, key);
            else
                return node;

            node.ht = 1 + Math.max(height(node.left), height(node.right));

            int balance = getBalance(node);

            // If this node becomes unbalanced, then there
            // are 4 cases Left Left Case
            if (balance > 1 && key < node.left.val)
                return rightRotate(node);

            // Right Right Case
            if (balance < -1 && key > node.right.val)
                return leftRotate(node);

            // Left Right Case
            if (balance > 1 && key > node.left.val) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }

            // Right Left Case
            if (balance < -1 && key < node.right.val) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

            return node;
        }
    }
}
