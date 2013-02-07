package com.ffbit.fun.domino;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DominoTrainTest {

    @Test
    public void test() throws Exception {
        Map<Integer, List<Integer>> graph = buildGraph(getInput());

        println("original: " + graph);
        buildTrain(graph);
    }

    private void buildTrain(Map<Integer, List<Integer>> graph) {
        for (Integer start : graph.keySet()) {
            buildTrain(start, graph, new LinkedList<Integer>());
        }
    }

    private void buildTrain(Integer start, Map<Integer, List<Integer>> graph, List<Integer> train) {
        for (Integer end : graph.get(start)) {
            println(start + " -> " + end);

            Map<Integer, List<Integer>> localGraph = removeDomino(graph, start, end);

            if (localGraph.containsKey(end)) {
                   buildTrain(end, localGraph, train);
            } else {
                println("end");
            }






//            for (Integer end : graph.get(start)) {
//                List<Integer> localTrain = new LinkedList<Integer>(train);
//                println(start + " -> " + end);
//                localTrain.add(start);
//                localTrain.add(end);
//
//                Map<Integer, List<Integer>> localGraph = removeDomino(graph, start, end);
//
//                if (localGraph.containsKey(end)) {
//                    buildTrain(localGraph.get(end), localGraph, localTrain);
//                } else {
//                    println("end:" + localTrain);
//                }
//            }
        }
    }

    private Map<Integer, List<Integer>> removeDomino(Map<Integer, List<Integer>> graph, Integer key, Integer value) {
        Map<Integer, List<Integer>> localGraph = new HashMap<Integer, List<Integer>>(graph);
        removeVertexes(localGraph, key, value);
        removeVertexes(localGraph, value, key);

//        println(localGraph + " " + key + " " + value);


        return localGraph;
    }

    private void removeVertexes(Map<Integer, List<Integer>> graph, Integer key, Integer value) {
        List<Integer> list = new LinkedList<Integer>(graph.get(key));
        list.remove((Object) value);

        if (list.isEmpty()) {
            graph.remove(key);
        } else {
            graph.put(key, list);
        }
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] dominoes) {
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

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
