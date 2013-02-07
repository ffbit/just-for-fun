package com.ffbit.fun.domino;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DominoTrainTest {

    @Test
    public void test() throws Exception {
        HashMap<Integer, ArrayList<Integer>> graph = buildGraph(getInput());

        println(graph);
        buildTrain(graph.keySet(), graph, new LinkedList<Integer>());


    }

    private void buildTrain(Set<Integer> startVertexes, HashMap<Integer, ArrayList<Integer>> graph, List<Integer> train) {
        for (Integer start : startVertexes) {
            List<Integer> localTrain = new LinkedList<Integer>(train);
            localTrain.add(start);

            for (Integer end : graph.get(start)) {
                List<Integer> localTrain2 = new LinkedList<Integer>(localTrain);
                // ArrayList<int[]> localTrain = new ArrayList<int[]>(train);
                localTrain2.add(end);
                println("localTrain" + localTrain);
                println(localTrain2);
                println(start + "->" + end);
                HashMap<Integer, ArrayList<Integer>> localGraph = removeDomino(graph, start, end);

                if (localGraph.containsKey(end)) {
                    buildTrain(new HashSet<Integer>(localGraph.get(end)), localGraph, localTrain);
                } else {
                    println("end");
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
                // {3, 4}
        };
    }


    private void println(Object o) {
        System.out.println(o);
    }

}
