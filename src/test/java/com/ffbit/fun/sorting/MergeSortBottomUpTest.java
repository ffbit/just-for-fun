package com.ffbit.fun.sorting;

public class MergeSortBottomUpTest extends SortTest {

    public MergeSortBottomUpTest(int[] source, int[] sorted) {
        super(source, sorted);
    }

    @Override
    Sort getSort() {
        return new MergeSortBottomUp();
    }

}
