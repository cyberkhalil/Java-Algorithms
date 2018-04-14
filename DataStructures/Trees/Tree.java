package DataStructures.Trees;

import java.util.ArrayList;

/**
 * @Todo Post order
 *
 * @author khalil2535
 * @param <E> Element
 */
public class Tree<E> {

    private Node<E> root;

    /**
     *
     * @param item
     */
    public Tree(E item) {
        this.root = new Node<>(item);
    }

    public String preOrder() {
        if (root == null) {
            return "";
        } else {
            String myTree = root.toString();
            for (int i = 0; i < root.getChildernNumber(); i++) {
                myTree += "\n  " + new Tree<>(root.getChildrens().get(i)).preOrderWithS("      ");
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
                myTree += "\n " + s + new Tree<>(root.getChildrens().get(i)).preOrderWithS(s + s);
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
                myTree += "(" + new Tree<>(root.getChildrens().get(i)).inOrder();
            }
            myTree += root.toString();
            for (int i = root.getChildernNumber() / 2; i < root.getChildernNumber(); i++) {
                myTree += new Tree<>(root.getChildrens().get(i)).inOrder() + ")";
            }
            return myTree;
        }
    }

    public boolean add2Root(E item) {
        return getRoot().addChildren(item);
    }

    public boolean addToNode(int i, E item) {
        return getRoot().getChildrens().get(i).addChildren(item);
    }

    /**
     * @return the root
     */
    public Node<E> getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(Node<E> root) {
        this.root = root;
    }
}

class Node<E> {

    private final ArrayList<Node<E>> children;
    private final E item;

    Node(E item) {
        children = new ArrayList<>(2);
        this.item = item;
    }

    public boolean addChildren(E childItem) {
        return this.children.add(new Node<>(childItem));
    }

    @Override
    public String toString() {
        return this.item.toString();
    }

    public ArrayList<Node<E>> getChildrens() {
        return this.children;
    }

    public E getItem() {
        return this.item;
    }

    public int getChildernNumber() {
        return children.size();
    }
}
