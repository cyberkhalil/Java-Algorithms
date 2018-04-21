package algorithms.sorts;

public class ArraySorts {

    public static int numberOfCompares = -1;
    public static int numberOfSwaps = -1;

    public static <E extends Comparable<E>> void selectionSort(E[] array) {
        numberOfCompares = 0;
        numberOfSwaps = 0;
        for (int from = 0; from < array.length; from++) {
            E minimum = array[from];
            int indexMinimum = from;

            for (int i = from + 1; i < array.length; i++) {
                numberOfCompares++;
                if (minimum.compareTo(array[i]) > 0) {
                    minimum = array[i];
                    indexMinimum = i;
                }
            }
            // swap
            swap(array, from, indexMinimum);
            numberOfSwaps++;
        }
    }

    private static void swap(Object[] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <E extends Comparable<E>> void bubbleSort(E[] array) {
        numberOfCompares = 0;
        numberOfSwaps = 0;

        int unSortedLength = array.length;
        while (unSortedLength > 1) {
            for (int i = 1; i < unSortedLength; i++) {

                numberOfCompares++;

                if (array[i].compareTo(array[i - 1]) < 0) {
                    E temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;

                    numberOfSwaps++;

                }
            }
            unSortedLength--;
        }
    }

    /**
     *
     * @param <E>
     * @param array
     */
    //TODO rewrite it with shifting from left to right
    public static <E extends Comparable<E>> void insertionSort(E[] array) {
        numberOfCompares = 0;
        numberOfSwaps = 0;

        for (int i = 1; i < array.length; i++) {
            E temp = array[i];
            for (int j = i; j > 0; j--) {
                numberOfCompares++;
                if (temp.compareTo(array[j - 1]) < 0) {
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    private ArraySorts() {
    }

}
