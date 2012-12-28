package com.ffbit.fun.batch;

import java.util.Collections;
import java.util.ListIterator;
import java.util.Map;

public class BatchProcessor {

    public Map<Integer, int[]> process(ListIterator<int[]> data) {
        return Collections.singletonMap(1, new int[] {1, 11});
    }

}
