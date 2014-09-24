package com.ffbit.fun.sorting;

import java.util.Arrays;

public class MergeBottomUpSort implements Sort {

    @Override
    public int[] sort(int[] source) {
        int[] auxiliary = Arrays.copyOf(source, source.length);
        mergesort(source, 0, source.length, auxiliary);

        return source;
    }

    private void mergesort(int[] source, int lo, int hi, int[] auxiliary) {
        if (hi - lo == 1) {
            return;
        }

        int middle = lo + (hi - lo) / 2;
        mergesort(source, lo, middle, auxiliary);
        mergesort(source, middle + 1, hi, auxiliary);
        System.arraycopy(source, lo, auxiliary, lo, hi - lo);
        merge(source, lo, middle, hi, auxiliary);
    }

    private void merge(int[] source, int lo, int middle, int hi, int[] auxiliary) {
        int i = lo;
        int j = middle;
        for (int k = lo; k < hi; k++) {
            if (i == middle) {
                source[k] = auxiliary[++j];
            } else if (j == hi) {
                source[k] = auxiliary[i++];
            } else if (auxiliary[i] <= auxiliary[j]) {
                source[k] = auxiliary[i++];
            } else {
                source[k] = auxiliary[++j];
            }
        }
    }

}
