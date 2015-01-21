package com.ffbit.fun.string;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class OneEditApartTest {
    private OneEditApart oneEditApart = new OneEditApart();

    @Test
    @Parameters({
            "cat,  cut", // replace "u" -> "a"
            "cats, cat", // remove "s"
            "cat,  at",  // insert "c"
            "cat,  cbat" // remove "b"
    })
    public void itShouldBeOneEditApart(String a, String b) {
        assertThat(oneEditApart.oneEditApart(a, b), is(true));
    }

    @Test
    @Parameters({
            "cat, cuts", // no operations
            "ca,  ca"    // no operations
    })
    public void itShouldNotBeOneEditApart(String a, String b) {
        assertThat(oneEditApart.oneEditApart(a, b), is(false));
    }

}
