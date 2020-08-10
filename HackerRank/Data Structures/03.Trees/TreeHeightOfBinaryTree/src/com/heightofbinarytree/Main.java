package com.heightofbinarytree;

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

    public static int height(Node root) {
        if (root == null)
            return 0;

        Queue<Node> nodeQueue = new ArrayDeque<>();
        int height = -1;

        nodeQueue.add(root);

        while (true) {
            int nodeCount = nodeQueue.size();

            if (nodeCount == 0)
                return height;
            else
                height++;

            while (nodeCount > 0) {
                Node popped = nodeQueue.remove();

                if (popped.left != null)
                    nodeQueue.add(popped.left);
                if (popped.right != null)
                    nodeQueue.add(popped.right);

                nodeCount--;
            }
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
        int height = height(root);
        System.out.println(height);
    }
}