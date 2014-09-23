package com.ffbit.fun.list;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class SinglyListReverseTest {
    private SinglyListReverse<Integer> reverser = new SinglyListReverse<>();

    @Test
    public void itShouldReverseNull() {
        assertThat(reverser.reverse(null), is(nullValue()));
    }

    @Test
    public void itShouldReverseSingleList() {
        SinglyList<Integer> list = new SinglyList<>(1);
        assertThat(reverser.reverse(list), is(list));
    }

    @Test
    public void itShouldReverseList() {
        SinglyList<Integer> list = new SinglyList<>(1);
        list.setNext(new SinglyList<>(2));
        list.getNext().setNext(new SinglyList<>(3));

        SinglyList<Integer> expected = new SinglyList<>(3);
        expected.setNext(new SinglyList<>(2));
        expected.getNext().setNext(new SinglyList<>(1));

        assertThat(reverser.reverse(list), is(expected));
    }

}
