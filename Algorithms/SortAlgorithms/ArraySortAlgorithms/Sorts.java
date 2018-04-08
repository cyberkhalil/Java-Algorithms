package Algorithms.SortAlgorithms.ArraySortAlgorithms;

public class Sorts {

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            for (int j = i; j > 0; j--) {
                if (temp > array[j - 1]) {
                    break;
                } else {
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    private Sorts() {
    }
}
