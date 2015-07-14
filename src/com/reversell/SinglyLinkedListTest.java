package com.reversell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SinglyLinkedListTest {

    private int[] single = new int[] {
            12
    };

    private int[] twoElems = new int[] {
            12, 34
    };
    private int[] twoElemsReversedPairs = new int[] {
            34, 12
    };

    private int[] threeElems = new int[] {
            12, 34, 78
    };
    private int[] threeElemsReversedPairs = new int[] {
            34, 12, 78
    };

    private int[] evenElems = new int[] {
            12, 34, 78, 124
    };
    private int[] evenElemsReversedPairs = new int[] {
            34, 12, 124, 78
    };

    private int[] oddElems = new int[] {
            12, 34, 78, 45, 90
    };
    private int[] oddElemsReversedPairs = new int[] {
            34, 12, 45, 78, 90
    };

    @Test
    public void test() {
        assertEquals(true, doReverse(new SinglyLinkedList(single), single, single));

        assertEquals(true, doReverse(new SinglyLinkedList(twoElems), twoElems, twoElemsReversedPairs));

        assertEquals(true, doReverse(new SinglyLinkedList(threeElems), threeElems, threeElemsReversedPairs));

        assertEquals(true, doReverse(new SinglyLinkedList(oddElems), oddElems, oddElemsReversedPairs));

        assertEquals(true, doReverse(new SinglyLinkedList(evenElems), evenElems, evenElemsReversedPairs));

    }

    private boolean isFirstCorrect(SinglyLinkedList linkedList, int value) {
        return linkedList.getFirst().getData() == value;
    }

    private boolean isLastCorrect(SinglyLinkedList linkedList, int value) {
        return linkedList.getLast().getData() == value;
    }

    private boolean doReverse(SinglyLinkedList list, int[] origArray, int[] reversedArray) {
        boolean checkOrig = isListCorect(list, origArray);
        if (!checkOrig) {
            return false;
        }
        list.reversePairs();

        return isFirstCorrect(list, reversedArray[0]) && isLastCorrect(list,
                reversedArray[reversedArray.length - 1]) && isListCorect(list, reversedArray);
    }

    private boolean isListCorect(SinglyLinkedList list, int[] array) {
        Node curr = list.getFirst();
        int arrayIndex = 0;
        while (curr != null) {
            if (array[arrayIndex] != curr.getData()) {
                return false;
            }
            curr = curr.getNext();
            arrayIndex++;
        }
        return true;
    }

}
