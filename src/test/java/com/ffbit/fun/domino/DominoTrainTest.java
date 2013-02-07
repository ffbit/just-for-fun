package com.ffbit.fun.domino;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class DominoTrainTest {

    @Test
    public void test() throws Exception {
        HashMap<Integer, ArrayList<Integer>> graph = buildGraph(getInput());

        println(graph);
        buildTrain(graph.keySet(), graph, new ArrayList<int[]>());


    }

    private void buildTrain(Set<Integer> startVertexes, HashMap<Integer, ArrayList<Integer>> graph, ArrayList<int[]> train) {
        for (Integer start : startVertexes) {
            for (Integer end : graph.get(start)) {
                ArrayList<int[]> localTrain = new ArrayList<int[]>(train);
                localTrain.add(new int[] {start, end});
                println(Arrays.deepToString(localTrain.toArray()));
                println(start + "->" + end);
                HashMap<Integer, ArrayList<Integer>> localGraph = removeDomino(graph, start, end);

                if (localGraph.containsKey(end)) {
                    buildTrain(localGraph.get(end), localGraph, localTrain);
                }



            }
        }
    }

    private HashMap<Integer, ArrayList<Integer>> removeDomino(HashMap<Integer, ArrayList<Integer>> graph, Integer key, Integer value) {
        HashMap<Integer, ArrayList<Integer>> localGraph = (HashMap<Integer, ArrayList<Integer>>) graph.clone();
        removeVertexes(localGraph, key, value);
        removeVertexes(localGraph, value, key);

        return localGraph;
    }

    private void removeVertexes(HashMap<Integer, ArrayList<Integer>> graph, Integer key, Integer value) {
        ArrayList<Integer> list = (ArrayList<Integer>) graph.get(key).clone();
        list.remove((Object) value);

        if (list.isEmpty()) {
            graph.remove(key);
        } else {
            graph.put(key, list);
        }
    }

    private HashMap<Integer, ArrayList<Integer>> buildGraph(int[][] dominoes) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();

        for (int[] domino : dominoes) {
            int first = domino[0];
            int second = domino[1];

            if (!graph.containsKey(first)) {
                graph.put(first, new ArrayList<Integer>());
            }
            if (!graph.containsKey(second)) {
                graph.put(second, new ArrayList<Integer>());
            }

            graph.get(first).add(second);
            graph.get(second).add(first);
        }

        return graph;
    }

    private int[][] getInput() {
        return new int[][]{
                {1, 2},
                {2, 3},
                {3, 4}
        };
    }


    private void println(Object o) {
        System.out.println(o);
    }

}
