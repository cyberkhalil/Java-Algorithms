package data_structures.graph;

import java.util.ArrayList;

/**
 *
 * @author khalil2535
 * @param <E>
 */
public class UnDirectedGraph<E> {

    ArrayList<vertix<E>> vertixes;

    public UnDirectedGraph() {
        this.vertixes = new ArrayList<>();
    }

    /**
     *
     * @param entity
     * @return true if added or false if not
     */
    public boolean addEntity(E entity) {
        if (!contatin(entity)) {
            return vertixes.add(new vertix<>(entity));
        } else {
            return false;
        }
    }

    /**
     *
     * @param entity1
     * @param entity2
     * @return true if added or false if not
     */
    public boolean addConnection(E entity1, E entity2) {
        if (contatin(entity1) && contatin(entity2)) {
            return vertixOf(entity1).connect(vertixOf(entity2));
        }
        return false;
    }

    /**
     *
     * @param entity
     * @return true if contains or false if not
     */
    public boolean contatin(E entity) {
        return vertixes.stream().anyMatch((v) -> (v.item == entity));
    }

    /**
     *
     * @param entity
     * @return the vertix for the entity
     */
    private vertix<E> vertixOf(E entity) {
        for (vertix<E> vertix : vertixes) {
            if (vertix.item == entity) {
                return vertix;
            }
        }
        return null;
    }

    class vertix<E> {

        E item;
        ArrayList<vertix<E>> connections;

        public vertix(E entity) {
            this.item = entity;
            connections = new ArrayList<>();
        }

        public boolean connect(vertix<E> v) {
            if (connections.contains(v)) {
                return false;
            } else {
                connections.add(v);
                v.connections.add(this);
                return true;
            }
        }

        @Override
        public String toString() {
            return item.toString();
        }

    }

    @Override
    public String toString() {
        return vertixes.toString();
    }

}
