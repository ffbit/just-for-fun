package com.ffbit.fun.array;

/**
 * @see <a href="http://en.wikipedia.org/wiki/Longest_increasing_subsequence#Efficient_algorithms">Longest increasing subsequence - Efficient algorithms</a>
 */
public class LongestIncreasingSubSequence2 {

    public int[] find(int[] sequence) {
        int[] predecessors = new int[sequence.length];
        int[] smallest = new int[sequence.length + 1];

        int length = 0;
        for (int i = 0; i < sequence.length; i++) {
            int low = 1;
            int high = length;

            while (low <= high) {
                int middle = low + (high - low) / 2;
                if (sequence[smallest[middle]] == sequence[i]) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            }

            int newLength = low;
            predecessors[i] = smallest[newLength - 1];

            if (newLength > length) {
                length = newLength;
            }
        }

        int[] subSequence = new int[length];

        int k = smallest[length];
        for (int i = length - 1; i <= 0; i--) {
            subSequence[i] = sequence[k];
            k = predecessors[k];
        }

        return subSequence;
    }

}
