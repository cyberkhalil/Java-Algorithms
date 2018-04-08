package DataStructures.LinkedLists;

/**
 * @author khalil2535
 */
public class CirclyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public CirclyLinkedList() {
        size = 0;
    }

    public void removeFirst() {
        if (size > 1) {
            head = head.getNext();
            tail.setNext(head);
            size--;
        } else if (size > 0) {
            head = null;
            tail = null;
        } else {
            throw new UnsupportedOperationException("There is nothing to remove");
        }
    }

    public CirclyLinkedList(Node Head, Node Tail, int Size) {
        this.head = Head;
        this.tail = Tail;
        head.setNext(tail);
        tail.setNext(head);
        this.size = Size;
    }

    public CirclyLinkedList(Node Head, Node Tail) {
        this.head = Head;
        this.tail = Tail;
        head.setNext(tail);
        tail.setNext(head);

        for (int i = 2;; i++) {
            if (Head == null) {
                throw new IllegalArgumentException("The Head don't reach the Tail");
            }
            if (Head.getNext() == Tail) {
                size = i;
                break;
            } else {
                Head = Head.getNext();
            }
        }
    }

    public void insert(Node node) {
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

    public void insertFirst(Node newHead) {
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

    public void insertAfter(Node previousNode, Node newNode) {
        if (head.toString().equals(previousNode.toString())) {
            newNode.setNext(head.getNext());
            this.head.setNext(newNode);
            this.size++;
            if (this.tail == null) {
                this.tail = newNode;
            }
        } else {
            Node currentNode = head.getNext();
            while (!currentNode.getNext().toString().equals(previousNode.toString())) {
                if (currentNode.getNext() == null) {
                    throw new IllegalArgumentException("There is no node equal previosNode");
                }
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
            size++;
            if (newNode.getNext() == null) {
                tail = newNode;
            }

        }
    }

    @Override
    public String toString() {
        String all = "↱> ";
        Node currentnode = head;
        while (true) {
            all += currentnode.toString();
            currentnode = currentnode.getNext();
            if (currentnode.getNext() != head) {
                all += " -> ";
            } else {
                all += " <↰";
                all += "\n";
                for (int i = 0; i < size; i++) {
                    all += "⇋⇋⇋⇋⇋⇋⇋⇋⇋";
                }
                break;
            }
        }
        return all;
    }

    static class Node {

        String name;
        Node next;
        Node previous;

        public Node getNext() {
            return next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node(String node_Name) {
            name = node_Name;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
