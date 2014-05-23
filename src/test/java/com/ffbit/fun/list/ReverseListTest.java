package com.ffbit.fun.list;

import org.junit.Test;

import java.util.Objects;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node that = (Node) o;

            return Objects.equals(value, that.value)
                    && Objects.equals(next, that.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next);
        }

    }

    @Test
    public void testReverseRecursive() throws Exception {
        Node<Integer> list = new Node<Integer>(1);
        list = new Node<Integer>(2, list);
        list = new Node<Integer>(3, list);

        assertThat(reverse(list), is(new Node<>(1, new Node<>(2, new Node<>(3)))));
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
