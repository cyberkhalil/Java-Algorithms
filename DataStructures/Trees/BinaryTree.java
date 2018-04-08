package DataStructures.Trees;

/**
 *
 * @author khalil2535
 * @param <E>
 */
public class BinaryTree<E extends Comparable<E>> {

    private Node<E> root;

    public BinaryTree(E rootItem) {
        root = new Node<>(rootItem);
    }

    public BinaryTree() {
    }

    public boolean deleteItem(E item) {
        if (FindItem(item)) {   // To be sure that there is a parent
            String wantedNodeDirection = "";
            Node<E> parentForWantedNode = GetParentNode(item);
            Node<E> wantedNode = GetNode(item);
            if (parentForWantedNode != null && parentForWantedNode.hasLeftNode() && parentForWantedNode.getLeft() == wantedNode) {
                wantedNodeDirection = "L";
            } else if (parentForWantedNode != null && parentForWantedNode.hasRightNode() && parentForWantedNode.getRight() == wantedNode) {
                wantedNodeDirection = "R";
            } else { // if the node doesn't have any parent (the node = root)
                if (!root.hasAnyChild()) {  // Case 1
                    root = null;
                    return true;
                } else if (wantedNode.hasLeftNode() && !wantedNode.hasRightNode()) { // Case 2 Left
                    root = wantedNode.getLeft();
                    return true;
                } else if (wantedNode.hasRightNode() && !wantedNode.hasLeftNode()) {// Case 2 Right
                    root = wantedNode.getRight();
                    return true;
                } else {
                    if (!wantedNode.getLeft().hasRightNode()) {// Case 2 Left
                        wantedNode.getLeft().setRight(root.getRight());
                        root = wantedNode.getLeft();
                        return true;
                    } else if (!wantedNode.getRight().hasLeftNode()) {// Case 2 Right
                        wantedNode.getRight().setLeft(root.getLeft());
                        root = wantedNode.getRight();
                        return true;
                    } else {    // Case 3
                        Node searchedNode = wantedNode.getLeft().getRight();
                        if (!searchedNode.hasAnyChild()) {
                            searchedNode.setLeft(wantedNode.getLeft());
                            searchedNode.setRight(wantedNode.getRight());
                            wantedNode.getLeft().setRight(null);
                            root = searchedNode;
                            return true;
                        } else {    // Case 3
                            while (searchedNode.getChild().hasAnyChild()) {
                                searchedNode = searchedNode.getChild();
                            }
                            searchedNode.getChild().setLeft(root.getLeft());
                            searchedNode.getChild().setRight(root.getRight());
                            root = searchedNode.getChild();
                            if (searchedNode.getRight().equals(searchedNode.getChild())) {
                                searchedNode.setRight(null);
                            } else {
                                searchedNode.setLeft(null);
                            }
                            return true;
                        }
                    }
                }
            }
            if (!wantedNode.hasAnyChild()) {  // Case 1
                if (wantedNodeDirection.equals("L")) {
                    return parentForWantedNode.setLeft(null);
                } else {
                    return parentForWantedNode.setRight(null);
                }
            } else if (wantedNode.hasLeftNode() && !wantedNode.getLeft().hasRightNode()) { // Case 2
                if (wantedNodeDirection.equals("L")) {    // if the node parent left == the node
                    wantedNode.getLeft().setRight(wantedNode.getRight());
                    return parentForWantedNode.setLeft(wantedNode.getLeft());
                } else {    // if the node parent right == the node
                    wantedNode.getLeft().setRight(wantedNode.getRight());
                    return parentForWantedNode.setRight(wantedNode.getLeft());
                }
            } else if (wantedNode.hasRightNode() && !wantedNode.getRight().hasLeftNode()) { // Case 2
                if (wantedNodeDirection.equals("L")) {
                    wantedNode.getRight().setLeft(wantedNode.getLeft());
                    return parentForWantedNode.setLeft(wantedNode.getRight());  // remove the parent node left
                } else {
                    wantedNode.getRight().setLeft(wantedNode.getLeft());
                    return parentForWantedNode.setRight(wantedNode.getRight()); // remove the parent node right
                }
            } else { // Case 3
                Node searchedNode = wantedNode.getLeft().getRight();
                if (!searchedNode.hasAnyChild()) {
                    wantedNode.getLeft().setRight(null);
                    searchedNode.setLeft(wantedNode.getLeft());
                    searchedNode.setRight(wantedNode.getRight());
                    parentForWantedNode = searchedNode;
                } else {    // Case 3
                    while (searchedNode.getChild().hasAnyChild()) {
                        searchedNode = searchedNode.getChild();
                    }
                    searchedNode.getChild().setLeft(wantedNode.getLeft());
                    searchedNode.getChild().setRight(wantedNode.getRight());
                    wantedNode = searchedNode.getChild();
                    if (searchedNode.getRight().equals(searchedNode.getChild())) {
                        searchedNode.setRight(null);
                    } else {
                        searchedNode.setLeft(null);
                    }
                    return true;
                }
                if (wantedNodeDirection.equals("L")) {    // if the node parent left == the node
                    return parentForWantedNode.setLeft(searchedNode);   // remove the parent node left
                } else {// if the node parent right == the node
                    return parentForWantedNode.setRight(searchedNode);  // remove the parent node right
                }
            }
        } else { // we didn't find the node to remove
            return false;
        }
    }

