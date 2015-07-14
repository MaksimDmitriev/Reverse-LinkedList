package com.reversell;

public class Main {

    private static int[] single = new int[] {
            12, 45, 44, 333
    };
    private static SinglyLinkedList singleElemList = new SinglyLinkedList(single);


    public static void main(String[] args) {
        singleElemList.print();
        singleElemList.reversePairs();
        singleElemList.print();
        
    }
}
