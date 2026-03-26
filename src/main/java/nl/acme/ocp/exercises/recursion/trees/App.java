package nl.acme.ocp.exercises.recursion.trees;

import static nl.acme.utils.Assertion.*;

public class App {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.put(10);
        tree.put(5);
        assertTrue(tree.isBalanced());
        tree.put(20);

        tree.put(17);
        assertTrue(tree.isBalanced());
        tree.put(21);
        assertEquals(5, tree.smallest());
//        assertTrue(tree.isBalanced()); // fails now
        tree.putAll(10, 5, 13, 82, 233);
        assertEquals(233, tree.largest());

        System.out.println(tree);

        assertTrue(tree.contains(5));
        assertFalse(tree.contains(115));
    }
}