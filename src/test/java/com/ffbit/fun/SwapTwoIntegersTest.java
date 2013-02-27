package com.ffbit.fun;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SwapTwoIntegersTest {

    @Test
    public void testDifferenceWay() throws Exception {
        int x = 2;
        int y = 3;

        // algorithm's idea goes here
        // ...

        assertThat(x, is(3));
        assertThat(y, is(2));
    }

}
