package com.ffbit.fun.batch;

import java.util.Arrays;
import java.util.ListIterator;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertThat;

public class BatchProcessorTest {

    private ListIterator<int[]> data;
    private BatchProcessor batchProcessor;
    private Map<Integer, int[]> result;

    @Before
    public void setUp() throws Exception {
        batchProcessor = new BatchProcessor();
        data = Arrays.asList(
                new int[]{1, 1},
                new int[]{1, 11},
                new int[]{2, 2},
                new int[]{2, 22},
                new int[]{2, 222},
                new int[]{3, 3}
        ).listIterator();
        result = batchProcessor.process(data);
    }

    @Test
    public void itShouldHaveExpectedEntryForOne() throws Exception {
        assertThat(result, hasEntry(1, new int[]{1, 11}));
    }

}
