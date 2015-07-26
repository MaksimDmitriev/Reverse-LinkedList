package com.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class SinglyLinkedListTest {

    @Test
    public void testEmpty() {
        doReverse(new int[] {});
    }

    @Test
    public void testSingle() {
        doReverse(new int[] { 1 });
    }
    
    @Test
    public void testLoopOnce() {
        doReverse(new int[] { 1, 2 });
    }

    @Test
    public void testLoopMoreThanOnce() {
        doReverse(new int[] { 1, 2, 3, 4, 5, 6 });
    }

    private void doReverse(int[] data) {
        SinglyLinkedList orig = new SinglyLinkedList(data);
        SinglyLinkedList copy = new SinglyLinkedList(orig);
        orig.reversePairs();

        Iterator<Integer> origIterator = orig.iterator();
        Iterator<Integer> copyIterator = copy.iterator();

        // The list is empty
        if (!origIterator.hasNext()) {
            return;
        }
        int origFirstInPair = origIterator.next();
        int copyFirstInPair = copyIterator.next();
        while (true) {
            if (!origIterator.hasNext()) {
                Assert.assertTrue(origFirstInPair == copyFirstInPair);
                return;
            }
            int origSecondInPair = origIterator.next();
            int copySecondInPair = copyIterator.next();
            Assert.assertTrue(origFirstInPair == copySecondInPair && origSecondInPair == copyFirstInPair);
            if (!origIterator.hasNext()) {
                return;
            }
            origFirstInPair = origIterator.next();
            copyFirstInPair = copyIterator.next();
        }
    }
}