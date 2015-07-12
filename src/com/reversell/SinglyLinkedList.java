package com.reversell;

public class SinglyLinkedList {

    private Node mFirst;
    private Node mLast;

    public SinglyLinkedList(Node first) {
        this.mFirst = first;
        this.mLast = first;
    }

    public void addLast(Node node) {
        mLast.setNext(node);
        mLast = node;
    }

    public Node getFirst() {
        return mFirst;
    }
    
    
    public Node getLast() {
        return mLast;
    }

    public void print() {
        Node current = mFirst;
        System.out.print("[");
        while (current != null) {
            System.out.print(current);
            current = current.getNext();
            if (current != null) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    public void reverse() {
        Node prev = mFirst;
        Node current = mFirst.getNext();
        prev.setNext(null);
        while (current != null) {
            Node next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            if (current == null) {
                mLast = mFirst;
                mFirst = prev;
            }
        }
    }

}
