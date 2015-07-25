package com.reversell;

public class SinglyLinkedList {

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
        //                    maybe null --+
        //                                 |
        //                                 v
        // Original: (a) ->  b  ->  c  ->  d ...
        // To:        a  ->  c  -> (b) ->  d ...
        //                          ^
        //                          |
        //                          +-- becomes "a" of the next iteration

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
        StringBuilder s = new StringBuilder("[");
        for (Node n = this.head.getNext(); n != null; n = n.getNext()) {
            s.append(n);
            s.append(" -> ");
        }
        if (s.length() >= 4) s.setLength(s.length() - 4); // Remove final " -> "
        return s.append(']').toString();
    }

}
