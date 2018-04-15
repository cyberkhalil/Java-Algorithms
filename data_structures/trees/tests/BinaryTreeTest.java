package data_structures.trees.tests;

import data_structures.trees.BinaryTree;

/**
 *
 * @author khalil2535
 */
public class BinaryTreeTest {

    public static void main(String[] args) {
        Student s1 = new Student("s1", 18);
        Student s2 = new Student("s2", 20);
        Student s3 = new Student("s3", 19);
        Student s4 = new Student("s4", 22);
        Student s5 = new Student("s5", 15);
        Student s6 = new Student("s6", 25);
        Student s7 = new Student("s7", 21);
        BinaryTree<Student> b = new BinaryTree<>(s1);
        b.addItem(s2);
        b.addItem(s3);
        b.addItem(s4);
        b.addItem(s5);
        b.addItem(s6);
        b.addItem(s7);
        System.out.println("Deleteing s7 \nBefore Delete :-");

        System.out.println(b);
        System.out.println("After Delete :-");
        b.deleteItem(s7);
        System.out.println(b);
    }

    private BinaryTreeTest() {
    }
}

class Student implements Comparable<Student> {

    private final String name;
    private final int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public int compareTo(Student o) {
        return this.age - o.getAge();
    }
}
