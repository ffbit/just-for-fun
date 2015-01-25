package com.ffbit.fun.array;

/**
 * @see <a href="http://en.wikipedia.org/wiki/Maximum_subarray_problem">Maximum subarray problem</a>
 */
public class MaxSubArraySum {

    public int find(int[] array) {
        int maxSoFar = 0;
        int maxEndingHere = 0;

        for (int e : array) {
            maxEndingHere = Math.max(0, maxEndingHere + e);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }

        return maxSoFar;
    }

}
