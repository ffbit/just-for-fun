package com.ffbit.fun.stack;

import java.util.Stack;

/**
 * http://www.careercup.com/question?id=6082007230578688
 * <p/>
 * One of the questions in one of the interviews -
 * Given a stack S and another empty stack T and a variable v,
 * write a function that returns S but with its elements reversed.
 */
public class StackReverser {

    public <T> void reverse(Stack<T> stack) {
        Stack<T> tmpStack = new Stack<>();
        int exchangeCount = stack.size();

        while (exchangeCount > 0) {
            T tmpElement = stack.pop();

            while (exchangeCount - 1 - tmpStack.size() > 0) {
                tmpStack.push(stack.pop());
            }

            stack.push(tmpElement);

            while (!tmpStack.isEmpty()) {
                stack.push(tmpStack.pop());
            }

            exchangeCount--;
        }
    }

}
