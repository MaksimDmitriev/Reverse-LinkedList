package com.singlylinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList implements Iterable<Integer> {

    /** Dummy node */
    private final Node head = new Node(0);

    public SinglyLinkedList(int[] data) {
        for (int i = data.length - 1; i >= 0; i--) {
            addFirst(data[i]);
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

            Node current = head;
            Node prev;

            // TODO: ask a question. Why do they eliminate obsolete references in the source code
            // of LinkedList? Why do they consider those references obsolete?
            @Override
            public void remove() {
                prev.setNext(current.getNext());
                current.setNext(null);
                current = prev;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                prev = current;
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
