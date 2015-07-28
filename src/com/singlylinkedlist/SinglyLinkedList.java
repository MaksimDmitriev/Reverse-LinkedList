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
        n.setNext(head.getNext());
        head.setNext(n);
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
        while ((b = a.getNext()) != null && (c = b.getNext()) != null) {
            Node d = c.getNext();
            a.setNext(c);
            c.setNext(b);
            b.setNext(d);
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
    
    public boolean remove(Node node) {
        /* 
         * The public method addFirst(int) allows to pass primitive integer values rather than
         * objects. Nulls can't be added to my singly linked list, and there is no reason to iterate
         * over the list to finally return false.
         */
        if (node == null) {
            return false;
        }
        Node prev = head;
        Node curr = head.getNext();
        while(curr != null) {
            if (node.equals(curr)) {
                prev.setNext(curr.getNext());
                curr = null;
                size--;
                return true;
            }
            prev = curr;
            curr = curr.getNext();
        }
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            Node current = head;

            @Override
            public void remove() {
                SinglyLinkedList.this.remove(current);
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
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
