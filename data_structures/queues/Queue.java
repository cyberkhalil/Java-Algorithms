package data_structures.queues;

import java.util.Arrays;

public class Queue<T> {

    private int nitems;
    private int rear;
    private int front;
    private final T[] array;

    public Queue(int capacity) {
        array = (T[]) new Object[capacity];
        front = 0;
        nitems = 0;
        rear = -1;
    }

    public T[] getArray() {
        return array;
    }

    public void inQueue(T item) throws Exception {
        if (isFull()) {
            throw new Exception("the queue is full");
        }
        if (rear == array.length - 1) {
            rear = -1;
            array[++rear] = item;
        } else {
            array[++rear] = item;
        }
        nitems++;
    }

    public T deQueue() throws Exception {
        if (isEmpty()) {
            throw new Exception("the queue is empty");
        } else if (front == array.length - 1) {
            front = 0;
        }
        nitems--;
        return array[front++];
    }

    public boolean isFull() {
        return array.length == nitems;
    }

    public boolean isEmpty() {
        return nitems == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}
