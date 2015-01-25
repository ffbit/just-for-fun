package com.ffbit.fun.integer;

public class FastPower {

    public int pow(int x, int n) {
        int result = 1;

        while (n > 0) {
            if (n % 2 != 0) {
                result = result * x;
            }

            x = x * x;
            n = n / 2;
        }

        return result;
    }

}
