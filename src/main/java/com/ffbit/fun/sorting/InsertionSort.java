package com.ffbit.fun.sorting;

public class InsertionSort {

    public int[] sort(int[] source) {
        for (int i = 1; i < source.length; i++) {
            int j = i;
            while (j > 0 && source[j] < source[j - 1]) {
                swap(source, j, --j);
            }
        }

        return source;
    }

    private void swap(int[] source, int j, int i) {
        int tmp = source[i];
        source[i] = source[j];
        source[j] = tmp;
    }

}
