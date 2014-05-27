package com.ffbit.fun.array;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static junitparams.JUnitParamsRunner.$;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Find an index in an array so that the sum of elements on its left is equal to the one on its right.
 */
@RunWith(JUnitParamsRunner.class)
public class ArrayElementsEqualSumIndexTest {

    @Test
    @Parameters
    public void itShouldFindIndex(List<Integer> stack, int needle) throws Exception {
        assertThat(findEqualSumIndex(stack), is(needle));
    }

    @Test
    @Parameters
    public void itShouldNotFindIndex(List<Integer> stack) throws Exception {
        assertThat(findEqualSumIndex(stack), is(-1));
    }

    public int findEqualSumIndex(Integer[] array) {
        int sum = 0;

        for (int e : array) {
            sum += e;
        }

        int remainder = sum;

        for (int i = 0; i < array.length; i++) {
            remainder -= array[i];

            if (remainder * 2 == sum) {
                return i + 1;
            }
        }

        return -1;
    }

    public int findEqualSumIndex(List<Integer> list) {
        return findEqualSumIndex(list.toArray(new Integer[list.size()]));
    }

    private Object[] parametersForItShouldFindIndex() {
        return $(
                $(Arrays.asList(1, 1), 1),
                $(Arrays.asList(1, 1, 1, 1), 2),
                $(Arrays.asList(2, 1, 1), 1),
                $(Arrays.asList(1, 2, 3, -10, 0, 6), 1),
                $(Arrays.asList(0, 0, 0, 0), 1)
        );
    }

    private Object[] parametersForItShouldNotFindIndex() {
        return $(
                $(Arrays.asList()),
                $(Arrays.asList(1, 1, 1)),
                $(Arrays.asList(2, 1))
        );
    }

}
