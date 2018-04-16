package algorithms.sorts.test;

import static algorithms.sorts.ArraysSorts.*;

/**
 *
 * @author khalil2535
 */
public class SortsTest {

    /**
     *
     * @param args
     * @deprecated TODO remove main and Test using JUnit or other test
     * methodology
     */
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
