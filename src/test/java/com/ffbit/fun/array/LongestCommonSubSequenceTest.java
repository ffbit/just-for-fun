package com.ffbit.fun.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LongestCommonSubSequenceTest {
    private LongestCommonSubSequence finder = new LongestCommonSubSequence();

    @Test
    public void itShouldFindLongestCommonSubSequenceSize2() {
        char[] a = "abcd".toCharArray();
        char[] b = "badc".toCharArray();

        assertThat(finder.findCommonSubSequenceSize(a, b), is(2));
    }

    @Test
    public void itShouldFindLongestCommonSubSequenceSize5() {
        char[] a = "abcdefg".toCharArray();
        char[] b = "abgcfde".toCharArray();

        assertThat(finder.findCommonSubSequenceSize(a, b), is(5));
    }


    @Test
    public void itShouldFindLongestCommonSubSequence2() {
        char[] a = "abcd".toCharArray();
        char[] b = "badc".toCharArray();
        char[] commonSubSequence = "ac".toCharArray();

        assertThat(finder.findCommonSubSequence(a, b), is(commonSubSequence));
    }

    @Test
    public void itShouldFindLongestCommonSubSequence5() {
        char[] a = "abcdefg".toCharArray();
        char[] b = "abgcfde".toCharArray();
        char[] commonSubSequence = "abcde".toCharArray();

        assertThat(finder.findCommonSubSequence(a, b), is(commonSubSequence));
    }

}
