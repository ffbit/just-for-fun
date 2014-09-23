package com.ffbit.fun.list;

public class SinglyListReverse<E> {

    public SinglyList<E> reverse(SinglyList<E> list) {
        SinglyList<E> head = list;
        SinglyList<E> newList = null;

        while (head != null) {
            SinglyList<E> tail = head.getNext();
            head.setNext(newList);
            newList = head;
            head = tail;
        }

        return newList;
    }

}
