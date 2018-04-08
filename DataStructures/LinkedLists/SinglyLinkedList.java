package DataStructures.LinkedLists;

public class SinglyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SinglyLinkedList() {
        size = 0;
    }

    public SinglyLinkedList(E item) {

        size = 1;
        this.head = new Node<>(item);
    }

    public E remove() {
        Node<E> removed = head;
        head = head.getNext();
        size--;
        return removed.getItem();
    }

    public void insertLast(E item) {
        Node<E> node = new Node<>(item);
        if (size == 0) {
            this.head = node;
            this.tail = node;
            this.size++;
        } else {
            this.tail.setNext(node);
            this.tail = node;
            this.size++;
        }

    }

    public void insertFirst(E item) {
        Node<E> newHead = new Node<>(item);
        if (this.size == 0) {
            this.head = newHead;
            this.tail = newHead;
            this.size++;
        } else {
            newHead.setNext(this.head);
            this.head = newHead;
            this.size++;
        }
    }

    @Override
    public String toString() {
        String all = "";
        Node<E> currentnode = head;
        while (currentnode != null) {
            all += currentnode.toString();
            currentnode = currentnode.getNext();
            if (currentnode != null) {
                all += " -> ";
            }
        }
        return all;
    }
}

class Node<E> {

    private final E item;
    private Node<E> next;

    Node(E item) {
        this.item = item;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public E getItem() {
        return item;
    }

    @Override
    public String toString() {
        return item.toString();
    }
}
