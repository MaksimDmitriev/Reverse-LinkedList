package com.reversell;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class SinglyLinkedListTest {

    @Test
    public void testEmpty() {
        int[] orig = new int[] {};
        int[] expected = new int[] {};
        SinglyLinkedList linkedList = new SinglyLinkedList(orig);
        assertArrayEquals(expected, toArray(reverse(linkedList)));
        assertNull(linkedList.getLast());
    }

    @Test
    public void testSingleElement() {
        int[] orig = new int[] { 12 };
        int[] expected = new int[] { 12 };

        SinglyLinkedList linkedList = new SinglyLinkedList(orig);
        assertArrayEquals(expected, toArray(reverse(linkedList)));
        assertEquals(new Node(expected[expected.length - 1]), linkedList.getLast());
    }

    @Test
    public void testTwoElements() {
        int[] orig = new int[] { 12, 34 };
        int[] expected = new int[] { 34, 12 };

        SinglyLinkedList linkedList = new SinglyLinkedList(orig);
        assertArrayEquals(expected, toArray(reverse(linkedList)));
        assertEquals(new Node(expected[expected.length - 1]), linkedList.getLast());
    }

    @Test
    public void testThreeElements() {
        int[] orig = new int[] { 12, 34, 78 };
        int[] expected = new int[] { 34, 12, 78 };

        SinglyLinkedList linkedList = new SinglyLinkedList(orig);
        assertArrayEquals(expected, toArray(reverse(linkedList)));
        assertEquals(new Node(expected[expected.length - 1]), linkedList.getLast());

    }

    @Test
    public void testEvenElements() {
        int[] orig = new int[] { 12, 34, 78, 56 };
        int[] expected = new int[] { 34, 12, 56, 78 };

        SinglyLinkedList linkedList = new SinglyLinkedList(orig);
        assertArrayEquals(expected, toArray(reverse(linkedList)));
        assertEquals(new Node(expected[expected.length - 1]), linkedList.getLast());
    }

    @Test
    public void testOddElements() {
        int[] orig = new int[] { 12, 34, 78, 56, 677 };
        int[] expected = new int[] { 34, 12, 56, 78, 677 };

        SinglyLinkedList linkedList = new SinglyLinkedList(orig);
        assertArrayEquals(expected, toArray(reverse(linkedList)));
        assertEquals(new Node(expected[expected.length - 1]), linkedList.getLast());
    }

    private SinglyLinkedList reverse(SinglyLinkedList list) {
        list.reversePairs();
        return list;
    }

    private int[] toArray(SinglyLinkedList list) {
        int[] arr = new int[list.getSize()];
        Node node = list.getFirst();
        int index = 0;
        while (node != null) {
            arr[index++] = node.getData();
            node = node.getNext();
        }
        return arr;
    }
}
