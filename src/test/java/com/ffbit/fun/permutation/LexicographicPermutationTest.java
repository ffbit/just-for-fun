package com.ffbit.fun.permutation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@Ignore
@RunWith(Parameterized.class)
public class LexicographicPermutationTest {

    private String source;
    private String[] expected;

    public LexicographicPermutationTest(String source, String[] expected){
        this.source = source;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> init() {
        Object[][] data = new Object[][]{
                {"ab", new String[]{"ab", "ba"}},
                {"abc", new String[]{"abc", "acb", "bac", "bca", "cab", "cba"}}
        };

        return Arrays.asList(data);
    }

    @Test
    public void testLexicographicPermutation() throws Exception {
        assertThat(permutate(source), equalTo(expected));
    }

    private String[] permutate(String str) {
        char[] chars = str.toCharArray();
        final int n = chars.length;
        int counter = 0;

        return null;
    }

    private void print(Object o) {
        System.out.println(o);
    }
}
