package com.deleteduplicatednodesinlinkedlist;

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

    public static void printSinglyLinkedList(SinglyLinkedListNode node) throws IOException {
        while (node != null) {
            System.out.println(node.data);

            node = node.next;

        }
    }

    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        int previousData = Integer.MIN_VALUE;
        SinglyLinkedListNode copy = head;
        int position = -1;

        while (copy != null) {
            if (previousData == copy.data){
                head = deleteNode(head, position);
                position--;
            }

            previousData = copy.data;
            copy = copy.next;
            position++;
        }

        return head;
    }

    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        SinglyLinkedListNode currentNode = head;
        SinglyLinkedListNode previousNode = currentNode;

        for (int i = 0; i < position; i++){
            currentNode = currentNode.next;
        }

        currentNode.data = currentNode.next.data;
        currentNode.next = currentNode.next.next;

        return previousNode;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            SinglyLinkedListNode llist1 = removeDuplicates(llist.head);

            printSinglyLinkedList(llist1);
        }

        scanner.close();
    }
}
