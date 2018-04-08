package DataStructures.Queues.Tests;

import DataStructures.Queues.Queue;

/**
 *
 * @author khalil2535
 */
public class QueueTest {

    public static void main(String[] args) throws Exception {

        Queue<String> myQueue = new Queue<>(5);
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
        System.out.println("Adding item : " + 0);
        myQueue.inQueue("0");
        System.out.println("is the queue full : " + myQueue.isFull());
        System.out.println(myQueue);
    }
}
