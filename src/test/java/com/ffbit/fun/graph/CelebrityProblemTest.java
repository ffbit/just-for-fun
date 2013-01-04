package com.ffbit.fun.graph;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CelebrityProblemTest {

    @Test
    public void itShouldConvertDataProperly() throws Exception {
        String dataStr = "01" + "10";
        assertThat(convertData(dataStr), is(new boolean[][] { //
                { false, true },
                { true, false }
                }));
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
