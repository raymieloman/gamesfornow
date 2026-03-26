package nl.acme.ocp.exercises.recursion.trees;

public class BinarySearchTree {

    private Integer value;
    private BinarySearchTree left;
    private BinarySearchTree right;

    public void put(int value) {
        if (this.value == null) {
            this.value = value;
            left = new BinarySearchTree();
            right = new BinarySearchTree();
        } else {
            if (value == this.value) {
                return;
            }
            if (value < this.value) {
                left.put(value);
            } else {
                right.put(value);
            }
        }
    }

    public boolean contains(int value) {
        if (this.value == null) {
            return false;
        }
        if (value == this.value) {
            return true;
        }
        if (value < this.value) {
            return left.contains(value);
        } else {
            return right.contains(value);
        }
    }

    public void putAll(int... values) {
        for (int value : values) {
            this.put(value);
        }
    }

    // size daarmee bedoel ik: = het aantal nodes van de complete tree
    public int size() {
        return this.value == null ? 0 : 1 + left.size() + right.size();
    }

    @Override
    public String toString() {
        if (this.value == null) {
            return "";
        } else {
            return String.format("%s[%s]%s", left, value, right);
        }
    }
}
