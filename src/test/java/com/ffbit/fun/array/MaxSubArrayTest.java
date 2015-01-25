package com.ffbit.fun.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MaxSubArrayTest {
    private MaxSubArray maxSubArrayFinder = new MaxSubArray();

    @Test
    public void itShouldFindMaxSubArray() {
        int[] array = {1, -4, 6, 7, -10, 10, -20, 4, 8};

        assertThat(maxSubArrayFinder.find(array), is(new int[]{6, 7}));
    }


    @Test
    public void itShouldFindMaxSubArrayInAllPositive() {
        int[] array = {5, 6, 4};

        assertThat(maxSubArrayFinder.find(array), is(new int[]{5, 6, 4}));
    }

    @Test
    public void itShouldFindMaxSubArrayInAllNegative() {
        int[] array = {-100, -20, -42, -1, -4, -60};

        assertThat(maxSubArrayFinder.find(array), is(new int[]{-1}));
    }

}
