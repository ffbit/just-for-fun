package com.ffbit.fun.string;

/**
 * http://www.careercup.com/question?id=5717567253512192
 */
public class SentenceReverser {


    public String reverseSentence(String input) {
        char[] chars = input.toCharArray();

        reverse(chars);
        reverseWords(chars);

        return new String(chars);
    }

    private void reverseWords(char[] chars) {
        int startWordIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, startWordIndex, i);
                startWordIndex = i + 1;
            } else if (i == chars.length - 1) {
                reverse(chars, startWordIndex, chars.length);
            }
        }
    }

    private void reverse(char[] chars, int from, int to) {
        for (int i = 0; i < (to - from) / 2; i++) {
            swap(chars, from + i, to - 1 - i);
        }
    }

    private void reverse(char[] chars) {
        reverse(chars, 0, chars.length);
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

}
