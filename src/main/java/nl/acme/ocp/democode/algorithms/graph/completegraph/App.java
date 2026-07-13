package nl.acme.ocp.democode.algorithms.graph.completegraph;

import nl.acme.utils.Assertion;

public class App {
    public static void main(String[] args) {
        System.out.println(countConnections(1)); //0
        System.out.println(countConnections(2)); // 1
        System.out.println(countConnections(3)); // 3
        Assertion.assertEquals(3, countConnections(3));
        Assertion.assertEquals(6, countConnections(4));
        Assertion.assertEquals(10, countConnections(5));
    }

    // calculates the number of undirected connections in a complete graph
    public static int countConnections(int n) {
        return n*(n-1)/2;
    }
}
