package DataStructures.Queues.Tests;

import DataStructures.Queues.Deque;

/**
 *
 * @author khalil2535
 */
public class DequeTest {

    public static void main(String[] args) {
        Deque<String> x = new Deque<>(10);
        x.addFirst("a");
        x.addFirst("b");
        x.addFirst("c");
        x.addFirst("d");
        x.addFirst("e");
        x.addFirst("f");
        x.addLast("1");
        x.addLast("2");
        x.addLast("3");
        x.addLast("4");
        x.addLast("5"); // can't add it return false
        System.out.println(x);
        System.out.println(x.getFirst());
        System.out.println(x.getLast());
        for (int i = 0; i < 2; i++) {
            x.removeFirst();
        }
        for (int i = 0; i < 8; i++) {
            x.removeLast();
        }
        System.out.println(x);
    }
}
