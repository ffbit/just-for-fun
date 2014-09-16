package com.ffbit.fun.sorting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public abstract class SortTest {
    private Sort sort = getSort();

    private int[] source;
    private int[] sorted;

    public SortTest(int[] source, int[] sorted) {
        this.source = source;
        this.sorted = sorted;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                new Object[]{
                        new int[]{}, new int[]{}
                },
                new Object[]{
                        new int[]{1}, new int[]{1}
                },
                new Object[]{
                        new int[]{2, 1}, new int[]{1, 2}
                },
                new Object[]{
                        new int[]{2, 3, 1}, new int[]{1, 2, 3}
                },
                new Object[]{
                        new int[]{4, 2, 3, 1}, new int[]{1, 2, 3, 4}
                },
                new Object[]{
                        new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 4}
                },
                new Object[]{
                        new int[]{1, 5, 2, 4, 3}, new int[]{1, 2, 3, 4, 5}
                },
                new Object[]{
                        new int[]{6, 5, 4, 3, 2, 1}, new int[]{1, 2, 3, 4, 5, 6}
                },
        });
    }

    @Test
    public void itShouldSort() throws Exception {
        assertThat(sort.sort(source), is(source));
    }

    abstract Sort getSort();

}