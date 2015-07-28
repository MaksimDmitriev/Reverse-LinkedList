package com.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListTest {

    @Test
    public void testEmpty() {
        int[] orig = new int[] {};
        int[] reversed = new int[] {};
        SinglyLinkedList linkedList = new SinglyLinkedList(orig);
        linkedList.reversePairs();
        Assert.assertArrayEquals(reversed, linkedList.toArray());
    }

    @Test
    public void testSingle() {
        int[] orig = new int[] { 1 };
        int[] reversed = new int[] { 1 };
        SinglyLinkedList linkedList = new SinglyLinkedList(orig);
        linkedList.reversePairs();
        Assert.assertArrayEquals(reversed, linkedList.toArray());
    }

    @Test
    public void testLoopOnce() {
        int[] orig = new int[] { 1, 2 };
        int[] reversed = new int[] { 2, 1 };
        SinglyLinkedList linkedList = new SinglyLinkedList(orig);
        linkedList.reversePairs();
        Assert.assertArrayEquals(reversed, linkedList.toArray());

    }

    @Test
    public void testLoopMoreThanOnce() {
        int[] orig = new int[] { 1, 2, 3, 4, 5, 6 };
        int[] reversed = new int[] { 2, 1, 4, 3, 6, 5 };
        SinglyLinkedList linkedList = new SinglyLinkedList(orig);
        linkedList.reversePairs();
        Assert.assertArrayEquals(reversed, linkedList.toArray());
    }
}