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

        System.out.println(tree);

        assertTrue(tree.contains(5));
        assertFalse(tree.contains(115));
        assertEquals(4, tree.getSize());
    }
}