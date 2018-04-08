package DataStructures.Queues;

import java.util.Arrays;

public class Queue<T> {

    int nitems;
    int rear;
    int front;
    T[] array;

    /*
    public static void main(String[] args) throws Exception {

        Queue myQueue = new Queue(5);
        System.out.println("initialize queue \n");
        System.out.println("is the queue empty : " + myQueue.isEmpty());
        System.out.println("Adding item : " + 1);
        myQueue.inQueue("1");
        System.out.println("Adding item : " + 2);
        myQueue.inQueue("2");
        System.out.println("Adding item : " + 3);
        myQueue.inQueue("3");
        System.out.println("Adding item : " + 4);
        myQueue.inQueue("4");
        System.out.println("Adding item : " + 5);
        myQueue.inQueue("5");

        System.out.println("Removing item : " + myQueue.deQueue());
        System.out.println("Adding item : " + 0);myQueue.inQueue("0");
        System.out.println("is the queue full : " + myQueue.isFull());
        System.out.println(myQueue);
    }*/
    public Queue(int capacity) {
        array = (T[]) new Object[capacity];
        front = 0;
        nitems = 0;
        rear = -1;
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
