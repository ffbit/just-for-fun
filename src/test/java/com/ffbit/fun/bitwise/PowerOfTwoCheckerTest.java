package com.ffbit.fun.bitwise;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class PowerOfTwoCheckerTest {
    private PowerOfTwoChecker checker = new PowerOfTwoChecker();

    @Test
    @Parameters({
            "1",
            "2",
            "4",
            "8",
            "16",
            "32",
            "64",
            "128",
            "256",
            "512",
            "1024",
            "2048",
            "4096"
    })
    public void itShouldCheckPositively(int i) {
        assertThat(checker.isPowerOfTwo(i), is(true));
    }

    @Test
    @Parameters({
            "3",
            "5",
            "6",
            "7",
            "9",
            "10",
            "31",
            "33",
            "1023",
            "2000"
    })
    public void itShouldCheckNegatively(int i) {
        assertThat(checker.isPowerOfTwo(i), is(false));
    }

    @Test
    public void itShouldCheckZeroNegatively() {
        assertThat(checker.isPowerOfTwo(0), is(false));
    }

}
