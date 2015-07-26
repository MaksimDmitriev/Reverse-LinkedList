package com.singlylinkedlist;

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
}