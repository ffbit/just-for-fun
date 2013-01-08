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
        return new int[] {};
    }

}
