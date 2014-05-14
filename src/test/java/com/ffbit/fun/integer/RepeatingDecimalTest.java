package com.ffbit.fun.integer;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Check whether result of dividing two integers produces a repeating decimal.
 *
 * @see <a href="http://en.wikipedia.org/wiki/Repeating_decimal">Repeating_decimal</a>.
 */
public class RepeatingDecimalTest {

    @Test
    public void itShouldNotBeRepeatingDecimal() throws Exception {
        assertFalse("1 divided by 2 should not produce repeating decimal", isRepeatingDecimal(1, 2));
    }

    private boolean isRepeatingDecimal(int dividend, int divisor) {
        return false;
    }

}
