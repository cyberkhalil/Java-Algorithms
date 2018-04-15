package data_structures.stacks;

public class Stack<T> {

    private T items[];
    int pointer;

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
