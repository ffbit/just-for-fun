package com.ffbit.fun.list;

import org.junit.Test;

public class ReverseListTest {
    private class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            value = e;
            next = n;
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            if (next == null) {
                return String.valueOf(value);
            }

            return value + ", " + next.toString();
        }
    }

    @Test
    public void testReverseRecursive() throws Exception {
        Node<Integer> list = new Node<Integer>(1);
        list = new Node<Integer>(2, list);
        list = new Node<Integer>(3, list);

        System.out.println(list);
        System.out.println(reverse(list));
    }

    private <E> Node<E> reverse(Node<E> list) {
        Node<E> reversed = null;

        while (list != null) {
            Node<E> head = list;
            list = list.next;
            head.next = reversed;
            reversed = head;
        }

        return reversed;
    }

    private <E> Node<E> reverseRecursive(Node list) {
        if (list == null || list.next == null) {
            return list;
        }

        Node<E> tail = list.next;
        list.next = null;

        Node<E> reversed = reverseRecursive(tail);
        tail.next = list;

        return reversed;
    }

}
