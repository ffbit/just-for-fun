package com.ffbit.fun.domino;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class DominoTrainTest {
    int counter = 0;

    @Test
    public void test() throws Exception {
        Map<Integer, Set<Integer>> graph = buildGraph(getInput());

        println("original: " + graph);
        buildTrain(graph);

        println("counter = " + counter);
    }

    private void buildTrain(Map<Integer, Set<Integer>> graph) {
        for (Integer start : graph.keySet()) {
            buildTrain(start, graph, new LinkedList<int[]>());
        }
    }

    private void buildTrain(Integer start, Map<Integer, Set<Integer>> graph,
                            List<int[]> train) {
        for (Integer end : graph.get(start)) {
            List<int[]> localTrain = new LinkedList<int[]>(train);
            localTrain.add(new int[]{start, end});

            Map<Integer, Set<Integer>> localGraph = removeDomino(graph, start, end);

            if (localGraph.containsKey(end)) {
                buildTrain(end, localGraph, localTrain);
            } else {
                counter++;
                // println(Arrays.deepToString(localTrain.toArray()));
            }
        }
    }

    private Map<Integer, Set<Integer>> removeDomino(Map<Integer, Set<Integer>> graph,
                                                    Integer key, Integer value) {
        Map<Integer, Set<Integer>> localGraph = new HashMap<Integer, Set<Integer>>(graph);
        removeVertexes(localGraph, key, value);
        removeVertexes(localGraph, value, key);

        return localGraph;
    }

    private void removeVertexes(Map<Integer, Set<Integer>> graph, Integer key,
                                Integer value) {
        if (!graph.containsKey(key)) {
            return;
        }

        Set<Integer> values = new HashSet<Integer>(graph.get(key));
        values.remove(value);

        if (values.isEmpty()) {
            graph.remove(key);
        } else {
            graph.put(key, values);
        }
    }

    private Map<Integer, Set<Integer>> buildGraph(int[][] dominoes) {
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();

        for (int[] domino : dominoes) {
            int first = domino[0];
            int second = domino[1];

            if (!graph.containsKey(first)) {
                graph.put(first, new HashSet<Integer>());
            }
            if (!graph.containsKey(second)) {
                graph.put(second, new HashSet<Integer>());
            }

            graph.get(first).add(second);
            graph.get(second).add(first);
        }

        return graph;
    }

    private int[][] getInput() {
        return generateInput(5, 15);
    }


    private void println(Object o) {
        System.out.println(o);
    }


    private int[][] generateInput(int base, int count) {
        int totalCount = ((base + 1) * base) / 2;
        println("totalCount = " + totalCount);
        List<int[]> deck = new ArrayList<int[]>(totalCount);

        for (int i = 0; i <= base; i++) {
            for (int j = i; j <= base; j++) {
                deck.add(new int[]{i, j});
            }
        }

        Set<int[]> result = new HashSet<int[]>(count);
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int randomIndex = random.nextInt(deck.size());
            result.add(deck.remove(randomIndex));
        }

        return result.toArray(new int[count][]);
    }

}
