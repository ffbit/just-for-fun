package com.ffbit.fun.bitwise;

public class SingularOneBitFinder {

    public int findSingularBit(int number) {
        int lo = 0;
        int hi = 32;

        while (lo <= hi) {
            int middle = lo + (hi - lo) / 2;
            int i = number >>> middle;

            if (i == 1) {
                return middle;
            } else if (i == 0) {
                hi = middle - 1;
            } else {
                lo = middle + 1;
            }
        }

        return -1;
    }

}
