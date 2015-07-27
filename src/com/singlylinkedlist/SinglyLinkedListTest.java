package com.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListTest {

    @Test
    public void testEmpty() {
        expectReverse(new int[] {}, new int[] {});
    }

    @Test
    public void testSingle() {
        expectReverse(new int[] { 1 }, new int[] { 1 });
    }

    @Test
    public void testLoopOnce() {
        expectReverse(new int[] { 1, 2 }, new int[] { 2, 1 });
    }

    @Test
    public void testLoopMoreThanOnce() {
        expectReverse(new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 2, 1, 4, 3, 6, 5 });
    }

    private void expectReverse(int[] orig, int[] reversed) {
        Assert.assertEquals(orig.length, reversed.length);
        int length = orig.length;
        if (length == 0) {
            return;
        }
        for (int i = 1; i < length - 1; i++) {
            if (orig[i] != reversed[i - 1] || reversed[i] != orig[i - 1]) {
                Assert.fail("Failed at i = " + i);
            }
        }
        Assert.assertEquals(orig[length - 1], reversed[length - 1]);
    }
}