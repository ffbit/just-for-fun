package com.ffbit.fun.string;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class RomanNumeralsTest {

    @Test
    public void itShouldConvertIToOne() throws Exception {
        assertThat(romanToInt("I"), is(1));
    }

    @Test
    public void itShouldConvertIIToTwo() throws Exception {
        assertThat(romanToInt("II"), is(2));
    }

    @Test
    public void itShouldConvertVToFive() throws Exception {
        assertThat(romanToInt("V"), is(5));
    }

    @Test
    public void itShouldConvertXToTen() throws Exception {
        assertThat(romanToInt("X"), is(10));
    }

    @Test
    public void itShouldConvertLToFifty() throws Exception {
        assertThat(romanToInt("L"), is(50));
    }

    private int romanToInt(String roman) {
        char[] digits = roman.toCharArray();
        int result = 0;

        for (char digit : digits) {
            switch (digit) {
            case 'I':
                result++;
                break;
            case 'V':
                result += 5;
                break;
            case 'X':
                result += 10;
                break;
            }
        }

        return result;
    }
}
