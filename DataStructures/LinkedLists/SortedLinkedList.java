package DataStructures.LinkedLists;

/**
 * Sorted LinkedList but Integer data type only
 *
 * @author khalil2535
 */
public class SortedLinkedList {

    private Node root;

    public SortedLinkedList(int firstNumber) {
        root = new Node(firstNumber);
    }

    public SortedLinkedList() {
        root = null;
    }

    public void addNumber(int number) {
        if (root != null) {
            Node currentNode = root;
            if (root.getNumber() < number) {
                root = new Node(number);
                root.setNext(currentNode);
            } else {
                while (currentNode.hasNext()) {
                    if (currentNode.getNext().getNumber() < number) {
                        Node newNode = new Node(number);
                        newNode.setNext(currentNode.getNext());
                        currentNode.setNext(newNode);
                        return;
                    }
                    currentNode = currentNode.getNext();
                }
                currentNode.setNext(new Node(number));
            }
        } else {
            root = new Node(number);
        }
    }

    public boolean removeNumber(int number) {
        if (root == null) {
            return false;
        } else {
            Node currentNode = root;
            if (currentNode.getNumber() == number) {
                root = root.getNext();
                return true;
            } else {
                while (currentNode.hasNext()) {
                    if (currentNode.getNext().getNumber() == number) {
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
            Node currentNode = root;
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

    class Node {

        private final int number;
        private Node next;

        Node(int number) {
            this.number = number;
        }

        /**
         * @return the next
         */
        public Node getNext() {
            return next;
        }

        /**
         * @param next the next to set
         */
        public void setNext(Node next) {
            this.next = next;
        }

        /**
         * @return the number
         */
        public int getNumber() {
            return number;
        }

        @Override
        public String toString() {
            return number + " ";
        }

        public boolean hasNext() {
            return next != null;
        }

    }

}
