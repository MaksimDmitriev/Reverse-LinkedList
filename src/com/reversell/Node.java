package com.reversell;

class Node {

    private Node next;
    private int data;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    @Override
    public String toString() {
        return Integer.toString(data);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Node)) {
            return false;
        }
        Node another = (Node) obj;
        return data == another.data;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + data;
        return result;
    }

}