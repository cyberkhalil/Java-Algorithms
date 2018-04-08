package Algorithms.SortAlgorithms.ArraySortAlgorithms.Tests;

import static Algorithms.SortAlgorithms.ArraySortAlgorithms.Sorts.insertionSort;

/**
 *
 * @author khalil2535
 */
public class SortsTest {

    public static void main(String[] args) {
        int[] array = new int[5];
        java.util.Random ran = new java.util.Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = ran.nextInt(5);
        }
        System.out.println("unsorted: " + java.util.Arrays.toString(array));
        System.out.println("sorted  : " + java.util.Arrays.toString(insertionSort(array)));

    }
}
