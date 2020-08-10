package com.postordertraversetree;

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

    public static void postOrder(Node root) {
        Stack<Node> firstStack = new Stack<>();
        Stack<Node> secondStack = new Stack<>();

        firstStack.push(root);

        while (!firstStack.empty()) {
            Node popped = firstStack.pop();

            secondStack.push(popped);

            if (popped.left != null)
                firstStack.push(popped.left);
            if (popped.right != null)
                firstStack.push(popped.right);
        }

        while (!secondStack.empty()){
            System.out.print(String.format("%d ", secondStack.pop().data));
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
        postOrder(root);
    }
}