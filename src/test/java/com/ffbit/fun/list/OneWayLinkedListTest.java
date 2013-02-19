package com.ffbit.fun.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OneWayLinkedListTest {
    private MyLinkedList<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new MyLinkedList<Integer>();
    }

    @Test
    public void itShouldBeEmptyWhenCreated() throws Exception {
        assertThat(list.isEmpty(), is(true));
    }

    @Test
    public void itShouldBeNotEmptyWhenCreatedWithAnElement() throws Exception {
        list = new MyLinkedList<Integer>(1);

        assertThat(list.isEmpty(), is(false));
    }

    @Test
    public void itShouldHaveZeroSizeWhenCreatedEmpty() throws Exception {
        assertThat(list.size(), is(0));
    }

    @Test
    public void itShouldHaveOneSizeWhenCreatedWithElement() throws Exception {
        list = new MyLinkedList<Integer>(1);

        assertThat(list.size(), is(1));
    }

    @Test
    public void itShouldBeAbleAddElementAndChangeSize() throws Exception {
        list.add(1);

        assertThat(list.size(), is(1));
        assertThat(list.isEmpty(), is(false));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void itShouldThrowExceptionWhenRemoveOnEmpty() throws Exception {
        list.remove(0);
    }

    @Test
    public void itShouldRemoveElementByIndexAndChangeSize() throws Exception {
        list.add(1);
        list.remove(0);

        assertThat(list.size(), is(0));
        assertThat(list.isEmpty(), is(true));
    }

    @Test
     public void itShouldRemoveElementAndDecreaseSize() throws Exception {
        list.add(1);
        list.add(2);
        list.remove(1);

        assertThat(list.size(), is(1));
        assertThat(list.isEmpty(), is(false));
    }

    @Test
    public void itShouldRemoveElementAndDecreaseSize1() throws Exception {
        list.add(1);
        list.add(2);
        list.remove(0);

        assertThat(list.size(), is(1));
        assertThat(list.isEmpty(), is(false));
    }

}

class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> end;
    private int size;

    private class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public boolean hasNext() {
            return this.next != null;
        }

    }

    public MyLinkedList() {
        size = 0;
    }

    public MyLinkedList(E e) {
        this();
        add(e);
    }

    public void add(E e) {
        Node<E> node = new Node<E>(e);

        if (head == null) {
            head = node;
        }

        if (end == null) {
            end = head;
        }

        if (end != node) {
            end.setNext(node);
            end = node;
        }

        size++;
    }

    public void remove(int index) {
        if (index < 0 || size() - 1 < index) {
            throw new IndexOutOfBoundsException("index:" + index + ", size:" + size());
        }

        Node<E> previous = head;
        Node<E> current = previous;

        for (int i = 0; i < index; i++) {
            previous = current;
            current = previous.getNext();
        }

        if (previous == current) {
            head = current.getNext();
            end = head;
        } else {
            previous.setNext(current.getNext());
        }

        size--;
    }

    public boolean isEmpty() {
        return head == end && head == null;
    }

    public int size() {
        return size;
    }

}
