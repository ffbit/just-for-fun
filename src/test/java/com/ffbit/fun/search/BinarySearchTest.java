package com.ffbit.fun.search;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class BinarySearchTest {
    private BinarySearch search = new BinarySearch();

    private int[] stack;
    private int needle;
    private int expectedIndex;

    public BinarySearchTest(int[] stack, int needle, int expectedIndex) {
        this.stack = stack;
        this.needle = needle;
        this.expectedIndex = expectedIndex;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                new Object[]{
                        new int[]{}, 0, -1
                },
                new Object[]{
                        new int[]{1}, 1, 0
                },
                new Object[]{
                        new int[]{1, 3}, 1, 0
                },
                new Object[]{
                        new int[]{1, 3}, 3, 1
                },
                new Object[]{
                        new int[]{1, 2, 3, 4, 5}, 1, 0
                },
                new Object[]{
                        new int[]{1, 2, 3, 4, 5}, 2, 1
                },
                new Object[]{
                        new int[]{1, 2, 3, 4, 5}, 3, 2
                },
                new Object[]{
                        new int[]{1, 2, 3, 4, 5}, 4, 3
                },
                new Object[]{
                        new int[]{1, 2, 3, 4, 5}, 5, 4
                },
                new Object[]{
                        new int[]{1, 2, 3, 4, 5}, 0, -1
                },
                new Object[]{
                        new int[]{1, 2, 3, 4, 5}, 6, -6
                },
        });
    }

    @Test
    public void itShouldSearch() throws Exception {
        assertThat(search.search(stack, needle), is(expectedIndex));
    }

}
