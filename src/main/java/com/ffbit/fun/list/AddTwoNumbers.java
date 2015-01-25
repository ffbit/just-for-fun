package com.ffbit.fun.list;

/**
 * http://www.programcreek.com/2012/12/add-two-numbers/
 */
public class AddTwoNumbers {

    static class ListNode {
        private final int value;
        private ListNode next;

        ListNode(int value) {
            this(value, null);
        }

        ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public ListNode getNext() {
            return next;
        }

        public boolean hasNext() {
            return next == null;
        }

        @Override
        public String toString() {
            ListNode current = this;

            StringBuilder representation = new StringBuilder();
            String separator = "";
            while (current != null) {
                representation.append(separator)
                        .append(current.value);
                separator = " -> ";
                current = current.next;
            }

            return representation.toString();
        }

    }

    public ListNode sum(ListNode firstNumber, ListNode secondNumber) {
        ListNode firstCurrentNode = firstNumber;
        ListNode secondCurrentNode = secondNumber;

        // fake node
        ListNode sum = new ListNode(0);
        ListNode tail = sum;

        int carrying = 0;
        while (firstCurrentNode != null || secondCurrentNode != null) {
            int firstCurrentValue = 0;
            int secondCurrentValue = 0;

            if (firstCurrentNode != null) {
                firstCurrentValue = firstCurrentNode.value;
                firstCurrentNode = firstCurrentNode.next;
            }

            if (secondCurrentNode != null) {
                secondCurrentValue = secondCurrentNode.value;
                secondCurrentNode = secondCurrentNode.next;
            }

            int currentSum = firstCurrentValue + secondCurrentValue + carrying;

            carrying = currentSum / 10;
            int currentValue = currentSum % 10;

            tail.next = new ListNode(currentValue);
            tail = tail.next;
        }

        if (carrying > 0) {
            tail.next = new ListNode(carrying);
        }

        return sum.next;
    }

}
