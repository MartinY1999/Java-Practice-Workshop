package com.topviewtree;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.security.KeyPair;
import java.security.PublicKey;
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

    public static void topView(Node root) {
        TreeMap<Integer, String> distancedElements = verticalLevelTraverse(root);

        for (Map.Entry<Integer, String> element : distancedElements.entrySet()){
            System.out.print(element.getValue() + " ");
        }
    }

    public static TreeMap<Integer, String> verticalLevelTraverse(Node root){
        int hd = 0;
        TreeMap<Integer, String> nodesDistance= new TreeMap<>();
        Queue<AbstractMap.SimpleEntry<Node, Integer>> queue = new ArrayDeque<>();

        nodesDistance.put(hd, String.valueOf(root.data));
        queue.add(new AbstractMap.SimpleEntry<>(root, hd));

        while (!queue.isEmpty()){
            var current = queue.remove();

            if (current.getKey().left != null) {
                if (!nodesDistance.containsKey(current.getValue() - 1))
                    nodesDistance.put(current.getValue() - 1, String.valueOf(current.getKey().left.data));

                queue.add(new AbstractMap.SimpleEntry<>(current.getKey().left, current.getValue() - 1));
            }

            if (current.getKey().right != null) {
                if (!nodesDistance.containsKey(current.getValue() + 1))
                    nodesDistance.put(current.getValue() + 1, String.valueOf(current.getKey().right.data));

                queue.add(new AbstractMap.SimpleEntry<>(current.getKey().right, current.getValue() + 1));
            }
        }

        return nodesDistance;
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
        topView(root);
    }
}