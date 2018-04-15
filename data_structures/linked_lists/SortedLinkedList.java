package data_structures.linked_lists;

/**
 * Sorted LinkedList but Integer data type only
 *
 * @author khalil2535
 * @param <E>
 */
public class SortedLinkedList<E extends Comparable<E>> {

    private Node<E> root;

    public SortedLinkedList(E firstItem) {
        root = new Node<>(firstItem);
    }

    public SortedLinkedList() {
        root = null;
    }

    public void add(E Item) {
        if (root != null) {
            Node<E> currentNode = root;
            if (root.getItem().compareTo(Item) < 0) {
                root = new Node<>(Item);
                root.setNext(currentNode);
            } else {
                while (currentNode.hasNext()) {
                    if (currentNode.getNext().getItem().compareTo(Item) < 0) {
                        Node<E> newNode = new Node<>(Item);
                        newNode.setNext(currentNode.getNext());
                        currentNode.setNext(newNode);
                        return;
                    }
                    currentNode = currentNode.getNext();
                }
                currentNode.setNext(new Node<>(Item));
            }
        } else {
            root = new Node<>(Item);
        }
    }

    public boolean remove(E item) {
        if (root == null) {
            return false;
        } else {
            Node<E> currentNode = root;
            if (currentNode.getItem().compareTo(item) == 0) {
                root = root.getNext();
                return true;
            } else {
                while (currentNode.hasNext()) {
                    if (currentNode.getNext().getItem().compareTo(item) == 0) {
                        currentNode.setNext(currentNode.getNext().getNext());
                        return true;
                    }
                    currentNode = currentNode.getNext();
                }
                return false;
            }
        }
    }

    @Override
    public String toString() {
        if (root != null) {
            Node<E> currentNode = root;
            String allString = "";
            do {
                if (!allString.isEmpty()) {
                    allString += " -> ";
                }
                allString += currentNode.toString();
                currentNode = currentNode.getNext();
            } while (currentNode != null);
            return allString;
        } else {
            return null;
        }
    }

    class Node<E extends Comparable<E>> {

        private final E item;
        private Node<E> next;

        Node(E item) {
            this.item = item;
        }

        /**
         * @return the next
         */
        public Node<E> getNext() {
            return next;
        }

        /**
         * @param next the next to set
         */
        public void setNext(Node<E> next) {
            this.next = next;
        }

        /**
         * @return the number
         */
        public E getItem() {
            return item;
        }

        public boolean hasNext() {
            return next != null;
        }

        @Override
        public String toString() {
            return item + " ";
        }

    }

}
