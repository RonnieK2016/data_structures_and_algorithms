package com.udemy.algorithms.datastructures;

public class SortedLinkedList<V extends Comparable<V>> {

    private Node head;
    private int size;

    private void addToFront(V value) {
        Node node = new Node(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public Node removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        Node removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public void insertSorted(V value) {
        Node c = head;
        Node previous = null;
        while(c != null && c.value.compareTo(value) < 0) {
            previous = c;
            c = c.next;
        }

        if(previous == null) {
            addToFront(value);
        }
        else {
            Node newNode = new Node(value);
            previous.next = newNode;
            newNode.next = c;
            size++;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        Node current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public class Node {

        private V value;
        private Node next;

        private Node(V value) {
            this.value = value;
        }

        private V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        private Node getNext() {
            return next;
        }

        private void setNext(Node next) {
            this.next = next;
        }

        public String toString() {
            return value.toString();
        }

    }


}

