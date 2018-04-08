package DataStructures.Queues;

import java.util.Arrays;

/**
 *
 * @author khalil2535
 * @param <E> (Element)
 */
public class Deque<E> {

    int capi;
    E[] items;
    int size;
    /**
     * Forward Pointer
     */
    int fP;
    /**
     * Backward Pointer
     */
    int bP;

    /*
    public static void main(String[] args) {
        Deque x = new Deque(10);
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
     */
    public Deque(int capi) {
        items = (E[]) new Object[capi];
        this.capi = capi;
        size = 0;
        fP = -1;
        bP = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E getFirst() {
        if (!isEmpty()) {
            if (items[fP] != null) {
                return items[fP];
            } else {
                fP = ((fP - 1) + capi) % capi;
                return getFirst();
            }
        } else {
            return null;
        }
    }

    public E getLast() {
        if (!isEmpty()) {
            if (items[bP] != null) {
                return items[bP];
            } else {
                bP = ((bP - 1) + capi) % capi;
                return getFirst();
            }
        } else {
            return null;
        }
    }

    public boolean addFirst(E item) {
        if (!isFull()) {
            fP = (fP + 1) % capi;

            items[fP] = item;
            size++;
            return true;
        } else {
            return false;
        }
    }

    public boolean addLast(E item) {
        if (!isFull()) {
            bP = ((bP - 1) + capi) % capi;

            items[bP] = item;
            size++;
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        return capi == size;
    }

    public boolean removeFirst() {
        if (!isEmpty()) {
            fP = ((fP - 1) + capi) % capi;
            if (items[fP] != null) {
                items[fP] = null;
                size--;
                return true;
            } else {
                return removeFirst();
            }
        } else {
            return false;
        }
    }

    public boolean removeLast() {
        if (!isEmpty()) {
            bP = (bP + 1) % capi;
            if (items[bP] != null) {
                items[bP] = null;
                size--;
                return true;
            } else {
                return removeLast();
            }
        } else {
            return false;
        }
    }

    public void clear() {
        items = (E[]) new Object[capi];
        size = 0;
        fP = -1;
        bP = 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

}
