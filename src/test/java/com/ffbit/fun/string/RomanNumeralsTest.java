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

                {"IV", 4},
                {"MMXIII", 2013},
                {"DCCCXLI", 841}
        });
    }

    @Test
    public void testConversionRomanNumberToDecimal() throws Exception {
        assertThat(romanToInt(romanNumber), is(exptectedDecimalNumber));
    }

    private int romanToInt(String roman) {
        char[] digits = roman.toCharArray();
        int result = 0;

        for (char digit : digits) {
            int currentNumber = 0;

            currentNumber = romanDigitToDecimalNumber(digit);

            result += currentNumber;
        }

        return result;
    }

    private int romanDigitToDecimalNumber(char digit) {
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
                return 0;
        }
    }

}
