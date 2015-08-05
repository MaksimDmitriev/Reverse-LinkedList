package com.singlylinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList implements Iterable<Integer> {

    /** Dummy node */
    private final Node head = new Node(0);
    private int size;

    public SinglyLinkedList(int[] data) {
        for (int i = data.length - 1; i >= 0; i--) {
            addFirst(data[i]);
        }
    }

    public void addFirst(int datum) {
        Node n = new Node(datum);
        n.next = head.next;
        head.next = n;
        size++;
    }

    public void reversePairs() {
        // For each loop iteration, transform
        //
        // maybe null --+
        // |
        // v
        // Original: (a) -> b -> c -> d ...
        // To: a -> c -> (b) -> d ...
        // ^
        // |
        // +-- becomes "a" of the next iteration

        Node a = this.head, b, c;
        while ((b = a.next) != null && (c = b.next) != null) {
            Node d = c.next;
            a.next = c;
            c.next = b;
            b.next = d;
            a = b;
        }
    }
    
    public int[] toArray() {
        int array[] = new int[size];
        int i = 0;
        Iterator<Integer> iterator = iterator();
        while(iterator.hasNext()) {
            array[i++] = iterator.next();
        }
        return array;
    }

    @Override
    public String toString() {
        Iterator<Integer> iterator = iterator();
        if (!iterator.hasNext()) {
            return "[]";
        }
        
        StringBuilder s = new StringBuilder("[" + iterator.next());
        while(iterator.hasNext()) {
            int nodeValue = iterator.next();
            s.append(" -> " + nodeValue);
        }
        return s.append(']').toString();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node prev = head, current = head;
            boolean removable = false;

            @Override
            public void remove() {
                if (!this.removable) {
                    throw new IllegalStateException("next() has not been called");
                }
                this.removable = false;
                this.prev.next = this.current.next;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (this.removable) this.prev = this.current;
                this.current = this.current.next;
                this.removable = true;
                return this.current.data;
            }

            @Override
            public boolean hasNext() {
                return this.current.next != null;
            }

        };
    }
    
    private static class Node {

         Node next;
         int data;

         Node(int data) {
            this.data = data;
        }
    }

}
