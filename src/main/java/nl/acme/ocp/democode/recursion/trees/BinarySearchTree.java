package nl.acme.ocp.democode.recursion.trees;

public class BinarySearchTree {

    private Integer value;
    private BinarySearchTree left;
    private BinarySearchTree right;

    public void put(int newValue) {
        if (this.value == null) {
            this.value = newValue;
            left = new BinarySearchTree();
            right = new BinarySearchTree();
        } else {
            if (newValue == value) {
                return;
            }
            if (newValue < this.value) {
                left.put(newValue);
            } else {
                right.put(newValue);
            }
        }
    }

    public boolean contains(int value) {
        if (this.value == null) {
            return false;
        }
        if (value == this.value) {
            return true;
        } else {
            if (value < this.value) {
                return left.contains(value);
            } else {
                return right.contains(value);
            }
        }
    }

    // size daarmee bedoel ik: = het aantal nodes
    public int getSize() {
        if (this.value == null) {
            return 0;
        } else {
            return 1 + left.getSize() + right.getSize();
        }
    }

    @Override
    public String toString() {
        // rloman dit kan een stuk cleaner! Foei!
        return (left == null ? "": "<" + left.toString()) + "/<"+  (this.value == null ? "" : "[" + this.value+"]") + (right == null ? "" : ">" + right.toString()+ "/>");
    }
}
