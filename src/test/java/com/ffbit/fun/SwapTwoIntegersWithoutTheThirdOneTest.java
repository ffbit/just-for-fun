package com.ffbit.fun;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SwapTwoIntegersWithoutTheThirdOneTest {
    private int x;
    private int y;

    @Before
    public void setUp() {
        x = 2;
        y = 3;
    }

    @Test
    public void testDifferenceWay() throws Exception {
        // algorithm's idea goes here
        x = x - y;
        y = x + y;
        x = y - x;

        assertThat(x, is(3));
        assertThat(y, is(2));
    }

    @Test
    public void testAdditionWay() throws Exception {
        // algorithm's idea goes here
        x = x + y;
        y = x - y;
        x = x - y;

        assertThat(x, is(3));
        assertThat(y, is(2));
    }

}
