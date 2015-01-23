package com.ffbit.fun.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LongestIncreasingSubSequenceTest {
    private LongestIncreasingSubSequence subSequenceFinder
            = new LongestIncreasingSubSequence();

    @Test
    public void itShouldFindLongestIncreasingSubSequence() {
        int[] sequence = {7, 2, 6, 3, 7, 4, 1};

        assertThat(subSequenceFinder.find(sequence), is(new int[]{2, 3, 4}));
    }

}
