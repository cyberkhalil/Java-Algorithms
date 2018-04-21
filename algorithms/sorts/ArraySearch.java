package algorithms.sorts;

/**
 *
 * @author khalil2535
 */
public class ArraySearch {

    public static int numberOfCompares = -1;
    public static int numberOfSwaps = -1;

    public static <E extends Comparable<E>> int binarySearch(E[] array, E number) {
        numberOfCompares = 0;
        numberOfSwaps = 0;

        int lowerBound = 0;
        int upperBound = array.length;

        while (lowerBound < upperBound) {
            final int currentIndex = lowerBound + upperBound / 2;

            numberOfCompares++;

            if (number.compareTo(array[currentIndex]) == 0) {
                return currentIndex;
            } else if (number.compareTo(array[currentIndex]) < 0) {
                lowerBound = currentIndex + 1;
            } else {
                upperBound = currentIndex - 1;
            }
        }
        return -1;
    }

    private ArraySearch() {
    }
}
