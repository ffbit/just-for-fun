package com.ffbit.fun.array;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class ArrayReverserTest {

    private ArrayReverser reverser;
    private int[] source;
    private int[] expected;

    public ArrayReverserTest(int[] array, int[] expected) {
        this.source = array;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> init() {
        Object[][] data = {
                {new int[]{}, new int[]{}},
                {new int[]{0}, new int[]{0}},
                {new int[]{0, 1}, new int[]{1, 0}},
                {new int[]{0, 1, 2}, new int[]{2, 1, 0}},
                {new int[]{1, 0, -1, 2}, new int[]{2, -1, 0, 1}}
        };

        return Arrays.asList(data);
    }

    @Before
    public void setUp() throws Exception {
        reverser = new ArrayReverser();
    }

    @Test
    public void itShouldReverseArray() throws Exception {
        assertArrayEquals(reverser.reverse(source), expected);
    }

}
