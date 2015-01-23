package com.ffbit.fun.array;

import java.util.Deque;
import java.util.LinkedList;

public class LongestIncreasingSubSequence {

    public int[] find(int[] sequence) {
        Deque<Integer> stack = new LinkedList<>();
        int[] lengths = new int[sequence.length];

        for (int i = 0; i < sequence.length; i++) {
            int element = sequence[i];

            while (!stack.isEmpty() && stack.peek() > element) {
                stack.pop();
            }

            stack.push(element);
            lengths[i] = stack.size();
        }

        int maxSubSequenceLength = findSubSequenceLength(lengths);
        int[] subSequence = new int[maxSubSequenceLength];

        int currentSubSequenceLength = maxSubSequenceLength;
        for (int i = lengths.length - 1; i >= 0; i--) {
            if (currentSubSequenceLength == lengths[i]) {
                subSequence[--currentSubSequenceLength] = sequence[i];
            }
        }

        return subSequence;
    }

    private int findSubSequenceLength(int[] lengths) {
        int maxLengthIndex = lengths.length - 1;
        for (int i = maxLengthIndex; i >= 0; i--) {
            if (lengths[maxLengthIndex] < lengths[i]) {
                maxLengthIndex = i;
            }
        }
        return lengths[maxLengthIndex];
    }

}
