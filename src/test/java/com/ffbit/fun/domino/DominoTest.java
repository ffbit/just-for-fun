package com.ffbit.fun.domino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class DominoTest {

    @Test
    public void testDomino() throws Exception {
        int n = 12;
        int size = n + 1;
        int count = 15;
        List<int[]> dominoes = generateDominoes(n, count);

        System.out.println("Dominoes: "
                + Arrays.deepToString(dominoes.toArray()));

        int[][] matrix = new int[size][size];
        boolean[] faces = new boolean[size];

        for (int[] domino : dominoes) {
            int i = domino[0];
            int j = domino[1];

            matrix[i][j] = 1;
            matrix[j][i] = 1;

            faces[i] = true;
            faces[j] = true;
        }

        printMatrix(matrix);

        int[] emptyTrain = new int[count + 1 + 1];
        int[] maxTrain = emptyTrain.clone();
        int trainLengthIndex = emptyTrain.length - 1;

        for (int i = 0; i < size; i++) {
            if (faces[i]) {
                int[] train = emptyTrain.clone();
                train[0] = i;

                train = backtrack(matrix, i, train);

                if (maxTrain[trainLengthIndex] < train[trainLengthIndex]) {
                    maxTrain = train;
                }

                if (maxTrain[trainLengthIndex] == count) {
                    break;
                }
            }
        }

        int maxLength = maxTrain[trainLengthIndex];
        System.out.print("the longest train of length " + maxLength + ": ");
        for (int i = 0; i < maxLength; i++) {
            System.out.print("[" + maxTrain[i] + ":" + maxTrain[i + 1] + "]");
        }
    }

    private int[] backtrack(int[][] matrix, int start, int[] train) {
        int trainLengthIndex = train.length - 1;
        int trainLength = train[trainLengthIndex];
        int[] row = matrix[start];

        int[] localMaxTrain = train;

        for (int i = 0; i < row.length && trainLength < train.length; i++) {
            if (row[i] != 0) {
                int[] localTrain = train.clone();
                int localTrainLength = trainLength + 1;
                localTrain[trainLengthIndex] = localTrainLength;
                localTrain[localTrainLength] = i;
                matrix[start][i] = 0;
                matrix[i][start] = 0;

                localTrain = backtrack(matrix, i, localTrain);

                if (localMaxTrain[trainLengthIndex] < localTrain[trainLengthIndex]) {
                    localMaxTrain = localTrain;
                }

                matrix[start][i] = 1;
                matrix[i][start] = 1;
            }
        }
        return localMaxTrain;
    }

    private void printTrain(int[] train) {
        System.out.println("train: " + Arrays.toString(train) + " "
                + train[train.length - 1]);
    }

    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    private List<int[]> generateDominoes(int size, int count) {
        assert size > 0;
        assert count > 0;
        assert count <= (size + 1) * size / 2;

        List<int[]> deck = new ArrayList<int[]>();

        for (int i = 0; i <= size; i++) {
            for (int j = i; j <= size; j++) {
                deck.add(new int[] { i, j });
            }
        }

        List<int[]> result = new ArrayList<int[]>();
        Random random = new Random(System.nanoTime());

        for (int i = 0; i < count; i++) {
            int randomIndex = random.nextInt(deck.size());
            result.add(deck.remove(randomIndex));
        }

        return result;
    }
}