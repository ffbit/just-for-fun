package com.ffbit.fun.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class AsterisksTest {

    @Test
    public void testAsterisks() throws Exception {
        assertThat(asterisks("abc"), contains("abc", "ab*", "a*c", "a**", "*bc", "*b*", "**c", "***"));
    }

    private List<String> asterisks(final String origin) {
        int length = origin.length();
        int number = (1 << length) - 1;
        List<String> result = new ArrayList<String>(number);

        while (number >= 0) {
            char[] chars = origin.toCharArray();

            for (int i = 0; i < length; i++) {
                int shift = length - i - 1;
                if ((number >> shift & 1) == 0) {
                    chars[i] = '*';
                }
            }

            number--;
            result.add(new String(chars));
        }

        return result;
    }

}
