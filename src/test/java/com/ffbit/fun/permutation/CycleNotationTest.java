package com.ffbit.fun.permutation;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Build Cycle Notation from a Permutation.
 *
 * @see <a href="http://en.wikipedia.org/wiki/Permutation">Permutation</a>
 * @see <a href="http://en.wikipedia.org/wiki/Cycle_notation">Cycle notation</a>
 * @see <a href="http://en.wikipedia.org/wiki/Cyclic_permutation">Cyclic permutation</a>.
 */
public class CycleNotationTest {

    @Test
    public void cyclePermutation() throws Exception {
        int[] origin = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] permutation = {4, 5, 7, 6, 8, 2, 1, 3};

        assertThat(toCycleNotation(origin, permutation), is("(1 4 6 2 5 8 3 7)"));
    }

    private String toCycleNotation(int[] origin, int[] permutation) {
        Map<Integer, Integer> mapping = new LinkedHashMap<Integer, Integer>(origin.length, 1);
        for (int i = 0; i < origin.length; i++) {
            mapping.put(origin[i], i);
        }

        StringBuilder result = new StringBuilder();

        Integer key = null;
        Integer value;
        for (int i = 0; i < origin.length; i++) {
            if (key == null && !mapping.isEmpty()) {
                key = mapping.values().iterator().next();
                value = mapping.keySet().iterator().next();
                result.append('(')
                        .append(value);
            } else {
                value = permutation[key];
                key = mapping.remove(value);
                result.append(' ')
                        .append(value);
            }
        }

        if (result.length() != 0) {
            result.append(')');
        }

        return result.toString();
    }

}
