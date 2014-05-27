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

    public int findEqualSumIndex(List<Integer> list) {
        int sum = 0;

        for (Integer e : list) {
            sum += e;
        }

        int remainder = sum;
        int index = 0;
        for (Integer e : list) {
            index++;
            remainder -= e;

            if (remainder * 2 == sum) {
                return index;
            }
        }

        return -1;
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
