package com.ffbit.fun.integer;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void itShouldNotBeRepeatingDecimalWhenTwoNumberDivideWithoutRemainder() throws Exception {
        assertFalse("8 divided by 2 does not produce repeating decimal", isRepeatingDecimal(8, 2));
    }

    @Test
    public void itShouldBeRepeatingDecimal() throws Exception {
        assertTrue("5 divided by 3 should produce repeating decimal", isRepeatingDecimal(5, 3));
    }

    private boolean isRepeatingDecimal(int dividend, int divisor) {
        int mod = dividend % divisor;

        if (mod == 0) {
            return false;
        }

        int remainder = mod * 10;
        Set<Integer> mods = new HashSet<Integer>();
        
        do {
            mod = remainder % divisor;

            if (!mods.add(mod)) {
                return true;
            }
        } while (mod != 0);

        return false;
    }

}
