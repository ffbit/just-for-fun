package com.ffbit.fun.search;

public class BinarySearch {

    public int search(int[] stack, int needle) {
        int lo = 0;
        int hi = stack.length - 1;

        while (lo <= hi) {
            int middle = lo + (hi - lo) / 2;

            if (stack[middle] == needle) {
                return middle;
            } else if (stack[middle] < needle) {
                lo = middle + 1;
            } else {
                hi = middle - 1;
            }
        }

        return -(lo + 1);
    }

}
