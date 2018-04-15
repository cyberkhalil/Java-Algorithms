package data_structures.trees.tests;

import data_structures.trees.Tree;

/**
 *
 * @author khalil2535
 */
public class TreeTest {

    public static void main(String[] args) {
        // pre order
        System.out.println("Pre Order Tree");
        Tree<String> mytree = new Tree<>("Book");
        mytree.add2Root("Title");
        mytree.add2Root("Introduction");
        mytree.add2Root("Chapter 1");
        mytree.addToNode(2, "Section 1");
        mytree.addToNode(2, "Section 2");
        mytree.add2Root("Chapter 2");
        mytree.addToNode(3, "Section 1");
        mytree.addToNode(3, "Section 2");
        mytree.addToNode(3, "Section 3");
        mytree.add2Root("Chapter 3");
        System.out.println(mytree.preOrder());
        System.out.println("");

        // in order
        System.out.println("In order Tree");
        mytree = new Tree<>("+");
        mytree.add2Root("*");
        mytree.addToNode(0, "1");
        mytree.addToNode(0, "2");
        mytree.add2Root("-");
        mytree.addToNode(1, "5");
        mytree.addToNode(1, "3");
        System.out.println(mytree.inOrder());
    }

    private TreeTest() {
    }

}
