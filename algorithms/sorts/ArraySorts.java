package algorithms.sorts;

public class ArraySorts {

    public static int numberOfCompares = -1;
    public static int numberOfSwaps = -1;

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

    public static <E extends Comparable<E>> void insertionSort(E[] array) {
        numberOfCompares = 0;
        numberOfSwaps = 0;

        for (int i = 1; i < array.length; i++) {
            E temp = array[i];
            for (int j = i; j > 0; j--) {

                numberOfCompares++;

                if (temp.compareTo(array[j - 1]) > 0) {
                    break;
                } else {
                    numberOfSwaps++;
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    private ArraySorts() {
    }

}
