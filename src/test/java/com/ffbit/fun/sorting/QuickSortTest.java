package com.ffbit.fun.sorting;

public class QuickSortTest extends SortTest {

    public QuickSortTest(int[] source, int[] sorted) {
        super(source, sorted);
    }

    @Override
    Sort getSort() {
        return new QuickSort();
    }

}