package data_structures.linked_lists;

/**
 *
 * @author khalil2535
 * @param <E>
 */
public class DoublyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedList() {
        size = 0;
    }

    public DoublyLinkedList(E item) {
        tail = new Node<>(item);
        head = tail;
        head.setNext(tail);
        tail.setPrevious(tail);
        size = 1;
    }

    public DoublyLinkedList(E head, E tail) {
        if (head != null) {
            this.head = new Node<>(head);
            this.tail = new Node<>(tail);
            size = head == tail ? 1 : 2;
            this.head.setNext(this.tail);
            this.tail.setPrevious(this.head);
        }
    }

    public void removeFirst() {
        head = head.getNext();
        head.setPrevious(null);
        size--;
        if (size == 0) {
            tail = null;
        }
    }

    public void removeLast() {
        tail = tail.getPrevious();
        tail.setNext(null);
        size--;
        if (size == 0) {
            head = null;
        }
    }

    public void insertLast(E item) {
        Node<E> node = new Node<>(item);
        if (size == 0) {
            this.head = node;
            this.tail = node;
            this.size++;
        } else {
            this.tail.ConnectTo(node);
            this.tail = tail.getNext();
            this.size++;
        }

    }

    public void insertFirst(E firstItem) {
        Node<E> newHead = new Node<>(firstItem);
        if (this.size == 0) {
            this.head = newHead;
            this.tail = newHead;
            this.size++;
        } else {
            newHead.ConnectTo(this.head);
            this.head = head.getPrevious();
            this.size++;
        }
    }

    /**
     *
     * @param previousItem
     * @param newItem
     * @deprecated
     */
    public void insertAfter(E previousItem, E newItem) {

        if (tail.getItem().equals(previousItem)) {// insert after tail = insertLast
            insertLast(newItem);

        } else if (head.getItem().equals(previousItem)) {// insert newNode After head
            Node<E> newNode = new Node<>(newItem);
            newNode.ConnectTo(head.getNext());
            this.head.ConnectTo(newNode);
            this.size++;

        } else {
            Node<E> currentNode = head; // to get the previousNode
            while (!currentNode.getNext().getItem().equals(previousItem)) {
                if (!currentNode.hasNext()) {
                    throw new IllegalArgumentException("There isn't any node cotains previousItem");
                }
                currentNode = currentNode.getNext();
            }
            // now we got the previousNode (wanted)
            Node<E> newNode = new Node<>(newItem);
            newNode.ConnectTo(currentNode.getNext());
            currentNode.ConnectTo(newNode);
            size++;
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
                all += " ⇄ ";
            }
        }
        return all;
    }

    class Node<E> {

        private final E item;
        private Node<E> next;
        private Node<E> previous;

        Node(E item) {
            this.item = item;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getItem() {
            return item;
        }

        public boolean hasNext() {
            return next != null;
        }

        public boolean hasPrevious() {
            return previous != null;
        }

        public void ConnectTo(Node<E> next) {
            this.next = next;
            if (next != null) {
                next.setPrevious(this);
            }
        }

        @Override
        public String toString() {
            return getItem().toString();
        }
    }
}
