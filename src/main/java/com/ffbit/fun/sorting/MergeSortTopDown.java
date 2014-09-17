package com.ffbit.fun.sorting;

public class MergeSortTopDown implements Sort {

    @Override
    public int[] sort(int[] source) {
        mergesort(source, 0, source.length - 1, new int[source.length]);

        return source;
    }

    private void mergesort(int[] source, int lo, int hi, int[] auxiliary) {
        if (hi <= lo) {
            return;
        }

        int middle = lo + (hi - lo) / 2;
        mergesort(source, lo, middle, auxiliary);
        mergesort(source, middle + 1, hi, auxiliary);
        merge(source, lo, middle, hi, auxiliary);
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
