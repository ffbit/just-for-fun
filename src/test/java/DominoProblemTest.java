import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class DominoProblemTest {


    @Test
    public void test() throws Exception {
        List<List<Integer>> graph = inputToGraph();







    }

    private List<List<Integer>> inputToGraph() {
        int n = 12 + 1;
        List<List<Integer>> graph = new ArrayList<List<Integer>>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>(0));
        }


        for (int[] domino : getInput()) {
            int first = domino[0];
            int second = domino[1];

            graph.get(first).add(second);
            graph.get(second).add(first);
        }

        for (List<Integer> list : graph) {
            Collections.sort(list);
        }

        return graph;
    }

    int[][] getInput() {
        return new int[][]{
                {1 ,2},
                {2 ,3},
                {3 ,4}
        };
    }


}
