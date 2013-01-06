package com.ffbit.fun.array;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PermutationTest {
    private int[] array;
    private boolean permutation;

    public PermutationTest(int[] array, boolean permutation) {
        this.array = array;
        this.permutation = permutation;
    }

    @Parameters
    public static Collection<Object[]> init() {
        Object[][] data = { { new int[] {}, true }, //
                { new int[] { 0 }, true }, //
                { new int[] { 1 }, false }, //
                { new int[] { 1, 0 }, true }, //
                { new int[] { 1, 4, 3, 0, 2, 5 }, true }, //
                { new int[] { 1, 1, 4, 4, 4, 0, 0, 3, 0, 2, 5 }, false }, //
                { new int[] { 0, 3, 1 }, false }, //
                { new int[] { 2 }, false }, //
                { new int[] { -1 }, false }, //
        };

        return Arrays.asList(data);
    }

    @Test
    public void testPermutation() throws Exception {
        assertThat(isPermutation(array), is(permutation));
    }

    private boolean isPermutation(int[] a) {
        final int length = a.length;

        int element;
        int buffer;

        for (int i = 0; i < length; i++) {
            element = a[i];

            // An element is already on its ordinal place.
            if (element == i) {
                continue;
            }

            if (element < 0 || element >= length) {
                return false;
            }

            buffer = a[element];

            // This condition can be merged with the previous one.
            if (buffer < 0 || buffer >= length) {
                return false;
            }

            // Duplicate is detected.
            if (element == buffer) {
                return false;
            }

            // Put the element on its ordinal place.
            a[element] = element;
            // Put buffer's element on the current place.
            a[i] = buffer;
            // And try to find its place during next loop iteration.
            i--;
        }

        return true;
    }

}
