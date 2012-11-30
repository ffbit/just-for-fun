package com.ffbit.fun.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ReverseArrayTest {

    private ArrayReverser reverser;
    private int[] array;
    private int[] expected;

    @Before
    public void setUp() throws Exception {
        reverser = new ArrayReverser();
        array = new int[]{1, 2, 3, 4, 5};
        expected = new int[]{5, 4, 3, 2, 1};
    }

    @Test
    public void itShouldReverseArray() throws Exception {
        assertArrayEquals(reverser.reverse(array), expected);
    }
}
