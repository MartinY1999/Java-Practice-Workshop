package com.reverselinkedlist;

import java.io.*;
import java.util.*;

class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    static void reverseVoid(SinglyLinkedListNode head) {
        Stack<SinglyLinkedListNode> reversedNodes = new Stack<>();

        SinglyLinkedListNode firstNode = new SinglyLinkedListNode(head.data);
        reversedNodes.add(firstNode);
        head = head.next;

        SinglyLinkedListNode previous = firstNode;

        while (head != null){
            SinglyLinkedListNode currentNode = new SinglyLinkedListNode(head.data);
            currentNode.next = previous;

            reversedNodes.add(currentNode);

            previous = currentNode;
            head = head.next;
        }

        while (reversedNodes.size() != 0){
            System.out.printf("%d ", reversedNodes.pop().data);
        }
    }

    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        if (head == null || head.next == null)
            return head;

        SinglyLinkedListNode remainder = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return remainder;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            reverse(llist.head);
        }

        scanner.close();
    }
}

