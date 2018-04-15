package data_structures.queues;

/**
 *
 * @author khalil2535
 * @param <E> (Element)
 */
public class Deque<E> {

    int capi;
    private E[] items;
    private int size;
    /**
     * Forward Pointer
     */
    int fP;
    /**
     * Backward Pointer
     */
    int bP;

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
        return getSize() == 0;
    }

    public E getFirst() {
        if (!isEmpty()) {
            if (getItems()[fP] != null) {
                return getItems()[fP];
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
            if (getItems()[bP] != null) {
                return getItems()[bP];
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
        return capi == getSize();
    }

    public boolean removeFirst() {
        if (!isEmpty()) {
            fP = ((fP - 1) + capi) % capi;
            if (getItems()[fP] != null) {
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
            if (getItems()[bP] != null) {
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
        return java.util.Arrays.toString(getItems());
    }

    public E[] getItems() {
        return items;
    }

}
