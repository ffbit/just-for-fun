package com.ffbit.fun.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LongestIncreasingSubSequenceTest {
    private LongestIncreasingSubSequence subSequenceFinder
            = new LongestIncreasingSubSequence();

    @Test
    public void itShouldFindLongestIncreasingSubSequenceOf3() {
        int[] sequence = {7, 2, 6, 3, 7, 4, 1};

        assertThat(subSequenceFinder.find(sequence), is(new int[]{2, 3, 4}));
    }

    @Test // Fails - a controversial example was found
    public void itShouldFindLongestIncreasingSubSequenceOf4() {
        int[] sequence = {7, 2, 6, 3, 7, 4, 1, 5};

        assertThat(subSequenceFinder.find(sequence), is(new int[]{2, 3, 4, 5}));
    }

}
