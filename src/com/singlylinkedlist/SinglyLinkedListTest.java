package com.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedListTest {

    @Test
    public void testEmpty() {
        // we'll leave the while loop because size == 0
        SinglyLinkedList linkedList = new SinglyLinkedList(new int[] {});
        boolean modified = linkedList.reversePairs();
        Assert.assertFalse(modified);
    }

    @Test
    public void testSingle() {
        // we'll leave the while loop because size == 1
        SinglyLinkedList linkedList = new SinglyLinkedList(new int[] { 1 });
        boolean modified = linkedList.reversePairs();
        Assert.assertFalse(modified);
    }

    @Test
    public void test_b_and_c_null() {
        // Initially (b != null && c != null)
        // Then we'll leave the while loop because (b == null && c == null)
        int[] orig = new int[] { 1, 2 };
        int[] reversed = new int[] { 2, 1 };
        SinglyLinkedList linkedList = new SinglyLinkedList(orig);
        linkedList.reversePairs();
        Assert.assertArrayEquals(reversed, linkedList.toArray());
    }

    @Test
    public void test_b_not_null_c_null() {
        // Initially (b != null && c != null)
        // Then we'll leave the while loop because (b != null && c == null)
        int[] orig = new int[] { 1, 2, 3 };
        int[] reversed = new int[] { 2, 1, 3 };
        SinglyLinkedList linkedList = new SinglyLinkedList(orig);
        linkedList.reversePairs();
        Assert.assertArrayEquals(reversed, linkedList.toArray());
    }

    @Test
    public void testLoopMoreThanOnceEven() {
        int[] orig = new int[] { 1, 2, 3, 4, 5, 6 };
        int[] reversed = new int[] { 2, 1, 4, 3, 6, 5 };
        SinglyLinkedList linkedList = new SinglyLinkedList(orig);
        linkedList.reversePairs();
        Assert.assertArrayEquals(reversed, linkedList.toArray());
    }

    @Test
    public void testLoopMoreThanOnceOdd() {
        int[] orig = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        int[] reversed = new int[] { 2, 1, 4, 3, 6, 5, 7 };
        SinglyLinkedList linkedList = new SinglyLinkedList(orig);
        linkedList.reversePairs();
        Assert.assertArrayEquals(reversed, linkedList.toArray());
    }

    @Test
    public void testToStringEmpty() {
        SinglyLinkedList linkedList = new SinglyLinkedList(null);
        Assert.assertEquals("[]", linkedList.toString());
    }

    @Test
    public void testToStringNoNext() {
        SinglyLinkedList linkedList = new SinglyLinkedList(1);
        Assert.assertEquals("[1]", linkedList.toString());
    }

    @Test
    public void testToStringHasNext() {
        SinglyLinkedList linkedList = new SinglyLinkedList(1, 2);
        Assert.assertEquals("[1 -> 2]", linkedList.toString());
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testAddAfterCreatingIterator() {
        SinglyLinkedList linkedList = new SinglyLinkedList(new int[] { 1, 2, 3, 4 });
        Iterator<Integer> iterator = linkedList.iterator();
        if (iterator.hasNext()) {
            linkedList.addFirst(12);
            iterator.next();
        }
    }

    @Test(expected = IllegalStateException.class)
    public void testRemoveTwice() {
        SinglyLinkedList linkedList = new SinglyLinkedList(new int[] { 1, 2, 3, 4 });
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
        }
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testNextAfterIteration() {
        SinglyLinkedList linkedList = new SinglyLinkedList(new int[] { 1, 2, 3, 4 });
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }
    
    @Test
    public void testRemove() {
        SinglyLinkedList linkedList = new SinglyLinkedList(new int[] { 1, 2, 3, 4 });
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            int data = iterator.next();
            if (data == 1 || data == 4) {
                iterator.remove();
            }
        }
        Assert.assertArrayEquals(new int [] {2, 3}, linkedList.toArray());
    }
}