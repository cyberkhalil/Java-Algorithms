package data_structures.arrays.sorted_array;

import java.util.Arrays;

/**
 * Sorted by Insertion sort algorithm
 *
 * @author khalil2535
 * @param <E> element
 */
public class SortedArray<E extends Comparable<E>> {

    private E[] array;
    private int size;

    /**
     *
     * @param capacity
     */
    public SortedArray(int capacity) {
        setArray((E[]) new Comparable[capacity]);
        size = 0;
    }

    /**
     * The array you enter must be sorted
     *
     * @param array the array to set
     */
    public SortedArray(E[] array) {
        setArray(array);
        size = 0;
        while (array[size] != null && size < array.length) {
            size++;
        }
    }

    /**
     * @return the array
     */
    public E[] getArray() {
        return array;
    }

    /**
     * The array you enter must be sorted
     *
     * @param array the array to set
     */
    private void setArray(E[] array) {
        this.array = array;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * adding Item by Insertion sort algorithm
     *
     * @param item
     * @return true if successful or false if not
     */
    public boolean add(E item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = item;
                size++;
                return true;
            } else if (array[i].compareTo(item) < 0) {
                shiftUnitToRight(array, i, array.length - 1);
                array[i] = item;
                size++;
                return true;
            }
        }
        return false;
    }

    private E[] shiftUnitToRight(E[] array, int from, int to) {
        if (from > to) // flip them
        {
            int temp = from;
            from = to;
            to = temp;
        }
        if (array.length <= to) {
            throw new ArrayIndexOutOfBoundsException("You are trying to shift an array content to index not found \n max Index:" + (array.length - 1) + "\n wanted Index" + to);
        } else {
            for (; from < to; to--) {
                array[to] = array[to - 1];
            }
        }
        return array;
    }

    private E[] shiftUnitToLeft(E[] array, int from, int to) {
        if (from > to) // flip them
        {
            int temp = from;
            from = to;
            to = temp;
        }
        if (array.length <= to) {
            throw new ArrayIndexOutOfBoundsException("You are trying to shift an array content to index not found \n max Index:" + (array.length - 1) + "\n wanted Index" + to);
        } else {
            for (; from < to; from++) {
                array[from] = array[from + 1];
            }
        }
        return array;
    }

    /**
     * removing Item by Insertion sort algorithm
     *
     * @param item
     * @return true if successful or false if not
     */
    public boolean remove(E item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) {
                array = shiftUnitToLeft(array, i, array.length - 1);
                array[array.length - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public void removeMost() {
        array = shiftUnitToLeft(array, 0, size - 1);
    }

    /**
     *
     * @return Arrays.toString(array)
     */
    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}
