package com.ffbit.fun.batch;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertThat;

public class BatchProcessorTest {

    private List<int[]> tuples;
    private BatchProcessor batchProcessor;
    private Map<Integer, List<Integer>> result;

    @Before
    public void setUp() throws Exception {
        batchProcessor = new BatchProcessor();
        tuples = Arrays.asList(
                new int[]{1, 1},
                new int[]{1, 11},
                new int[]{2, 2},
                new int[]{2, 22},
                new int[]{2, 222},
                new int[]{3, 3}
        );
        result = batchProcessor.process(tuples);
    }

    @Test
    public void itShouldHaveExpectedEntryForOne() throws Exception {
        assertThat(result, hasEntry(1, Arrays.asList(1, 11)));
    }

    @Test
    public void itShouldHaveExpectedEntryForTwo() throws Exception {
        assertThat(result, hasEntry(2, Arrays.asList(2, 22, 222)));
    }

    @Test
    public void itShouldHaveExpectedEntryForThree() throws Exception {
        assertThat(result, hasEntry(3, Arrays.asList(3)));
    }

}
