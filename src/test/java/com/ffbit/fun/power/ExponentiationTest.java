package com.ffbit.fun.power;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ExponentiationTest {
    private Exponentiation exponentiation = new Exponentiation();

    @Test
    @Parameters({
            "2, 0, 1",
            "2, 1, 2",
            "2, 2, 4",
            "2, 3, 8",
            "2, 4, 16",
            "2, 5, 32",
            "2, 6, 64",
            "2, 7, 128",
            "2, 8, 256",
            "2, 9, 512",
            "2, 10, 1024",
            "2, 11, 2048",
            "2, 12, 4096",
            "2, 13, 8192",
            "2, 14, 16384",
            "2, 15, 32768",
            "2, 16, 65536",
            "2, 17, 131072",
            "2, 18, 262144",
            "2, 19, 524288",
            "2, 20, 1048576",
            "2, 21, 2097152",
            "2, 22, 4194304",
            "2, 23, 8388608",
            "2, 24, 16777216",
            "2, 25, 33554432",
            "2, 26, 67108864",
            "2, 27, 134217728",
            "2, 28, 268435456",
            "2, 29, 536870912",
            "2, 30, 1073741824",
    })
    public void itShouldPowOfTwo(int base, int exponent, int expectedResult) {
        assertThat(exponentiation.pow(base, exponent), is(expectedResult));
    }

    @Test
    @Parameters({
            "3, 0, 1",
            "3, 1, 3",
            "3, 2, 9",
            "3, 3, 27",
            "3, 4, 81",
            "3, 5, 243",
            "3, 6, 729",
            "3, 7, 2187",
            "3, 8, 6561",
            "3, 9, 19683",
            "3, 10, 59049",
            "3, 11, 177147",
            "3, 12, 531441",
            "3, 13, 1594323",
            "3, 14, 4782969",
            "3, 15, 14348907",
            "3, 16, 43046721",
            "3, 17, 129140163",
            "3, 18, 387420489",
            "3, 19, 1162261467"
    })
    public void itShouldPowOfThree(int base, int exponent, int expectedResult) {
        assertThat(exponentiation.pow(base, exponent), is(expectedResult));
    }

}
