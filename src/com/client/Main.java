package com.client;

import com.singlylinkedlist.SinglyLinkedList;

import java.util.Iterator;


public class Main {

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList(new int [] {1});
        Iterator<Integer> iterator = linkedList.iterator();
        while(true) {
            iterator.next();
        }
    }

}
