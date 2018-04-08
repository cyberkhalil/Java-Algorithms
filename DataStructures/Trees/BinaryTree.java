package DataStructures.Trees;

/**
 *
 * @author khalil2535
 * @param <Sortable> Item
 */
public class BinaryTree<Sortable> {

    public static void main(String[] args) {
        Student s1 = new Student("s1", 18);
        Student s2 = new Student("s2", 20);
        Student s3 = new Student("s3", 19);
        Student s4 = new Student("s4", 22);
        Student s5 = new Student("s5", 15);
        Student s6 = new Student("s6", 25);
        Student s7 = new Student("s7", 21);
        BinaryTree b = new BinaryTree(s1);
        b.addItem(s2);
        b.addItem(s3);
        b.addItem(s4);
        b.addItem(s5);
        b.addItem(s6);
        b.addItem(s7);
        System.out.println("Before Delete :-");
        System.out.println(b);
        System.out.println("After Delete :-");
        b.deleteItem(s7);
        System.out.println(b);
    }

    private Node root;

    public BinaryTree(Sortable rootItem) {
        root = new Node(rootItem);
    }

    public BinaryTree() {
    }

    public boolean deleteItem(Sortable item) {
        if (FindItem(item)) {   // To be sure that there is a parent
            String wantedNodeDirection = "";
            Node parentForWantedNode = GetParentNode(item);
            Node wantedNode = GetNode(item);
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

    public boolean addItem(Sortable item) {
        if (root == null) {
            root = new Node(item);
        } else {
            Node curentNode = root;
            boolean placeFound = false;
            while (!placeFound) {
                if (item.getSortBy() > ((Sortable) curentNode.getItem()).getSortBy()) {
                    if (!curentNode.hasRightNode()) {
                        return curentNode.setRight(new Node(item));
                    } else {
                        curentNode = curentNode.getRight();
                    }
                } else {
                    if (!curentNode.hasLeftNode()) {
                        return curentNode.setLeft(new Node(item));
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
    public boolean FindItem(Sortable item) {
        if (root == null) {
            return false;
        } else if (root.getItem() != item) {
            Node curentNode = root;
            boolean placeFound = false;
            while (!placeFound) {
                if (item.getSortBy() > ((Sortable) curentNode.getItem()).getSortBy()) {
                    if (curentNode.hasRightNode()) {
                        if (curentNode.getRight().getItem() == item) {
                            return placeFound = true;
                        } else {
                            curentNode = curentNode.getRight();
                        }
                    } else {
                        return placeFound;
                    }
                } else {
                    if (curentNode.hasLeftNode()) {
                        if (curentNode.getLeft().getItem() == item) {
                            return placeFound = true;
                        } else {
                            curentNode = curentNode.getLeft();
                        }
                    } else {
                        return placeFound;
                    }
                }
            }
            return false; // i don't know why ._.
        } else {
            return true;
        }
    }

    private Node GetNode(Sortable item) {
        if (root == null) {
            return null;
        } else {
            Node curentNode = root;
            boolean placeFound = false;
            while (!placeFound) {
                if (item.getSortBy() > ((Sortable) curentNode.getItem()).getSortBy()) {
                    if (curentNode.hasRightNode()) {
                        if (curentNode.getRight().getItem() == item) {
                            return curentNode.getRight();
                        } else {
                            curentNode = curentNode.getRight();
                        }
                    } else {
                        return null;
                    }
                } else if (item.getSortBy() < ((Sortable) curentNode.getItem()).getSortBy()) {
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

    private Node GetParentNode(Sortable item) {
        if (root == null) {
            return null;
        } else {
            Node curentNode = root;
            boolean placeFound = false;
            while (!placeFound) {
                if (item.getSortBy() > ((Sortable) curentNode.getItem()).getSortBy()) {
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

    public String getItemPlace(Sortable item) {
        if (root == null) {
            return null;
        } else {
            String place = "";
            Node curentNode = root;
            boolean placeFound = false;
            while (!placeFound) {
                place += curentNode.toString();
                if (item.getSortBy() > ((Sortable) curentNode.getItem()).getSortBy()) {
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

    public Node getRoot() {
        return root;

    }

    class Node<Sortable> {

        private Sortable item;
        private Node left;
        private Node right;

        Node(Sortable item) {
            this.item = item;
        }

        public boolean setLeft(Node left) {
            this.left = left;
            return true;
        }

        public boolean setRight(Node right) {
            this.right = right;
            return true;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        @Override
        public String toString() {
            return getItem().toString();
        }

        /**
         * @return the item
         */
        public Sortable getItem() {
            return item;
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

        public Node getChild() {
            if (hasRightNode()) {
                return this.getRight();
            } else if (hasLeftNode()) {
                return this.getLeft();
            } else {
                return null;
            }
        }
    }

    @FunctionalInterface
    interface Sortable {

        public int getSortBy();

    }

}

class Student implements BinaryTree.Sortable {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int getSortBy() {
        return getAge();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return getName() + ": " + getAge();
    }

}
