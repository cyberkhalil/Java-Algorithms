package DataStructures.LinkedLists;

/**
 *
 * @author khalil2535
 */
public class TestLinkedLists {

    public static void main(String[] args) {

        SinglyLinkedList:
        {
            System.out.println("** Test SinglyLinkedList  **");
            SinglyLinkedList cities = new SinglyLinkedList<>();

            cities.insertLast(new Node("Gaza"));
            System.out.println(cities);
            cities.insertFirst(new Node("khanyounes"));
            System.out.println(cities);
            cities.insertLast(new Node("Raffah"));
            System.out.println(cities);
            cities.insertLast(new Node("Wosta"));
            System.out.println(cities);
            cities.remove();
            System.out.println(cities);
            System.out.println("");
        }

        DoublyLinkedList:
        {
            System.out.println("** Test DoublyLinkedList **");
            DoublyLinkedList cities = new DoublyLinkedList();

            cities.insertLast(new DoublyLinkedList.Node("Gaza"));
            cities.insertFirst(new DoublyLinkedList.Node("khanyounes"));
            cities.insertLast(new DoublyLinkedList.Node("Raffah"));
            cities.insertAfter(new DoublyLinkedList.Node("Raffah"), new DoublyLinkedList.Node("Daer El Balah"));
            cities.insertLast(new DoublyLinkedList.Node("Wosta"));

            cities.removeFirst();
            cities.removeLast();

            System.out.println(cities);
            System.out.println("");
        }

        CirclyLinkedList:
        {
            System.out.println("** Test CirclyLinkedList **");
            CirclyLinkedList cities = new CirclyLinkedList();

            cities.insert(new CirclyLinkedList.Node("Gaza"));
            cities.insertFirst(new CirclyLinkedList.Node("khanyounes"));
            cities.insert(new CirclyLinkedList.Node("Raffah"));
            cities.insertAfter(new CirclyLinkedList.Node("Raffah"), new CirclyLinkedList.Node("Daer El Balah"));
            cities.insert(new CirclyLinkedList.Node("Wosta"));
            cities.removeFirst();
            System.out.println(cities);
            System.out.println("");
        }

        SortedLinkedList:
        {
            System.out.println("** Test SortedLinkedList **");
            SortedLinkedList myList = new SortedLinkedList(1);
            System.out.println(myList);
            myList.addNumber(0);
            System.out.println(myList);
            myList.addNumber(3);
            System.out.println(myList);
            myList.addNumber(2);
            System.out.println(myList);
            myList.removeNumber(3);
            System.out.println(myList);
            myList.removeNumber(2);
            System.out.println(myList);
            myList.removeNumber(0);
            System.out.println(myList);
            myList.addNumber(0);
            System.out.println(myList);
            System.out.println("");
        }
    }

}
