package com.ffbit.fun.string;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SentenceReverserTest {
    private SentenceReverser reverser = new SentenceReverser();

    @Test
    public void itShouldReverseSentence() {
        String input = "I wish you a merry Christmas";
        String output = "Christmas merry a you wish I";

        assertThat(reverser.reverseSentence(input), is(output));
    }

    @Test
    public void itShouldReverseEmptyString() {
        assertThat(reverser.reverseSentence(""), is(""));
    }

}
