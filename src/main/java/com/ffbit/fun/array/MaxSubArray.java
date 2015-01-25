package com.ffbit.fun.array;

import java.util.Arrays;

/**
 * @see <a href="https://sites.google.com/site/computationalthinking/kadanealgorithm"></a>
 */
public class MaxSubArray {

    public int[] find(int[] array) {
        int maxLow = 0;
        int maxHigh = 0;

        int maxSoFar = array[0];
        int maxEndingHere = array[0];

        int j = 0;
        for (int i = 0; i < array.length; i++) {
            maxEndingHere += array[i];

            if (maxEndingHere > maxSoFar) {
                maxLow = j;
                maxHigh = i;
                maxSoFar = maxEndingHere;
            } else {
                maxEndingHere = 0;
                j = i + 1;
            }
        }

        return Arrays.copyOfRange(array, maxLow, maxHigh + 1);
    }

}
