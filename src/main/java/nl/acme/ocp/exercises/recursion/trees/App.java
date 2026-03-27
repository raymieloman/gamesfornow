package nl.acme.ocp.exercises.recursion.trees;

import static nl.acme.utils.Assertion.*;

public class App {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.put(10);
        tree.put(5);
        tree.put(20);

        tree.put(17);
        tree.put(21);
        assertEquals(5, tree.smallest());
        tree.putAll(10, 5, 13, 82, 233);
        assertEquals(233, tree.largest());
        assertTrue(tree.contains(5));
        assertFalse(tree.contains(115));

        System.out.println(tree.depth());
        System.out.println(tree);
    }
}