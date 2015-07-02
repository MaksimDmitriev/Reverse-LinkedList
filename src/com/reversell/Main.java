package com.reversell;

public class Main {

    public static void main(String[] args) {
        Node first = new Node(12);
        SinglyLinkedList linkedList = new SinglyLinkedList(first);
        linkedList.addLast(new Node(1));
        linkedList.addLast(new Node(125));
        linkedList.addLast(new Node(66));
        linkedList.addLast(new Node(88));

        linkedList.print();
        // Reverse
        // 12 1 125 66 88
        linkedList.reverse();
        linkedList.print();
    }

}
