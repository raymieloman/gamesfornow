package nl.acme.ocp.exercises.recursion.trees;

import static nl.acme.utils.Assertion.*;

public class App {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.put(10);
        tree.put(5);
        tree.put(5);
        tree.put(20);
        tree.put(17);
        tree.putAll(10, 5, 13, 82, 233);

        System.out.println(tree);

        assertTrue(tree.contains(5));
        assertFalse(tree.contains(115));
        assertEquals(7, tree.size());
    }
}