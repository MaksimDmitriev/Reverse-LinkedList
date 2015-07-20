package com.reversell;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedListTest {

    @Test
    public void test_empty_reversed_is_empty() {
        assertArrayEquals(new int[] {}, reversed());
    }

    @Test
    public void test_12_reversed_is_12() {
        assertArrayEquals(new int[] { 12 }, reversed(12));
    }

    @Test
    public void test_12_34_reversed_is_34_12() {
        assertArrayEquals(new int[] { 34, 12 }, reversed(12, 34));
    }

    @Test
    public void test_12_34_78_reversed_is_34_12_78() {
        assertArrayEquals(new int[] { 34, 12, 78 }, reversed(12, 34, 78));
    }

    @Test
    public void test_12_34_78_124_reversed_is_34_12_124_78() {
        assertArrayEquals(new int[] { 34, 12, 124, 78 }, reversed(12, 34, 78, 124));
    }

    @Test
    public void test_five_elements() {
        assertArrayEquals(new int[] { 34, 12, 124, 78, 67 }, reversed(12, 34, 78, 124, 67));
    }

    @Test
    public void test_six_elements() {
        assertArrayEquals(new int[] { 34, 12, 124, 78, 67, 88 }, reversed(12, 34, 78, 124, 88, 67));
    }

    private int[] reversed(int... nums) {
        SinglyLinkedList list = new SinglyLinkedList(nums);
        list.reversePairs();
        return toArray(list);
    }
    
    private int[] reversed2(int... nums) {
        SinglyLinkedList list = new SinglyLinkedList(nums);
        list.reversePairs();
        return toArray(list);
    }

    private int[] toArray(SinglyLinkedList list) {
        List<Integer> values = new ArrayList<>();

        Node node = list.getFirst();
        while (node != null) {
            values.add(node.getData());
            node = node.getNext();
        }

        int[] arr = new int[values.size()];
        for (int index = 0; index < arr.length; ++index) {
            arr[index] = values.get(index);
        }
        return arr;
    }
}
