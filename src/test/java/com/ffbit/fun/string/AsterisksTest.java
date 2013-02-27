package com.ffbit.fun.string;

import org.junit.Test;

public class AsterisksTest {

    @Test
    public void testAsterisks() throws Exception {
        asterisks("abc");
    }

    private void asterisks(final String origin) {
        int length = origin.length();
        int number = (1 << length) - 1;

        while (number >= 0) {
            char[] chars = origin.toCharArray();

            for (int i = 0; i < length; i++) {
                int shift = length - i - 1;
                if ((number >> shift & 1) == 0) {
                    chars[i] = '*';
                }
            }

            System.out.println(new String(chars));

            number--;
        }
    }

}
