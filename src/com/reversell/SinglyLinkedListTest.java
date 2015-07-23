package com.reversell;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class SinglyLinkedListTest {

    // The list is empty. We don't run the while loop in reversePairs
    @Test
    public void testEmpty() {
        int[] orig = new int[] {};
        int[] expected = new int[] {};
        SinglyLinkedList linkedList = new SinglyLinkedList(orig);
        assertArrayEquals(expected, toArray(reverse(linkedList)));
        assertNull(linkedList.getLast());
    }

    // The list contains one element. We don't run the while loop in reversePairs
    @Test
    public void testSingleElement() {
        int[] orig = new int[] { 12 };
        int[] expected = new int[] { 12 };

        SinglyLinkedList linkedList = new SinglyLinkedList(orig);
        assertArrayEquals(expected, toArray(reverse(linkedList)));
        assertEquals(new Node(expected[expected.length - 1]), linkedList.getLast());
    }

    // The while loop is run once.
    // We leave the loop because fop is null. We don't go inside (temp != null)
    @Test
    public void testTwoElements() {
        int[] orig = new int[] { 12, 34 };
        int[] expected = new int[] { 34, 12 };

        SinglyLinkedList linkedList = new SinglyLinkedList(orig);
        assertArrayEquals(expected, toArray(reverse(linkedList)));
        assertEquals(new Node(expected[expected.length - 1]), linkedList.getLast());
    }

    // The while loop is run once.
    // We leave the loop because fop.getNext() is null. We don't go inside (temp != null)
    @Test
    public void testThreeElements() {
        int[] orig = new int[] { 12, 34, 78 };
        int[] expected = new int[] { 34, 12, 78 };

        SinglyLinkedList linkedList = new SinglyLinkedList(orig);
        assertArrayEquals(expected, toArray(reverse(linkedList)));
        assertEquals(new Node(expected[expected.length - 1]), linkedList.getLast());
    }
    
    // The while loop is run more than once.
    // We go inside (temp != null).
    @Test
    public void testFourElements() {
        int[] orig = new int[] { 12, 34, 78 };
        int[] expected = new int[] { 34, 12, 78 };

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
