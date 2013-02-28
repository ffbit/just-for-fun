import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class FloodFillTest {

    public static class DominoItem {
        int firstNumber;
        int secondNumber;

        public DominoItem(int firstNumber, int secondNumber) {
            this.firstNumber = firstNumber;
            this.secondNumber = secondNumber;
        }

        public int getFirstNumber() {
            return firstNumber;
        }

        public void setFirstNumber(int firstNumber) {
            this.firstNumber = firstNumber;
        }

        public int getSecondNumber() {
            return secondNumber;
        }

        public void setSecondNumber(int secondNumber) {
            this.secondNumber = secondNumber;
        }

        @Override
        public int hashCode() {
            return firstNumber + secondNumber;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            DominoItem other = (DominoItem) obj;

            return (firstNumber == other.firstNumber && secondNumber == other.secondNumber)
                    || (firstNumber == other.secondNumber && secondNumber == other.firstNumber);
        }

        @Override
        public String toString() {
            return "(" + firstNumber + ", " + secondNumber + ")";
        }

    }

    @Test
    public void twoDominosWithSameEdges() throws Exception {
        assertThat(new DominoItem(1, 2), is(new DominoItem(2, 1)));
    }

    @Test
    public void twoDominosWithDifferentEdges() throws Exception {
        assertThat(new DominoItem(1, 2), is(not(new DominoItem(1, 3))));
    }

    @Test
    public void test() {
        List<DominoItem> input = Arrays.asList(
                new DominoItem(1, 2),
                new DominoItem(2, 3),
                new DominoItem(3, 4),
                new DominoItem(4, 5),
                new DominoItem(7, 8),
                new DominoItem(12, 9)
        );

        List<DominoItem> expected = Arrays.asList(
                new DominoItem(1, 2),
                new DominoItem(2, 3),
                new DominoItem(3, 4),
                new DominoItem(4, 5)
        );

        assertThat(algorithm(input), is(expected));
    }

    private List<DominoItem> algorithm(List<DominoItem> input) {
        return null;
    }

}
