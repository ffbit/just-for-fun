package com.ffbit.fun.array;

import java.util.Arrays;

public class FirstOccurrenceBinarySearchTest {

    public static int binarySearch(int[] a, int needle) {
        int start = 0;
        int end = a.length - 1;
        int firstOccurrence = -1;
        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (a[middle] == needle) {
                firstOccurrence = middle;
                end = middle - 1;
            } else if (a[middle] < needle) {
                start = middle + 1;
            } else
                end = middle - 1;
        }

        if (firstOccurrence >= 0) {
            return firstOccurrence;
        }

        return -(start + 1);
    }

    public static int algorithm(int needle, int[] array) {
        int index = binarySearch(array, needle);

        if (index < 0) {
            return -1;
        }

        int nextIndex = index + 1;


        if (array.length <= nextIndex) {
            return -1;
        }

        if (needle != array[nextIndex]) {
            return -1;
        }

        return nextIndex + 1;
    }


    public static void main(String... args) {
        int[] array = {1, 1, 2, 3, 3, 9, 9, 9, 17, 19, 23, 23, 23, 100};
        System.out.println(algorithm(1, array) == 2);
        System.out.println(algorithm(2, array) == -1);
        System.out.println(algorithm(3, array) == 5);
        System.out.println(algorithm(9, array) == 7);
        System.out.println(algorithm(17, array) == -1);
        System.out.println(algorithm(18, array) == -1);
        System.out.println(algorithm(23, array) == 12);
        System.out.println(Arrays.binarySearch(array, 9));
    }

}