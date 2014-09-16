package com.ffbit.fun.sorting;

public class SelectionSort implements Sort {

    @Override
    public int[] sort(int[] source) {
        for (int i = 0; i < source.length; i++) {
            int min = i;
            for (int j = i + 1; j < source.length; j++) {
                if (source[min] > source[j]) {
                    min = j;
                }
            }

            swap(source, i, min);
        }

        return source;
    }

    private void swap(int[] source, int i, int min) {
        int tmp = source[i];
        source[i] = source[min];
        source[min] = tmp;
    }

}
