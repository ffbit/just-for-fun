package com.ffbit.fun.permutation;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        Integer[] origin =      {1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] permutation = {4, 5, 7, 6, 8, 2, 1, 3};

        assertThat(toCycleNotation(origin, permutation), is("(1 4 6 2 5 8 3 7)"));
    }

    @Test
    public void multipleCyclePermutation() throws Exception {
        Integer[] origin =      {1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] permutation = {4, 5, 7, 6, 2, 8, 1, 3};

        assertThat(toCycleNotation(origin, permutation), is("(1 4 6 8 3 7)(2 5)"));
    }

    private <T> String toCycleNotation(T[] origin, T[] permutation) {
        Map<T, Integer> mapping = new LinkedHashMap<T, Integer>(origin.length, 1);
        for (int i = 0; i < origin.length; i++) {
            mapping.put(origin[i], i);
        }

        List<Set<T>> cycles = new ArrayList<Set<T>>();
        Set<T> cycle = new LinkedHashSet<T>();

        T key = null;
        Integer index = 0;
        while (!mapping.isEmpty()) {
            if (key == null) {
                if (!cycle.isEmpty()) {
                    cycles.add(cycle);
                }

                cycle = new LinkedHashSet<T>();
                key = mapping.keySet().iterator().next();
                cycle.add(key);
                index = mapping.remove(key);
            } else {
                key = permutation[index];
                index = mapping.remove(key);
                if (!cycle.add(key) || index == null) {
                    key = null;
                }
            }
        }

        if (!cycle.isEmpty()) {
            cycles.add(cycle);
        }

        return toCycles(cycles);
    }

    @Test
    public void itShouldConvertCollectionsToCycles() throws Exception {
        assertThat(toCycles(Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5))), is("(1 2 3)(4 5)"));
    }

    private <T, C extends Collection<T>> String toCycles(Collection<C> collections) {
        StringBuilder cycles = new StringBuilder();

        for (C c : collections) {
            cycles.append(toCycle(c));
        }

        return cycles.toString();
    }

    @Test
    public void itShouldConvertCollectionToCycle() throws Exception {
        assertThat(toCycle(Arrays.asList(1, 2, 3)), is("(1 2 3)"));
    }

    private <T> String toCycle(Collection<T> collection) {
        StringBuilder cycle = new StringBuilder("(");
        String separator = "";

        for (T e : collection) {
            cycle.append(separator)
                    .append(e);
            separator = " ";
        }

        cycle.append(")");

        return cycle.toString();
    }

}
