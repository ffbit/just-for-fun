package com.ffbit.fun.tree;

public class Interval<E extends Comparable<E>>
        implements Comparable<Interval<E>> {
    private final E min;
    private final E max;

    public Interval(E min, E max) {
        if (greater(min, max)) {
            this.min = max;
            this.max = min;
        } else {
            this.min = min;
            this.max = max;
        }
    }

    public Interval(E point) {
        this(point, point);
    }

    public E getMin() {
        return min;
    }

    public E getMax() {
        return max;
    }

    @Override
    public int compareTo(Interval<E> other) {
        return min.compareTo(other.min);
    }

    public boolean overlaps(Interval<E> other) {
        Interval<E> left = this;
        Interval<E> right = other;

        if (greater(left.min, right.min)) {
            left = other;
            right = this;
        }

        return lessOrEqual(right.min, left.max);
    }

    private boolean greater(E a, E b) {
        return a.compareTo(b) > 0;
    }

    private boolean lessOrEqual(E a, E b) {
        return !greater(a, b);
    }

    @Override
    public String toString() {
        return String.format("[%s, %s]", min, max);
    }

}
