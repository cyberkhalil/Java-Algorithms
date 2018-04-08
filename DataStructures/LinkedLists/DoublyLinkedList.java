package DataStructures.LinkedLists;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        size = 0;
    }

    public DoublyLinkedList(Node Head, Node Tail, int Size) {
        this.head = Head;
        this.tail = Tail;
        this.size = Size;
    }

    public DoublyLinkedList(Node Head, Node Tail) {
        this.head = Head;
        this.tail = Tail;
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

    public void removeFirst() {
        head = head.getNext();
        head.setPrevious(null);
        size--;
    }

    public void removeLast() {
        tail = tail.getPrevious();
        tail.setNext(null);
        size--;
    }

    public void insertLast(Node node) {
        if (size == 0) {
            this.head = node;
            this.tail = node;
            this.size++;
        } else {
            this.tail.setNext(node);
            node.setPrevious(tail);
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
            this.head.setPrevious(newHead);
            this.head = newHead;
            this.size++;
        }
    }

    public void insertAfter(Node previousNode, Node newNode) {
        if (head.toString().equals(previousNode.toString())) {
            newNode.setNext(head.getNext());
            this.head.getNext().setPrevious(newNode);
            this.head.setNext(newNode);
            newNode.setPrevious(head);
            this.size++;
        } else if (tail.toString().equals(previousNode.toString())) {
            insertLast(newNode);
        } else {
            Node currentNode = head.getNext();
            while (!currentNode.getNext().toString().equals(previousNode.toString())) {
                if (currentNode.getNext() == null) {
                    throw new IllegalArgumentException("There is no node equal previosNode");
                }
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.getNext().setPrevious(newNode);
            currentNode.setNext(newNode);
            newNode.setPrevious(currentNode);
            size++;
        }
    }

    @Override
    public String toString() {
        String all = "";
        Node currentnode = head;
        while (currentnode != null) {
            all += currentnode.toString();
            currentnode = currentnode.getNext();
            if (currentnode != null) {
                all += " ⇄ ";
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
