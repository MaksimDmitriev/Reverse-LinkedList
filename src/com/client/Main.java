package com.client;

import com.singlylinkedlist.SinglyLinkedList;

import java.util.Iterator;


public class Main {

    public static void main(String[] args) {

        SinglyLinkedList linkedList = new SinglyLinkedList(new int [] {1, 2, 3, 4});
        System.out.println(linkedList);
        Iterator<Integer> iterator = linkedList.iterator();
        iterator.next();
        iterator.remove();
        iterator.next();
        iterator.remove();
        System.out.println(linkedList);

    
        
    }

}
