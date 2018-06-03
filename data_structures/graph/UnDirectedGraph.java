package data_structures.graph;

import java.util.ArrayList;

/**
 *
 * @author khalil2535
 * @param <E>
 */
public class UnDirectedGraph<E> {

    ArrayList<Vertex<E>> vertexes;

    public UnDirectedGraph() {
        this.vertexes = new ArrayList<>();
    }

    /**
     *
     * @param entity
     * @return true if added or false if not
     */
    public boolean addEntity(E entity) {
        if (!contatin(entity)) {
            return vertexes.add(new Vertex<>(entity));
        } else {
            return false;
        }
    }

    /**
     *
     * @param entity1
     * @param entity2
     * @param space
     * @return true if added or false if not
     */
    public boolean addConnection(E entity1, E entity2, int space) {
        if (contatin(entity1) && contatin(entity2)) {
            return vertexOf(entity1).connect(vertexOf(entity2), space);
        }
        return false;
    }

    /**
     *
     * @param entity
     * @return true if contains or false if not
     */
    public boolean contatin(E entity) {
        return vertexes.stream().anyMatch((v) -> (v.item == entity));
    }

    /**
     *
     * @param entity
     * @return the Vertex for the entity
     */
    private Vertex<E> vertexOf(E entity) {
        for (Vertex<E> vertex : vertexes) {
            if (vertex.item == entity) {
                return vertex;
            }
        }
        return null;
    }

    /**
     *
     * @deprecated not supported yet
     */
    public ArrayList<E> dfs() {
        ArrayList<Vertex<E>> unVisitedVertexes = (ArrayList<Vertex<E>>) vertexes.clone();
        ArrayList<E> visited = new ArrayList<>();
        Vertex<E> first = vertexes.get(0);// adding first item
        visited.add(first.item);
        Vertex<E> temp = first;
        // start dfs
        recursiveInnerDFS(visited, unVisitedVertexes, temp);
        // end
        return visited;
    }

    private void recursiveInnerDFS(ArrayList<E> visited, ArrayList<Vertex<E>> unVisited, Vertex<E> v) {
        v.connections.stream().map((connection) -> (Vertex<E>) connection[0]).forEachOrdered((temp) -> {
            if (!visited.contains(temp.item)) {
                visited.add(temp.item);
                unVisited.remove(temp);
            } else {
                recursiveInnerDFS(visited, unVisited, temp);
            }
        });

    }

    @Override
    public String toString() {
        return vertexes.toString();
    }

    class Vertex<E> {

        E item;
        ArrayList<Object[]> connections;

        public Vertex(E entity) {
            this.item = entity;
            connections = new ArrayList<>();
        }

        public boolean connect(Vertex<E> v, int space) {
            if (inRealtionWith(v)) {
                return false;
            }
            Object[] a1 = new Object[2];
            a1[0] = v;
            a1[1] = space;
            connections.add(a1);
            Object[] a2 = new Object[2];
            a2[0] = this;
            a2[1] = space;
            v.connections.add(a2);
            return true;
        }

        @Override
        public String toString() {
            return item.toString();
        }

        public boolean inRealtionWith(Vertex<E> v) {
            return connections.stream().anyMatch((connection) -> (connection[0] == v));
        }

    }

}
