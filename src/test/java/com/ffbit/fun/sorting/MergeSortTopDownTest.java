package com.ffbit.fun.sorting;

public class MergeSortTopDownTest extends SortTest {

    public MergeSortTopDownTest(int[] source, int[] sorted) {
        super(source, sorted);
    }

    @Override
    Sort getSort() {
        return new MergeSortTopDown();
    }

}
