package DataStructures.Trees;

import java.util.ArrayList;

/**
 * @Todo Post order
 *
 * @author khalil2535
 * @param <E> Element
 */
public class Tree<E> {

    public static void main(String[] args) {
        // pre order
        System.out.println("Pre Order Tree");
        Tree mytree = new Tree("Book");
        mytree.add2root("Title");
        mytree.add2root("Introduction");
        mytree.add2root("Chapter 1");
        mytree.addToNode(2, "Section 1");
        mytree.addToNode(2, "Section 2");
        mytree.add2root("Chapter 2");
        mytree.addToNode(3, "Section 1");
        mytree.addToNode(3, "Section 2");
        mytree.addToNode(3, "Section 3");
        mytree.add2root("Chapter 3");
        System.out.println(mytree.preOrder());
        // in order
        System.out.println("In order Tree");
        mytree = new Tree("+");
        mytree.add2root("*");
        mytree.addToNode(0, "1");
        mytree.addToNode(0, "2");
        mytree.add2root("-");
        mytree.addToNode(1, "5");
        mytree.addToNode(1, "3");
        System.out.println(mytree.inOrder());
    }

    private Node root;

    /**
     *
     * @param item
     */
    public Tree(E item) {
        this.root = new Node(item);
    }

    public Tree(Node root) {
        this.root = root;
    }

    public String preOrder() {
        if (root == null) {
            return "";
        } else {
            String myTree = root.toString();
            for (int i = 0; i < root.getChildernNumber(); i++) {
                myTree += "\n  " + new Tree((Node) root.getChildrens().get(i)).preOrderWithS("      ");
            }
            return myTree;
        }
    }

    private String preOrderWithS(String s) {
        if (root == null) {
            return "";
        } else {
            String myTree = root.toString();
            for (int i = 0; i < root.getChildernNumber(); i++) {
                myTree += "\n " + s + new Tree((Node) root.getChildrens().get(i)).preOrderWithS(s + s);
            }
            return myTree;
        }
    }

    public String inOrder() {
        if (root == null) {
            return "";
        } else {

            String myTree = "";
            for (int i = 0; i < root.getChildernNumber() / 2; i++) {
                myTree += "(" + new Tree((Node) root.getChildrens().get(i)).inOrder();
            }
            myTree += root.toString();
            for (int i = root.getChildernNumber() / 2; i < root.getChildernNumber(); i++) {
                myTree += new Tree((Node) root.getChildrens().get(i)).inOrder() + ")";
            }
            return myTree;
        }
    }

    public boolean add2root(E item) {
        return getRoot().addChildren(item);
    }

    public boolean addToNode(int i, E item) {
        return ((Node) getRoot().getChildrens().get(i)).addChildren(item);
    }

    /**
     * @return the root
     */
    public Node getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(Node root) {
        this.root = root;
    }
}

class Node<E> {

    private ArrayList<Node> children;
    private final E item;

    Node(E item) {
        children = new ArrayList<>();
        this.item = item;
    }

    public boolean addChildren(E childItem) {
        return this.children.add(new Node(childItem));
    }

    @Override
    public String toString() {
        return this.item.toString();
    }

    public ArrayList<Node> getChildrens() {
        return this.children;
    }

    public E getItem() {
        return this.item;
    }

    public int getChildernNumber() {
        return children.size();
    }
}
