package DataStructures.Stacks;

import javax.swing.JOptionPane;

public class Stack<T> {

    private T items[];
    int pointer;

    /*
    public static void main(String[] args) {
        Stack Strings = new Stack<String>(10);
        String name = JOptionPane.showInputDialog("Enter Your name to flop : ");
        while (!name.isEmpty()) {
            Strings.push(name.subSequence(0, 1));
            name = (String) name.subSequence(1, name.length());
        }
        System.out.println(Strings.toString());
        name = "";
        while (!Strings.isEmpty()) {
            name += Strings.pop().toString().toLowerCase();
        }
        JOptionPane.showMessageDialog(null, "Flopped name : " + name);
    }
     */
    public Stack(int capacity) {
        items = (T[]) new Object[capacity];
        pointer = -1;
    }

    public boolean isEmpty() {
        return (pointer == -1);
    }

    public boolean isFull() {
        return (pointer == items.length - 1);
    }

    public void push(T element) {
        if (isFull()) {
            throw new StackOverflowError("The stack is full");
        } else {
            items[++pointer] = element;
        }

    }

    public T pop() {
        if (!isEmpty()) {
            return items[pointer--];
        } else {
            throw new ArrayStoreException("There is no Elements to pop");
        }
    }

    public T showTop() {
        if (!isEmpty()) {
            return items[pointer];
        } else {
            throw new ArrayStoreException("There is no Elements to show");
        }
    }

    public int size() {
        return pointer + 1;
    }

    @Override
    public String toString() {
        String stack = "------------\n";
        for (int i = 0; i < pointer + 1; i++) {
            stack += items[i].toString() + "\n";
        }
        stack += "------------";
        return stack;
    }
}
