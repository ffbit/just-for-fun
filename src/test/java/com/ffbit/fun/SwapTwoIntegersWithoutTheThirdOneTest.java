package com.ffbit.fun;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SwapTwoIntegersWithoutTheThirdOneTest {

    @Test
    public void testDifferenceWay() throws Exception {
        int x = 2;
        int y = 3;

        // algorithm's idea goes here
        x = x - y;
        y = x + y;
        x = y - x;

        assertThat(x, is(3));
        assertThat(y, is(2));
    }

    @Test
    public void testAdditionWay() throws Exception {
        int x = 2;
        int y = 3;

        // algorithm's idea goes here
        x = x + y;
        y = x - y;
        x = x - y;

        assertThat(x, is(3));
        assertThat(y, is(2));
    }

}
