package com.singlylinkedlist;

import java.util.Iterator;

public class SinglyLinkedList implements Iterable<Integer> {

    /** Dummy node */
    private final Node head = new Node(0);

    public SinglyLinkedList(int[] data) {
        for (int i = data.length - 1; i >= 0; i--) {
            addFirst(data[i]);
        }
    }

    public SinglyLinkedList(SinglyLinkedList from) {
        Node source = from.head.getNext();
        Node dst = head;
        while (source != null) {
            dst.setNext(new Node(source.getData()));
            source = source.getNext();
            dst = dst.getNext();
        }
    }

    public void addFirst(int datum) {
        Node n = new Node(datum);
        n.setNext(head.getNext());
        head.setNext(n);
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
        while ((b = a.getNext()) != null && (c = b.getNext()) != null) {
            Node d = c.getNext();
            a.setNext(c);
            c.setNext(b);
            b.setNext(d);
            a = b;
        }
    }

    @Override
    public String toString() {
        Iterator<Integer> iterator = iterator();
        if (!iterator.hasNext()) {
            return "[]";
        }
        
        StringBuilder s = new StringBuilder("[");
        while(true) {
            int nodeValue = iterator.next();
            s.append(nodeValue);
            if (!iterator.hasNext()) {
                return s.append(']').toString();
            }
            s.append(" -> ");
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            Node current = head;

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public Integer next() {
                current = current.getNext();
                return current.getData();
            }

            @Override
            public boolean hasNext() {
                return current.getNext() != null;
            }

        };
    }

}