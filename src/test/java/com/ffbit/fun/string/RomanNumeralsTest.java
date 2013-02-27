package com.ffbit.fun.string;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RomanNumeralsTest {

    @Test
    public void itShouldConvertIToOne() throws Exception {
        assertThat(romanToInt("I"), is(1));
    }

    private int romanToInt(String string) {
        return 0;
    }

}
