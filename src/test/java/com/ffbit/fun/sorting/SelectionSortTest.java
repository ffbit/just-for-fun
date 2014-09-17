package com.ffbit.fun.sorting;

public class SelectionSortTest extends SortTest {

    public SelectionSortTest(int[] source, int[] sorted) {
        super(source, sorted);
    }

    @Override
    Sort getSort() {
        return new SelectionSort();
    }

}
