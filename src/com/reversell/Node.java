package com.reversell;

class Node {

    private Node next;
    private int data;

    Node(int data) {
        this.data = data;
    }

    int getData() {
        return data;
    }
    
    void setData(int data) {
        this.data = data;
    }

    void setNext(Node n) {
        this.next = n;
    }

    Node getNext() {
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