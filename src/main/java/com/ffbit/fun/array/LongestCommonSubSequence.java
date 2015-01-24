package com.ffbit.fun.array;

import java.util.Arrays;

public class LongestCommonSubSequence {

    public int findCommonSubSequenceSize(char[] a, char[] b) {
        int[][] matrix = new int[a.length + 1][b.length + 1];

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                int increase = 0;
                if (a[i - 1] == b[j - 1]) {
                    increase = 1;
                }

                matrix[i][j] = Math.max(
                        Math.max(matrix[i - 1][j - 1], matrix[i - 1][j]),
                        matrix[i][j - 1]
                ) + increase;
            }
        }

        return matrix[a.length][b.length];
    }

}
