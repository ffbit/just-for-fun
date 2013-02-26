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
public class BinarySearchTest {
    private int[] array;
    private int key;
    private int expectedIndex;

    public BinarySearchTest(int[] array, int key, int expectedIndex) {
        this.array = array;
        this.key = key;
        this.expectedIndex = expectedIndex;
    }

    @Parameters
    public static Collection<Object[]> init() {
        return Arrays.asList(new Object[][] {
                { new int[] {}, 0, -1 },

                { new int[] { 1 }, 0, -1 },
                { new int[] { 1 }, 1, 0 },
                { new int[] { 1 }, 2, -2 },

                { new int[] { 1, 2 }, 0, -1 },
                { new int[] { 1, 2 }, 1, 0 },
                { new int[] { 1, 2 }, 2, 1 },
                { new int[] { 1, 2 }, 3, -3 }
        });
    }

    @Test
    public void binarySearchTest() throws Exception {
        assertThat(binarySearch(array, key), is(expectedIndex));
    }

    private int binarySearch(int[] source, int needle) {
        int low = 0;
        int high = source.length - 1;

        while (low <= high) {
            int middle = low + ((high - low) >>> 1);

            if (source[middle] == needle) {
                return middle;  // key found
            } else if (source[middle] < needle) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return -(low + 1);  // key not found
    }

}
