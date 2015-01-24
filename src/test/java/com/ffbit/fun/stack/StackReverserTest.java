package com.ffbit.fun.stack;

import org.junit.Test;

import java.util.Stack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StackReverserTest {
    private StackReverser reverser = new StackReverser();

    @Test
    public void itShouldReverseStack() {
        Stack<Character> stack = new Stack<>();
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');

        Stack<Character> expectedReversedStack = new Stack<>();
        expectedReversedStack.push('d');
        expectedReversedStack.push('c');
        expectedReversedStack.push('b');
        expectedReversedStack.push('a');

        reverser.reverse(stack);

        assertThat(stack, is(expectedReversedStack));
    }

}
