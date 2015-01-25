package com.ffbit.fun.sorting;

import java.util.Arrays;

public class KthMaxStatistics {

    public int findKthMaxStatistics(int[] array, int k) {
        return partitionUpToK(array, 0, array.length - 1, k);
    }

    private int partitionUpToK(int[] array, int low, int high, int k) {
        int pivot = partition(array, low, high);
        int pivotStatistics = array.length - pivot;
        System.out.println(Arrays.toString(array) + " " + pivotStatistics);

//        return array[pivot];
        if (k == pivotStatistics) {
            return array[pivot];
        } else if (k < pivotStatistics) {
            return partitionUpToK(array, pivot + 1, high, k);
        } else {
            return partitionUpToK(array, low, pivot - 1, k);
        }
    }

    private int partition(int[] array, int low, int high) {
        int value = array[low];
        int i = low;
        int j = high + 1;

        while (true) {
            while (array[++i] < value) {
                if (i == high) {
                    break;
                }
            }

            while (array[--j] >= value) {
                if (j == low) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            swap(array, i, j);
        }

        swap(array, low, j);

        return j;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
