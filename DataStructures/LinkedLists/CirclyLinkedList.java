package DataStructures.LinkedLists;

/**
 * @author khalil2535
 * @param <E>
 */
public class CirclyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public CirclyLinkedList() {
        size = 0;
    }

    public CirclyLinkedList(E item) {
        tail = new Node<>(item);
        head = tail;
        head.ConnectTo(tail);
        size = 1;
    }

    public CirclyLinkedList(E head, E tail) {
        if (head != null) {
            this.head = new Node<>(head);
            this.tail = new Node<>(tail);
            size = head == tail ? 1 : 2;
            this.head.ConnectTo(this.tail);
        }
    }

    public void removeFirst() {
        if (size > 1) {
            head = head.getNext();
            tail.ConnectTo(head);
            size--;
        } else if (size == 1) {
            head = null;
            tail = null;
            size--;
        } else {
            throw new UnsupportedOperationException("There is nothing to remove");
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

    public void insertFirst(E head) {
        Node<E> newHead = new Node<>(head);
        if (this.size == 0) {
            this.head = newHead;
            this.tail = newHead;
            this.tail.ConnectTo(this.head);
            this.size++;
        } else {
            newHead.ConnectTo(this.head);
            this.head = newHead;
            this.size++;
        }
    }

    public void insertAfter(E previousItem, E newItem) {
        Node<E> newNode = new Node<>(newItem);
        if (head.getItem().equals(previousItem)) {
            newNode.ConnectTo(head.getNext());
            this.head.setNext(newNode);
            this.size++;
            if (this.tail == null) {
                this.tail = newNode;
            }
        } else {
            Node<E> currentNode = head.getNext();
            while (!currentNode.getNext().getItem().equals(previousItem)) {
                if (currentNode.getNext() == null) {
                    throw new IllegalArgumentException("There is no node equal previosNode");
                }
                currentNode = currentNode.getNext();
            }
            newNode.ConnectTo(currentNode.getNext());
            currentNode.ConnectTo(newNode);
            size++;
            if (newNode.getNext() == null) {
                tail = newNode;
            }

        }
    }

    @Override
    public String toString() {
        String all = "↱> ";
        Node<E> currentnode = head;
        while (true) {
            all += currentnode.toString();
            currentnode = currentnode.getNext();
            if (currentnode.getNext() != head) {
                all += " -> ";
            } else {
                all += " <↰";
                int Length = all.length();
                all += "\n";
                while (Length != 0) {
                    all += "⇋";
                    Length--;
                }
                break;
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
            next = null;
            previous = null;
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

        public void ConnectTo(Node<E> next) {
            this.next = next;
            if (next != null) {
                next.setPrevious(this);
            }
        }

        public E getItem() {
            return item;
        }

        @Override
        public String toString() {
            return getItem().toString();
        }
    }
}
