package com.ffbit.fun.sorting;

public class QuickSort {
    public int[] sort(int[] source) {
        quicksort(source, 0, source.length - 1);

        return source;
    }

    private void quicksort(int[] source, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int pivot = partition(source, lo, hi);
        quicksort(source, lo, pivot - 1);
        quicksort(source, pivot + 1, hi);
    }

    private int partition(int[] source, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int value = source[lo];

        while (true) {
            while (source[++i] < value) {
                if (i == hi) {
                    break;
                }
            }

            while (source[--j] > value) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            swap(source, i, j);
        }

        swap(source, lo, j);
        return j;
    }

    private void swap(int[] source, int i, int j) {
        int tmp = source[i];
        source[i] = source[j];
        source[j] = tmp;
    }
}
