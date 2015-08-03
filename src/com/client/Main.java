package com.client;

import com.singlylinkedlist.SinglyLinkedList;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList(new int [] {1, 2, 3, 4});
        System.out.println(linkedList);
        Iterator<Integer> iterator = linkedList.iterator();
        while(iterator.hasNext()) {
            int data = iterator.next();
            if (data == 556) {
                iterator.remove();
            }
        }
        System.out.println(linkedList);

    }

}
