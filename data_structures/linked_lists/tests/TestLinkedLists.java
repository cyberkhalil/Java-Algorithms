package data_structures.linked_lists.tests;

import data_structures.linked_lists.CirclyLinkedList;
import data_structures.linked_lists.DoublyLinkedList;
import data_structures.linked_lists.SinglyLinkedList;
import data_structures.linked_lists.SortedLinkedList;

/**
 *
 * @author khalil2535
 */
public class TestLinkedLists {

    public static void main(String[] args) {

        SinglyLinkedList:
        {
            System.out.println("** Test SinglyLinkedList  **");
            SinglyLinkedList<String> cities = new SinglyLinkedList<>();

            cities.insertLast("Gaza");
            System.out.println(cities);
            cities.insertFirst("khanyounes");
            System.out.println(cities);
            cities.insertLast("Raffah");
            System.out.println(cities);
            cities.insertLast("Wosta");
            System.out.println(cities);
            cities.removeFirst();
            cities.removeLast();
            System.out.println(cities);
            System.out.println("");
        }
        DoublyLinkedList:
        {
            System.out.println("** Test DoublyLinkedList **");
            DoublyLinkedList<String> cities = new DoublyLinkedList<>();

            cities.insertLast("Gaza");
            System.out.println(cities);
            cities.insertFirst("khanyounes");
            System.out.println(cities);
            cities.insertLast("Raffah");
            System.out.println(cities);
            cities.insertAfter("Raffah", "Daer El Balah");
            System.out.println(cities);
            cities.insertLast("Wosta");

            cities.removeFirst();
            cities.removeLast();

            System.out.println(cities);
            System.out.println("");
        }
        CirclyLinkedList:
        {
            System.out.println("** Test CirclyLinkedList **");
            CirclyLinkedList<String> cities = new CirclyLinkedList<>();

            cities.insertLast("Gaza");
            cities.insertFirst("khanyounes");
            cities.insertLast("Raffah");
            cities.insertAfter("Raffah", "Daer El Balah");
            cities.insertLast("Wosta");
            cities.removeFirst();
            System.out.println(cities);
            System.out.println("");
        }

        SortedLinkedList:
        {
            System.out.println("** Test SortedLinkedList **");
            SortedLinkedList<Integer> myList = new SortedLinkedList<>(1);
            System.out.println(myList);
            myList.add(0);
            System.out.println(myList);
            myList.add(3);
            System.out.println(myList);
            myList.add(2);
            System.out.println(myList);
            myList.remove(3);
            System.out.println(myList);
            myList.remove(2);
            System.out.println(myList);
            myList.remove(0);
            System.out.println(myList);
            myList.add(0);
            System.out.println(myList);
            System.out.println("");
        }
    }

}
