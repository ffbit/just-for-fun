package com.ffbit.fun.list;

public class SinglyList<E> {
    private E value;
    private SinglyList<E> next;

    public SinglyList(E value) {
        this(value, null);
    }

    public SinglyList(E value, SinglyList<E> next) {
        this.value = value;
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public SinglyList<E> getNext() {
        return next;
    }

    public void setNext(SinglyList<E> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value + " -> " + next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SinglyList that = (SinglyList) o;

        if (next != null ? !next.equals(that.next) : that.next != null)
            return false;
        if (value != null ? !value.equals(that.value) : that.value != null)
            return false;

        return true;
    }

}
