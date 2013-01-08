package com.ffbit.fun.array;

import java.util.Arrays;

public class SortedMatrixToSortedArray {

    public static void main(String... args) {
        int[][] matrix = {
                {2, 5, 7, 9, 14, 16},
                {3, 6, 8, 10, 15, 21},
                {4, 7, 9, 15, 22, 35},
                {7, 8, 9, 22, 40, 58}
        };

        int[] result = mergeAndSort(matrix);
        int[] expected = {2, 3, 4, 5, 6, 7, 8, 9, 10, 14, 15, 16, 21, 22, 35,
                40, 58};

        System.out.printf("result:   %s%n", Arrays.toString(result));
        System.out.printf("expected: %s%n", Arrays.toString(expected));
    }

    private static int[] mergeAndSort(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }

        int[] result = matrix[0];

        for (int i = 1; i < matrix.length; i++) {
            result = mergeAndSort(result, matrix[i]);
        }

        return result;
    }

    private static int[] mergeAndSort(int[] x, int[] y) {
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

    private static int findDistinctLength(int[] x, int[] y) {
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
