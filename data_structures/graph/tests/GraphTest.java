package data_structures.graph.tests;

import data_structures.graph.UnDirectedGraph;

/**
 *
 * @author khalil2535
 */
public class GraphTest {

    public static void main(String[] args) {
        UnDirectedGraph g = new UnDirectedGraph();
        Object A = "A";
        Object B = "B";
        g.addEntity(A);
        g.addEntity(B);
        g.addConnection(A, B);
        System.out.println(g);

    }

}
