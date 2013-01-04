package com.ffbit.fun.graph;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayDeque;
import java.util.Queue;

import org.junit.Test;

public class CelebrityProblemTest {

    @Test
    public void itShouldFindTheThirdPersonAsTheCelebrity() throws Exception {
        String dataStr = "00110" + "10101" + "00000" + "01101" + "10100";
        boolean[][] matrix = convertData(dataStr);

        assertThat(findCelebrity(matrix), is(2));
    }

    @Test
    public void itShouldFindTheFourthPersonAsTheCelebrity() throws Exception {
        String dataStr = "01110" + "00011" + "10010" + "00000" + "10110";
        boolean[][] matrix = convertData(dataStr);

        assertThat(findCelebrity(matrix), is(3));
    }

    private int findCelebrity(boolean[][] matrix) {
        // 1. Eliminating phase
        int n = matrix.length;

        // fill the queue of celebrities
        Queue<Integer> celebrities = new ArrayDeque<Integer>(n);

        for (int i = 0; i < n; i++) {
            celebrities.add(i);
        }

        /* eliminate possible celebrities.
         * if person 1 knows person 2, then person 1 is not a celebrity;
         * if person 1 does not know person 2, then person 2 is not a celebrity. */
        while (celebrities.size() > 1) {
            int first = celebrities.remove();
            int second = celebrities.remove();

            if (matrix[first][second]) {
                celebrities.add(second);
            } else {
                celebrities.add(first);
            }
        }

        // 2. Brute-force verification
        int celebrity = celebrities.remove();

        for (int i = 0; i < n; i++) {
            if (i != celebrity
                    && (!matrix[i][celebrity] || matrix[celebrity][i])) {
                return -1;
            }
        }

        return celebrity;
    }

    @Test
    public void itShouldConvertDataProperly() throws Exception {
        String dataStr = "01" + "10";
        assertThat(convertData(dataStr), is(new boolean[][] { //
                { false, true }, { true, false } }));
    }

    public boolean[][] convertData(String dataStr) {
        int dataLength = dataStr.length();
        int n = (int) Math.sqrt(dataLength);
        assert n * n == dataLength;

        boolean[][] data = new boolean[n][n];
        for (int i = 0; i < dataLength; i++) {
            if (dataStr.charAt(i) == '1') {
                data[i / n][i % n] = true;
            }
        }

        return data;
    }

}
