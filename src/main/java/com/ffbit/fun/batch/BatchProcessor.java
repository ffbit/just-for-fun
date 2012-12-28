package com.ffbit.fun.batch;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BatchProcessor {

    public Map<Integer, List<Integer>> process(List<int[]> tuples) {
        if (tuples.isEmpty()) {
            return Collections.<Integer, List<Integer>>emptyMap();
        }

        Map<Integer, List<Integer>> result = new HashMap<Integer, List<Integer>>();

        for (int[] tuple : tuples) {
            int key = tuple[0];
            int value = tuple[1];

            if (!result.containsKey(key)) {
                result.put(key, new LinkedList<Integer>());
            }

            result.get(key).add(value);
        }

        return result;
    }

}