    /**
     *
     * @param root the node which we want to print tree from
     * @param s the String that will be between tree nodes
     * @return all the tree as String
     */
    public String getTreeAsString(Node root, String s) {
        if (root == null) {
            return "";
        } else {
            String Tree = "";
            Tree += root.toString() + "\n";
            if (root.hasLeftNode() && root.hasRightNode()) {
                Tree += s + "│\n";
                Tree += s + ("├─L─ " + getTreeAsString(root.getLeft(), s + "  "));
                Tree += s + "│\n";
                Tree += s + ("└─R─ " + getTreeAsString(root.getRight(), s + "  "));
            } else if (root.hasLeftNode()) {
                Tree += s + ("└─L─ " + getTreeAsString(root.getLeft(), s + "  "));
            } else if (root.hasRightNode()) {
                Tree += s + ("└─R─ " + getTreeAsString(root.getRight(), s + "  "));
            }

            return Tree;

        }
    }

    @Override
    public String toString() {
        return getTreeAsString(root, " ");
    }

    public boolean addItem(E item) {
        if (root == null) {
            root = new Node<>(item);
        } else {
            Node<E> curentNode = root;
            boolean placeFound = false;
            while (!placeFound) {
                if (item.compareTo(curentNode.getItem()) > 0) {
                    if (!curentNode.hasRightNode()) {
                        return curentNode.setRight(new Node<>(item));
                    } else {
                        curentNode = curentNode.getRight();
                    }
                } else {
                    if (!curentNode.hasLeftNode()) {
                        return curentNode.setLeft(new Node<>(item));
                    } else {
                        curentNode = curentNode.getLeft();
                    }
                }
            }
        }
        return true;
    }

    /**
     *
     * @param item
     * @return true if the item found in the tree or false if the item not found
     * in the tree
     */
    public boolean FindItem(E item) {
        if (root == null) {
            return false;
        } else if (root.getItem() != item) {
            Node<E> curentNode = root;
            boolean placeFound = false;
            while (!placeFound) {
                if (item.compareTo(curentNode.getItem()) > 0) {
                    if (curentNode.hasRightNode()) {
                        if (curentNode.getRight().getItem() == item) {
                            return true;
                        } else {
                            curentNode = curentNode.getRight();
                        }
                    } else {
                        return placeFound;
                    }
                } else {
                    if (curentNode.hasLeftNode()) {
                        if (curentNode.getLeft().getItem() == item) {
                            return true;
                        } else {
                            curentNode = curentNode.getLeft();
                        }
                    } else {
                        return placeFound;
                    }
                }
            }
            return false;
        } else {
            return true;
        }
    }

