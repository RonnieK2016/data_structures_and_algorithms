package com.udemy.algorithms.datastructures;

public class DoublyLinkedList<V> {

    private Node head;
    private Node tail;
    private int size;

    public void addToFront(V value) {
        Node node = new Node(value);

        if (head == null) {
            tail = node;
        }
        else {
            head.setPrevious(node);
            node.setNext(head);
        }

        head = node;
        size++;
    }

    public void addToEnd(V value) {
        Node node = new Node(value);
        if (tail == null) {
            head = node;
        }
        else {
            tail.setNext(node);
            node.setPrevious(tail);
        }

        tail = node;
        size++;
    }

    private Node getNodeFor(V existingValue) {
        Node c = head;
        while(c != null) {
            if(c.value.equals(existingValue)){
                return c;
            }
            c = c.next;
        }

        return null;
    }

    public boolean addBefore(V value, V existingValue) {
        Node searchNode = getNodeFor(existingValue);
        if(searchNode == null) {
            return false;
        }

        Node newNode = new Node(value);
        Node previous = searchNode.previous;

        newNode.next = searchNode;
        searchNode.previous = newNode;
        newNode.previous = previous;
        if(previous != null) {
            previous.next = newNode;
        }
        //head node case
        else {
            head = newNode;
        }

        return true;
    }

    public Node removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        Node removedNode = head;

        if (head.getNext() == null) {
            tail = null;
        }
        else {
            head.getNext().setPrevious(null);
        }

        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public Node removeFromEnd() {
        if (isEmpty()) {
            return null;
        }

        Node removedNode = tail;

        if (tail.getPrevious() == null) {
            head = null;
        }
        else {
            tail.getPrevious().setNext(null);
        }

        tail = tail.getPrevious();
        size--;
        removedNode.setPrevious(null);
        return removedNode;
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
            System.out.print(" <=> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    class Node {
        private V value;
        private Node next;
        private Node previous;

        private Node(V value) {
            this.value = value;
        }

        public V getValue() {
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

        private Node getPrevious() {
            return previous;
        }

        private void setPrevious(Node previous) {
            this.previous = previous;
        }

        public String toString() {
            return value.toString();
        }

    }

}
