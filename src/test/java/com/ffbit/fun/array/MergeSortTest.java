package com.ffbit.fun.array;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class MergeSortTest {
    private int[] source;
    private int[] expected;

    public MergeSortTest(int[] source, int[] expected) {
        this.source = source;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{}, new int[]{}},
                {new int[]{1}, new int[]{1}},
                {new int[]{1, 2}, new int[]{1, 2}},
                {new int[]{2, 1}, new int[]{1, 2}},
                {new int[]{2, 1, 3}, new int[]{1, 2, 3}},
                {new int[]{2, 1, 3, 0, 0, 0}, new int[]{0, 0, 0, 1, 2, 3}}
        });
    }

    @Test
    public void testMergeSort() throws Exception {
        assertThat(mergeSort(source), is(expected));
    }

    private int[] mergeSort(int[] source) {
        if (source.length <= 1) {
            return source;
        }

        int half = source.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(source, 0, half));
        int[] right = mergeSort(Arrays.copyOfRange(source, half, source.length));

        int i = 0;
        int j = 0;

        for (int n = 0; n < source.length; n++) {
            if (i == left.length) {
                source[n] = right[j++];
            } else if (j == right.length) {
                source[n] = left[i++];
            } else if (left[i] < right[j]) {
                source[n] = left[i++];
            } else {
                source[n] = right[j++];
            }
        }

        return source;
    }

    @Test
    public void testBubbleSort() throws Exception {
        assertThat(bubbleSort(source), is(expected));
    }

    private int[] bubbleSort(int[] source) {
        int n = source.length - 1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n - 1; j++) {
                if (source[j] > source[j + 1]) {
                    swap(source, j, j + 1);
                }
            }
        }

        return source;
    }

    @Test
    public void testSelectionSort() throws Exception {
        assertThat(selectionSort(source), is(expected));
    }

    private int[] selectionSort(int[] source) {
        for (int i = 0; i < source.length; i++) {
            int min = source[i];

            for (int j = i + 1; j < source.length; j++) {
                min = Math.min(min, source[j]);
            }

            source[i] = min;
        }

        return source;
    }

    @Test
    public void testInsertionSort() throws Exception {
        assertThat(insertionSort(source), is(expected));
    }

    private int[] insertionSort(int[] source) {
        for (int i = 1; i < source.length; i++) {
            int j = i;

            while (j < 1 && source[j] < source[j - 1]) {
                swap(source, j, j - 1);
                j--;
            }
        }

        return source;
    }

    @Test
    public void testShellSort() throws Exception {
        assertThat(shellSort(source), is(expected));
    }

    private int[] shellSort(int[] source) {
        int n = source.length;
        int step = n;

        while (step * 3 + 1 < n) {
            step = step * 3 + 1;
        }

        while (step / 2 > 0) {
            for (int i = step; i < n; i++) {
                if (source[i] < source[i - 1]) {
                    swap(source, i, i - 1);
                }
            }

            step = (step - 1) / 3;
        }

        return source;
    }

    @Test
    public void testQuickSort() throws Exception {
        assertThat(quickSort(source), is(expected));
    }

    private int[] quickSort(int[] source) {
        if (source.length > 0) {
            quickSort(source, 0, source.length - 1);
        }

        return source;
    }

    private void quickSort(int[] source, int low, int high) {
        int pivot = source[low + (high - low) / 2];

        int i = low;
        int j = high;

        while (i <= j) {
            while (source[i] < pivot) {
                i++;
            }

            while (source[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(source, i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(source, low, j);
        }
        if (high > i) {
            quickSort(source, i, high);
        }
    }

    @Test
    public void testSwap() throws Exception {
        int[] array = {1, 2};
        swap(array, 0, 1);

        assertThat(array, is(new int[]{2, 1}));
    }

    private void swap(int[] source, int i, int j) {
        int buf = source[i];
        source[i] = source[j];
        source[j] = buf;
    }

}
