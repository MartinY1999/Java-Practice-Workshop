package com.levelordertraversal;

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
    public static void levelOrder(Node root) {
        Queue<Integer> levelOrderTraversal = levelOrderTraverse(root);

        while (!levelOrderTraversal.isEmpty()){
            System.out.print(String.format("%d ", levelOrderTraversal.remove()));
        }
    }

    public static Queue<Integer> levelOrderTraverse(Node root){
        Node copyRoot = root;
        Queue<Integer> elements = new ArrayDeque<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(copyRoot);

        while (!queue.isEmpty()){
             Node current = queue.remove();

             elements.add(current.data);

             if (current.left != null)
                queue.add(current.left);
             if (current.right != null)
                 queue.add(current.right);
        }

        return elements;
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
        levelOrder(root);
    }
}