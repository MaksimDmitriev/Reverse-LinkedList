package com.reversell;

public class SinglyLinkedList {

    private Node mFirst;
    private Node mLast;
    private int mSize;

    public SinglyLinkedList(Node first) {
        this.mFirst = first;
        this.mLast = first;
        this.mSize = 1;
    }

    public SinglyLinkedList(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        this.mFirst = new Node(array[0]);
        this.mLast = this.mFirst;
        mSize = 1;
        for (int i = 1; i < array.length; i++) {
            addLast(new Node(array[i]));
        }
    }

    public int getSize() {
        return mSize;
    }

    public void addLast(Node node) {
        mLast.setNext(node);
        mLast = node;
        mSize++;
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
        // The list is empty or contains one element
        if (mFirst == null || mFirst.getNext() == null) {
            return;
        }
        Node temp = null;
        Node fop = mFirst;
        mFirst = mFirst.getNext();
        while (fop != null && fop.getNext() != null) {
            if (temp != null) {
                // Set the next element of temp, where temp is the predecessor of fop.
                temp.setNext(fop.getNext());
            }
            // 12 -> 34 -> 88
            temp = fop.getNext(); // temp == 34
            fop.setNext(temp.getNext()); // 12 -> 88
            temp.setNext(fop); // 34 -> 12
            temp = temp.getNext(); // temp == 12
            fop = temp.getNext(); // fop == 88
            if (fop == null) {
                mLast = temp;
            } else {
                mLast = fop;
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

    // http://codereview.stackexchange.com/a/96879/23821
    public void reversePairs2() {
        if (mFirst == null) {
            return;
        }
        Node sentinel = new Node(0);
        sentinel.setNext(mFirst);

        Node node = sentinel;
        while (true) {
            Node next = node.getNext();
            if (next == null || next.getNext() == null) {
                break;
            }
            node.setNext(swap(next));
            node = next;
            mLast = next;
        }

        mFirst = sentinel.getNext();

        if (mLast.getNext() != null) {
            mLast = mLast.getNext();
        }
    }

    private Node swap(Node node) {
        Node next = node.getNext();
        Node nextnext = next.getNext();
        node.setNext(nextnext);
        next.setNext(node);
        return next;
    }

}
