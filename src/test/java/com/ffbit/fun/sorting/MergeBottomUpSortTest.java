package com.ffbit.fun.sorting;

public class MergeBottomUpSortTest extends SortTest {

    public MergeBottomUpSortTest(int[] source, int[] sorted) {
        super(source, sorted);
    }

    @Override
    Sort getSort() {
        return new MergeBottomUpSort();
    }

}