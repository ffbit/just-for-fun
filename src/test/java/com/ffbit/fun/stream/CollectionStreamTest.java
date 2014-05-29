package com.ffbit.fun.stream;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by oss-ffbit on 5/29/14.
 */
public class CollectionStreamTest {
    private List<Integer> list = asList(1, 2, 3, 4, 5, 1);

    @Test
    public void itShouldFilterEven() throws Exception {
        assertThat(list.stream().filter(e -> e % 2 == 0).collect(toList()), is(asList(2, 4)));
    }

}