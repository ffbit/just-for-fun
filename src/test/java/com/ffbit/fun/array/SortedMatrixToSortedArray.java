package com.ffbit.fun.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortedMatrixToSortedArray {

    @Test
    public void testEmptyMatrix() throws Exception {
        int[][] matrix = {};
        int[] expected = {};
        assertThat(mergeAndSort(matrix), is(expected));
    }

    private int[] mergeAndSort(int[][] matrix) {
        return new int[]{};
    }

    @Test
    public void testMergeTwoEmptySortedArrays() throws Exception {
        int[] x = {};
        int[] y = {};
        int[] expected = {};

        assertThat(mergeAndSort(x, y), is(expected));
    }

    @Test
    public void testMergeTwoSortedArrays() throws Exception {
        int[] x = {0, 1};
        int[] y = {1, 2};
        int[] expected = {0, 1, 2};

        assertThat(mergeAndSort(x, y), is(expected));
    }

    private int[] mergeAndSort(int[] x, int[] y) {
        int n = findDistinctLength(x, y);
        int[] result = new int[n];

        for (int k = 0, i = 0, j = 0; k < n; k++) {
            if (i == x.length) {
                result[k] = y[j++];
            } else if (j == y.length) {
                result[k] = x[i++];
            } else if (x[i] < y[j]) {
                result[k] = x[i++];
            } else if (x[i] > y[j]) {
                result[k] = y[j++];
            } else {
                result[k] = x[i];
                i++;
                j++;
            }
        }

        return result;
    }

    @Test
    public void testFindDistinctLength() throws Exception {
        int[] x = {0, 1};
        int[] y = {1, 2, 3};

        assertThat(findDistinctLength(x, y), is(4));
    }

    private int findDistinctLength(int[] x, int[] y) {
        int i = 0;
        int j = 0;
        int n = 0;

        while (i < x.length && j < y.length) {
            if (x[i] < y[j]) {
                i++;
            } else if (x[i] > y[j]) {
                j++;
            } else {
                i++;
                j++;
            }

            n++;
        }

        return n + x.length - i + y.length - j;
    }

}
