package com.ffbit.fun.tree;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class IntervalTest {

    @Test
    @Parameters({
            "1, 2",
            "2, 1",
            "1, 1"
    })
    public void itShouldSetMinAndMaxWhenCreated(int a, int b) {
        Interval<Integer> interval = new Interval<>(a, b);

        assertThat("min is greater than max",
                interval.getMin(), is(lessThanOrEqualTo(interval.getMax())));
    }

    @Test
    public void itShouldCreateIntervalWithSameMinAndMax() {
        Interval<Integer> interval = new Interval<>(1);

        assertThat(interval.getMin(), is(interval.getMax()));
    }

    @Test
    @Parameters({
            "2, 5,    1, 3",
            "2, 5,    4, 7",
            "2, 5,    3, 4",
            "2, 5,    1, 2",
            "2, 5,    5, 7"
    })
    public void itShouldOverlap(int minA, int maxA, int minB, int maxB) {
        Interval<Integer> a = new Interval<>(minA, maxA);
        Interval<Integer> b = new Interval<>(minB, maxB);

        assertThat("a does not overlap b", a.overlaps(b), is(true));
        assertThat("b does not overlap a", b.overlaps(a), is(true));
    }

    @Test
    @Parameters({
            "2, 5,    6, 7",
            "2, 5,    0, 1"
    })
    public void itShouldNotOverlap(int minA, int maxA, int minB, int maxB) {
        Interval<Integer> a = new Interval<>(minA, maxA);
        Interval<Integer> b = new Interval<>(minB, maxB);

        assertThat("a overlaps b", a.overlaps(b), is(false));
        assertThat("b overlaps a", b.overlaps(a), is(false));
    }

}
