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

            Node prev;
            Node current = head;
            Node next = current.next;

            @Override
            public void remove() {
                prev.next = next;
                current.next = null;
                current = null; // TODO: Do I need to eliminate this obsolete reference?
                current = next;
                if (current == null) {
                    next = null;
                } else {
                    next = current.next;
                }
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                prev = current;
                current = next;
                next = next.next;
                return current.data;
            }

            @Override
            public boolean hasNext() {
                return next != null;
            }

        };
    }
    
    private static class Node {

         Node next;
         int data;

         Node(int data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Node)) {
                return false;
            }
            Node another = (Node) obj;
            return data == another.data;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + data;
            return result;
        }
    }

}
