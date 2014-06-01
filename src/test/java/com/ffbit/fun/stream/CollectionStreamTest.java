package com.ffbit.fun.stream;

import org.junit.Test;

import java.util.List;
import java.util.Optional;

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
    public void itShouldFilterEvenNumbers() throws Exception {
        assertThat(list.stream().filter(e -> e % 2 == 0).collect(toList()), is(asList(2, 4)));
    }

    @Test
    public void itShouldCountEvenNumbers() throws Exception {
        assertThat(list.stream().filter(e -> e % 2 == 0).count(), is(2L));
    }

    @Test
    public void itShouldCollectDistinctNumbers() throws Exception {
        assertThat(list.stream().distinct().collect(toList()), is(asList(1, 2, 3, 4, 5)));
    }

    @Test
    public void itShouldMapNumbers() throws Exception {
        assertThat(list.stream().map(e -> e * 2).collect(toList()), is(asList(2, 4, 6, 8, 10, 2)));
    }

    @Test
    public void itShouldMapNumbersToStrings() throws Exception {
        assertThat(list.stream().map(e -> String.valueOf(e)).collect(toList()), is(asList("1", "2", "3", "4", "5", "1")));
    }

    @Test
    public void itShouldFlatMap() throws Exception {
        List<List<Integer>> listOfLists = asList(asList(1, 2), asList(3, 4));

        assertThat(listOfLists.stream().flatMap(e -> e.stream()).collect(toList()), is(asList(1, 2, 3, 4)));
    }

    @Test
    public void itShouldFindFirstEvenNumber() throws Exception {
        Optional<Integer> firstEven = list.stream().filter(e -> e % 2 == 0).findFirst();

        assertThat(firstEven.isPresent(), is(true));
        assertThat(firstEven.get(), is(2));
    }

}
