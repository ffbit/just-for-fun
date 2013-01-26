package com.ffbit.fun.string;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class CamelCaseToSnakeCaseTest {

    @Test
    public void testNullString() throws Exception {
        assertThat(camelToSnake(null), is(nullValue()));
    }

    @Test
    public void testBlankString() throws Exception {
        assertThat(camelToSnake(" "), is(""));
    }

    @Test
    public void testCamelString() throws Exception {
        assertThat(camelToSnake("SomeGoodName"), is("some_good_name"));
    }

    private String camelToSnake(final String camelString) {


        if (camelString == null) {
            return camelString;
        }

        String trimmedCamel = camelString.trim();
        if (trimmedCamel.isEmpty()) {
            return trimmedCamel;
        }

        StringBuilder snakeCase = new StringBuilder();
        char snakeSeparator = '_';

        int codePointCount = trimmedCamel.codePointCount(0, trimmedCamel.length());
        for (int i = 0; i < codePointCount; i++) {
            int codePoint = trimmedCamel.codePointAt(i);

            if (Character.isUpperCase(codePoint) && i != 0) {
                snakeCase.append(snakeSeparator);
            }

            snakeCase.appendCodePoint(Character.toLowerCase(codePoint));
        }

        return snakeCase.toString();
    }

}
