package com.inordertraversetree;

import java.util.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    public static void inOrder(Node root) {
        Stack<Node> nodeStack = new Stack<>();
        Node current = root;

        while (current != null || nodeStack.size() > 0) {
            while (current != null) {

                nodeStack.push(current);
                current = current.left;
            }

            current = nodeStack.pop();

            System.out.print(current.data + " ");

            current = current.right;
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        inOrder(root);
    }
}
