package com.ffbit.fun.sorting;

public class InsertionSortTest extends SortTest {

    public InsertionSortTest(int[] source, int[] sorted) {
        super(source, sorted);
    }

    @Override
    Sort getSort() {
        return new InsertionSort();
    }

}
