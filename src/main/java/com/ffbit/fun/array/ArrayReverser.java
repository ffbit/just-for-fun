package com.ffbit.fun.array;

import java.util.Arrays;

/**
 * Contains a method for reversing arrays.
 */
public class ArrayReverser {

    /**
     * Reverses the order of the elements of the specified array.
     *
     * @param source
     *            the array whose elements are to be reversed.
     * @return a copy of specified array with the reversed order of the elements.
     */
    public int[] reverse(int[] source) {
        int[] result = copy(source);

        int length = result.length;
        int half = length / 2;

        for (int i = 0; i < half; i++) {
            swap(result, i, length - i - 1);
        }

        return result;
    }

    private int[] copy(int[] source) {
        return Arrays.copyOf(source, source.length);
    }

    private void swap(int[] array, int i, int j) {
        int buffer = array[i];
        array[i] = array[j];
        array[j] = buffer;
    }

}
