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
            case 'L':
                result += 50;
                break;
            }
        }

        return result;
    }

}
