package data_structures.arrays.sorted_array.tests;

import data_structures.arrays.sorted_array.SortedArray;

/**
 *
 * @author khalil2535
 */
public class SortedArrayTest {

    public static void main(String[] args) {
        SortedArray<Integer> mySortedArray = new SortedArray<>(5);
        mySortedArray.add(1);
        mySortedArray.add(2);
        mySortedArray.add(1);
        mySortedArray.add(0);
        mySortedArray.add(5);
        mySortedArray.add(6);
        mySortedArray.add(0);
        System.out.println(mySortedArray);
        mySortedArray.remove(6);
        mySortedArray.remove(0);
        mySortedArray.remove(1);
        System.out.println(mySortedArray);
        System.out.println("Size :" + mySortedArray.getSize());
        mySortedArray.removeMost();
        System.out.println(mySortedArray);
    }
}
