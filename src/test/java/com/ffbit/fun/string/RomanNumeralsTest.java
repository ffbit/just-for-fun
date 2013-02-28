package com.ffbit.fun.string;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class RomanNumeralsTest {
    private String romanNumber;
    private int exptectedDecimalNumber;

    public RomanNumeralsTest(String romanNumber, int exptectedDecimalNumber) {
        this.romanNumber = romanNumber;
        this.exptectedDecimalNumber = exptectedDecimalNumber;
    }

    @Parameters
    public static Collection<Object[]> init() {
        return Arrays.asList(new Object[][]{
                {"I", 1},
                {"V", 5},
                {"X", 10},
                {"L", 50},
                {"C", 100},
                {"D", 500},
                {"M", 1000},

                {"II", 2},
                {"VI", 6},
                {"DCCCXLI", 841},

                {"IV", 4},
                {"IMM", 1999},
                {"MCMXCIX", 1999},
                {"MMXIII", 2013}
        });
    }

    @Test
    public void testConversionRomanNumberToDecimal() throws Exception {
        assertThat(romanNumberToInteger(romanNumber), is(exptectedDecimalNumber));
    }

    @Test(expected = IllegalArgumentException.class)
    public void itShouldThrowExceptionWhenNonRomanSymbolOccurred() throws Exception {
        romanNumberToInteger("ABC");
    }

    private int romanNumberToInteger(String roman) {
        if (roman.isEmpty()) {
            return 0;
        }

        char[] digits = roman.toCharArray();
        int result = 0;
        int previous = romanDigitToInteger(digits[0]);
        int previousCount = 0;

        for (int i = 0; i < digits.length; i++) {
            int current = romanDigitToInteger(digits[i]);
            result += current;

            if (current != previous) {
                if (previous < current) {
                    result -= 2 * previousCount * previous;
                }

                previousCount = 0;
            }

            previous = current;
            previousCount++;
        }

        return result;
    }

    private int romanDigitToInteger(char digit) {
        switch (digit) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new IllegalArgumentException("Non Roman digit symbol occurred: " + digit);
        }
    }

}
