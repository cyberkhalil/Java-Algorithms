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
        Object C = "C";
        Object D = "D";
        Object E = "E";
        Object F = "F";
        Object G = "G";
        Object H = "H";
        Object I = "I";
        Object J = "J";
        g.addEntity(A);
        g.addEntity(B);
        g.addEntity(C);
        g.addEntity(D);
        g.addEntity(E);
        g.addEntity(F);
        g.addEntity(G);
        g.addEntity(H);
        g.addEntity(I);
        g.addEntity(J);
        g.addConnection(A, B, 1);
        g.addConnection(A, D, 1);
        g.addConnection(A, C, 1);
        g.addConnection(A, E, 1);
        g.addConnection(B, C, 1);
        g.addConnection(B, F, 1);
        g.addConnection(C, D, 1);
        g.addConnection(F, H, 1);
        g.addConnection(D, G, 1);
        g.addConnection(G, I, 1);
        System.out.println(g);
        System.out.println(g.dfs());

    }

}
