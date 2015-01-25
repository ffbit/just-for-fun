package com.ffbit.fun.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaxSubArraySumTest {
    private MaxSubArraySum maxSubArraySumFinder = new MaxSubArraySum();

    @Test
    public void itShouldFindMaxSubArraySum() {
        int[] array = {1, -4, 6, 7, -10, 10, -20, 4, 8};

        assertThat(maxSubArraySumFinder.find(array), is(13));
    }

}
