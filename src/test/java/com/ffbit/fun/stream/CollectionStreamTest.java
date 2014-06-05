package com.ffbit.fun.stream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;
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

    @Test
    public void itShouldSortStringsByTheirLengthDescending() throws Exception {
        List<String> strings = asList("abc", "a", "ab", "abcd");

        assertThat(strings.stream().sorted((e1, e2) -> Integer.compare(e2.length(), e1.length())).collect(toList()),
                is(asList("abcd", "abc", "ab", "a")));
    }

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Test
    public void itShouldPrintAllNumbers() throws Exception {
        List<String> strings = asList("a", "b", "c");

        strings.stream().forEach(System.out::print);

        assertThat(log.getLog(), is(strings.stream().collect(joining())));
    }

    @Test
    public void itShouldPeekElements() throws Exception {
        List<String> strings = asList("a", "b", "c");

        strings.stream().peek(e -> System.out.print(e)).collect(toList());

        assertThat(log.getLog(), is(strings.stream().collect(joining())));
    }

    @Test
    public void itShouldProjectStringsToTheirCount() throws Exception {
        List<String> strings = asList("a", "a", "b", "c", "c", "c");

        Map<String, Long> aggregation = new HashMap<String, Long>() {{
            put("a", 2L);
            put("b", 1L);
            put("c", 3L);
        }};

        assertThat(strings.stream().collect(groupingBy(e -> e, counting())), is(aggregation));
    }

    @Test
    public void itShouldGroupStringsByTheirLength() throws Exception {
        List<String> strings = asList("a", "b", "c", "aa", "bb", "cc", "dd");

        Map<Integer, List<String>> aggregation = new HashMap<Integer, List<String>>() {{
            put(1, asList("a", "b", "c"));
            put(2, asList("aa", "bb", "cc", "dd"));
        }};

        assertThat(strings.stream().collect(groupingBy(String::length, mapping(e -> e, toList()))),
                is(aggregation));
    }
}
