package com.ffbit.fun.bitwise;

public class PowerOfTwoChecker {

    public boolean isPowerOfTwo(int i) {
        return i != 0 && (i - 1 & i) == 0;
    }

}
