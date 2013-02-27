package com.ffbit.fun.domino;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class DominoesPack {
    private final int n;
    private List<int[]> pack;

    public DominoesPack(int n) {
        this.n = n;
        pack = new ArrayList<int[]>();
        fillPack();
    }

    private void fillPack() {
        for (int i = 0; i <= n; i++) {
            // Skip doubles
            for (int j = i + 1; j <= n; j++) {
                pack.add(new int[]{i, j});
            }
        }
    }

    public int remaining() {
        return pack.size();
    }

    public int[] draw() {
        if (pack.isEmpty()) {
            throw new NoSuchElementException("Pack of " + n + " is already empty.");
        }

        Random random = new Random(System.nanoTime());
        int randomIndex = random.nextInt(pack.size());

        return pack.remove(randomIndex);
    }

    public List<int[]> draw(int number) {
        if (number < 0) {
            throw new RuntimeException("Only positive number can be drawn:" + number);
        }

        if (number > pack.size()) {
            throw new RuntimeException("number " + number + " can not be drawn from:" + pack.size());
        }

        List<int[]> drawn = new ArrayList<int[]>(number);

        for (int i = 0; i < number; i++) {
            drawn.add(draw());
        }

        return drawn;
    }

}
