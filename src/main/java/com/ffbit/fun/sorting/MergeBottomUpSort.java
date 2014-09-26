package com.ffbit.fun.sorting;

import java.util.Arrays;

public class MergeBottomUpSort implements Sort {

    @Override
    public int[] sort(int[] source) {
        int[] auxiliary = Arrays.copyOf(source, source.length);
        mergesort(source, new int[source.length]);

        return source;
    }

    private void mergesort(int[] source, int[] auxiliary) {
        int N = source.length;
        for (int n = 1; n < N; n += n) {
            for (int i = 0; i < N - n; i += 2 * n) {
                int lo = i;
                int middle = lo + n - 1;
                int hi = Math.min(i + 2 * n, N) - 1;
                merge(source, lo, middle, hi, auxiliary);
            }
        }
    }

    private void merge(int[] source, int lo, int middle, int hi, int[] auxiliary) {
        System.arraycopy(source, lo, auxiliary, lo, hi - lo + 1);

        int i = lo;
        int j = middle + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > middle) {
                source[k] = auxiliary[j++];
            } else if (j > hi) {
                source[k] = auxiliary[i++];
            } else if (auxiliary[i] <= auxiliary[j]) {
                source[k] = auxiliary[i++];
            } else {
                source[k] = auxiliary[j++];
            }
        }
    }

}
