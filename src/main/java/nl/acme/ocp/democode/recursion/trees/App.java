package nl.acme.ocp.democode.recursion.trees;

public class App {
    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();
        tree.put(10);
        tree.put(5);
        tree.put(5);
        tree.put(20);
        tree.put(17);

        System.out.println(tree.toString());
    }
}
