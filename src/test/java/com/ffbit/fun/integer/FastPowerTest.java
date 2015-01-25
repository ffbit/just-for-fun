package com.ffbit.fun.integer;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class FastPowerTest {
    private FastPower fastPower = new FastPower();

    @Test
    @Parameters({
            "2, 0, 1",
            "2, 1, 2",
            "2, 2, 4",
            "2, 3, 8",
            "2, 4, 16",
            "2, 5, 32",
            "2, 6, 64",
            "2, 7, 128",
            "2, 8, 256",
            "2, 9, 512",
            "2, 10, 1024"
    })
    public void itShouldPower(int x, int n, int expectedResult) {
        assertThat(fastPower.pow(x, n), is(expectedResult));
    }

}
