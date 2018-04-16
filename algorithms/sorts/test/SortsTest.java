package algorithms.sorts.test;

import static algorithms.sorts.ArraysSorts.*;
import java.util.Random;

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
        Integer[] array = new Integer[11];
        Random ran = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = ran.nextInt(50);
        }

        System.out.println("unsorted: " + java.util.Arrays.toString(array));
        bubbleSort(array);
        System.out.println("sorted  : " + java.util.Arrays.toString(array));
        System.out.println("numberOfCompares :" + numberOfCompares);
        System.out.println("numberOfSwaps :" + numberOfSwaps);

    }
}
