package com.ffbit.fun.array;

import java.util.Arrays;

public class LongestCommonSubSequence {

    public int findCommonSubSequenceSize(char[] a, char[] b) {
        int[][] commonMatrix = buildCommonMatrix(a, b);

        return commonMatrix[a.length][b.length];
    }

    public char[] findCommonSubSequence(char[] a, char[] b) {
        int[][] commonMatrix = buildCommonMatrix(a, b);

        int commonLength = commonMatrix[a.length][b.length];
        char[] commonSubSequence = new char[commonLength];


        int i = a.length;
        int j = b.length;
        while (commonLength > 0) {
            int current = commonMatrix[i][j];
            int left = commonMatrix[i][j - 1];
            int diagonal = commonMatrix[i - 1][j - 1];
            int up = commonMatrix[i - 1][j];

            // get increased
            // turn diagonal
            if (current > diagonal
                    && diagonal == left
                    && diagonal == up) {
                commonSubSequence[commonLength - 1] = b[i - 1];
                commonLength--;
                i--;
                j--;
            }
            // turn left
            else if (current == left) {
                j--;
            }
            // turn up
            else if (current == up) {
                i--;
            }

        }

        return commonSubSequence;
    }

    private int[][] buildCommonMatrix(char[] a, char[] b) {
        int[][] commonMatrix = new int[b.length + 1][a.length + 1];

        for (int i = 1; i <= b.length; i++) {
            for (int j = 1; j <= a.length; j++) {
                int increase = 0;
                if (b[i - 1] == a[j - 1]) {
                    increase = 1;
                }

                commonMatrix[i][j] = Math.max(
                        Math.max(
                                commonMatrix[i - 1][j - 1],
                                commonMatrix[i - 1][j]
                        ),
                        commonMatrix[i][j - 1]
                ) + increase;
            }
        }

        logMatrix(a, b, commonMatrix);

        return commonMatrix;
    }

    private void logMatrix(char[] a, char[] b, int[][] commonMatrix) {
        System.out.println();
        System.out.print("[0]   ");
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < commonMatrix.length; i++) {
            if (i == 0) {
                System.out.print("   ");
            } else {
                System.out.print("[" + b[i - 1] + "]");
            }
            System.out.println(Arrays.toString(commonMatrix[i]));
        }
        System.out.println();
    }

}
