package com.reversell;

public class SinglyLinkedList {

    private Node mFirst;
    private Node mLast;

    public SinglyLinkedList(Node first) {
        this.mFirst = first;
        this.mLast = first;
    }
    
    public SinglyLinkedList(int []array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException();
        }
        this.mFirst = new Node(array[0]);
        this.mLast = this.mFirst;
        for (int i = 1; i < array.length; i++) {
            addLast(new Node(array[i]));
        }
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

    public void reversePairs() {
        Node prev = mFirst;
        Node curr = prev.getNext();
        Node old = null;
        while (curr != null) {
            Node next = curr.getNext();
            curr.setNext(prev);
            prev.setNext(null);
            if (prev == mFirst) {
                mFirst = curr;
            }
            if (old != null) {
                old.setNext(curr);
            }
            old = prev;
            prev = next;
            if (prev != null) {
                curr = prev.getNext();
                if (curr == null) {
                    old.setNext(prev);
                    mLast = prev;
                }
            } else {
                mLast = old;
                break;
            }
        }
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
