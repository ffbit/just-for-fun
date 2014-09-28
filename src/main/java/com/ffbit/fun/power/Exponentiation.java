package com.ffbit.fun.power;

public class Exponentiation {

    public int pow(int base, int exponent) {
        int result = 1;

        int b = base;
        int e = exponent;
        while (e > 0) {
            if (e % 2 != 0) {
                result *= b;
            }

            e >>= 1;
            b *= b;
        }

        return result;
    }

}