    private Node<E> GetNode(E item) {
        if (root == null) {
            return null;
        } else {
            Node<E> curentNode = root;
            boolean placeFound = false;
            while (!placeFound) {
                if (item.compareTo(curentNode.getItem()) > 0) {
                    if (curentNode.hasRightNode()) {
                        if (curentNode.getRight().getItem() == item) {
                            return curentNode.getRight();
                        } else {
                            curentNode = curentNode.getRight();
                        }
                    } else {
                        return null;
                    }
                } else if (item.compareTo(curentNode.getItem()) < 0) {
                    if (curentNode.hasLeftNode()) {
                        if (curentNode.getLeft().getItem() == item) {
                            return curentNode.getLeft();
                        } else {
                            curentNode = curentNode.getLeft();
                        }
                    } else {
                        return null;
                    }
                } else {
                    return curentNode;
                }

            }
        }
        return null;
    }

    private Node<E> GetParentNode(E item) {
        if (root == null) {
            return null;
        } else {
            Node<E> curentNode = root;
            boolean placeFound = false;
            while (!placeFound) {
                if (item.compareTo(curentNode.getItem()) > 0) {
                    if (curentNode.hasRightNode()) {
                        if (curentNode.getRight().getItem() == item) {
                            return curentNode;
                        } else {
                            curentNode = curentNode.getRight();
                        }
                    } else {
                        return null;
                    }
                } else {
                    if (curentNode.hasLeftNode()) {
                        if (curentNode.getLeft().getItem() == item) {
                            return curentNode;
                        } else {
                            curentNode = curentNode.getLeft();
                        }
                    } else {
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public String getItemPlace(E item) {
        if (root == null) {
            return null;
        } else {
            String place = "";
            Node<E> curentNode = root;
            boolean placeFound = false;
            while (!placeFound) {
                place += curentNode.toString();
                if (item.compareTo(curentNode.getItem()) > 0) {
                    if (curentNode.hasRightNode()) {
                        if (curentNode.getRight().getItem() == item) {
                            place += " - R > ";
                            place += curentNode.getRight().toString();
                            placeFound = true;
                        } else {
                            place += " - R > ";
                            curentNode = curentNode.getRight();

                        }
                    }
                } else {
                    if (curentNode.hasLeftNode()) {
                        if (curentNode.getLeft().getItem() == item) {
                            place += " - L > ";
                            placeFound = true;
                            place += curentNode.getLeft().toString();
                        } else {
                            place += " - L > ";
                            curentNode = curentNode.getLeft();
                        }
                    } else {
                        break;
                    }
                }
            }
            if (placeFound) {
                return place;
            } else {
                return "Place not found";
            }
        }
    }

    public Node<E> getRoot() {
        return root;

    }

    class Node<E extends Comparable<E>> {

        private final E item;
        private Node<E> left;
        private Node<E> right;

        Node(E item) {
            this.item = item;
        }

        public boolean setLeft(Node<E> left) {
            this.left = left;
            return true;
        }

        public boolean setRight(Node<E> right) {
            this.right = right;
            return true;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        @Override
        public String toString() {
            return getItem().toString();
        }

        /**
         * @return the item
         */
        public E getItem() {
            return (E) item;
        }

        public String getAllTreeString() {
            String allTree = "";
            allTree += this.toString();
            if (this.right != null || this.left != null) {
                allTree += "{";
                if (this.right != null) {
                    allTree += "R(" + right.getAllTreeString() + ")";
                }
                if (this.left != null) {
                    allTree += "L(" + left.getAllTreeString() + ")";
                }
                return allTree + "}";
            } else {
                return allTree;
            }
        }

        public boolean hasLeftNode() {
            return left != null;
        }

        public boolean hasRightNode() {
            return right != null;
        }

        public boolean hasAnyChild() {
            return hasRightNode() || hasLeftNode();
        }

        public Node<E> getChild() {
            if (hasRightNode()) {
                return this.getRight();
            } else if (hasLeftNode()) {
                return this.getLeft();
            } else {
                return null;
            }
        }
    }
}
