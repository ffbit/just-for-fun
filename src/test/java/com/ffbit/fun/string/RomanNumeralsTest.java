package com.ffbit.fun.string;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

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
        return Arrays.asList(new Object[][] {
                { "I", 1 },
                { "V", 5 },
                { "X", 10 },
                { "L", 50 },
                { "C", 100 },
                { "M", 1000 },

                { "II", 2 }
        });
    }

    @Test
    public void testConvertionRomanNumberToDecimal() throws Exception {
        assertThat(romanToInt(romanNumber), is(exptectedDecimalNumber));
    }

    private int romanToInt(String roman) {
        char[] digits = roman.toCharArray();
        int result = 0;

        for (char digit : digits) {
            int currentNumber = 0;

            switch (digit) {
            case 'I':
                currentNumber = 1;
                break;
            case 'V':
                currentNumber = 5;
                break;
            case 'X':
                currentNumber = 10;
                break;
            case 'L':
                currentNumber = 50;
                break;
            case 'C':
                currentNumber = 100;
                break;
            case 'M':
                currentNumber = 1000;
                break;
            }

            result += currentNumber;
        }

        return result;
    }

}
