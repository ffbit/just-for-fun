package com.ffbit.fun.sorting;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class KthMaxStatisticsTest {
    private KthMaxStatistics statisticsFinder = new KthMaxStatistics();

    @Test
    @Parameters({
            "1,  9",
            "2,  8",
            "3,  7",
            "4,  6",
            "5,  5",
            "6,  5",
            "7,  4",
            "8,  3",
            "9,  2",
            "10, 1",
            "11, 0",
    })
    public void itShouldFindKthMaxStatistics(int k, int value) {
        int[] array = {9, 5, 2, 8, 3, 4, 1, 5, 7, 0, 6};

        assertThat(statisticsFinder.findKthMaxStatistics(array, k), is(value));
    }

}
