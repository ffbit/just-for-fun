package com.ffbit.fun.domino;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DominoTest {

    @Test
    public void testDomino() throws Exception {
        int maxFace = 12;
        int size = maxFace + 1;
        int count = 15;
        List<int[]> dominoes = generateDominoes(maxFace, count);

        System.out.println("Dominoes: " + Arrays.deepToString(dominoes.toArray()));

        int[][] graph = new int[size][size];
        boolean[] faces = new boolean[size];

        for (int[] domino : dominoes) {
            int i = domino[0];
            int j = domino[1];

            graph[i][j] = 1;
            graph[j][i] = 1;

            faces[i] = true;
            faces[j] = true;
        }

        printGraph(graph);

        int[] emptyTrain = new int[count + 1 + 1];
        int[] maxTrain = emptyTrain.clone();
        int trainLengthIndex = emptyTrain.length - 1;

        for (int i = 0; i < size; i++) {
            if (faces[i]) {
                int[] train = emptyTrain.clone();
                train[0] = i;

                buildTrain(graph, i, train, maxTrain);

//                if (maxTrain[trainLengthIndex] < train[trainLengthIndex]) {
//                    maxTrain = train;
//                }

                if (maxTrain[trainLengthIndex] == count) {
                    break;
                }
            }
        }

        int maxLength = maxTrain[trainLengthIndex];
        System.out.print("the longest train is of length " + maxLength + ": ");
        for (int i = 0; i < maxLength; i++) {
            System.out.print("[" + maxTrain[i] + ":" + maxTrain[i + 1] + "]");
        }
    }

    private void buildTrain(int[][] graph, int face, int[] train, int[] maxTrain) {
        int trainLengthIndex = train.length - 1;
        int trainLength = train[trainLengthIndex];
        int[] row = graph[face];

        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0) {
                int[] localTrain = train.clone();
                int localTrainLength = trainLength + 1;
                localTrain[trainLengthIndex] = localTrainLength;
                localTrain[localTrainLength] = i;
                graph[face][i] = 0;
                graph[i][face] = 0;

                buildTrain(graph, i, localTrain, maxTrain);

                if (maxTrain[trainLengthIndex] < trainLength) {
                    System.arraycopy(localTrain, 0, maxTrain, 0, maxTrain.length);
                }

                graph[face][i] = 1;
                graph[i][face] = 1;
            }
        }
    }

    private void printTrain(int[] train) {
        System.out.println("train: " + Arrays.toString(train) + " "
                + train[train.length - 1]);
    }

    private void printGraph(int[][] graph) {
        for (int[] row : graph) {
            System.out.println(Arrays.toString(row));
        }
    }

    private List<int[]> generateDominoes(int maxFace, int count) {
        assert maxFace > 0;
        assert count > 0;
        assert count <= (maxFace + 1) * maxFace / 2;

        List<int[]> deck = new ArrayList<int[]>();

        for (int i = 0; i <= maxFace; i++) {
            for (int j = i; j <= maxFace; j++) {
                deck.add(new int[]{i, j});
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