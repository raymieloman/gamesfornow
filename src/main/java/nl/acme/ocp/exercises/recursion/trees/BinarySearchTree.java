package nl.acme.ocp.exercises.recursion.trees;

import static nl.acme.utils.Assertion.assertTrue;

public class BinarySearchTree {

    private Integer value;
    private BinarySearchTree left;
    private BinarySearchTree right;

    public void put(int value) {
        if (this.value == null) {
            this.value = value;
            left = new BinarySearchTree();
            right = new BinarySearchTree();
//            rebalance();
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
        rebalance();
//        assertTrue(isBalanced());
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

    public boolean isBalanced() {
        if (this.value == null) {
            return true;
        }
        return Math.abs(left.size() - right.size()) <= 1;
    }

    private void rebalance() {
        if (isBalanced()) {
            assertTrue(Math.abs(left.size()-right.size()) <= 1);
            return;
        }
        int compare = left.size() - right.size();
        if (compare < 0) {
            // right is too large
            int smallest = right.smallest();
            int current = this.value;
            this.value = smallest;
            System.out.printf("current: %d, smallest: %d%n", current, smallest );
            assertTrue(current != this.value);
            put(current);
        } else {
            // left is too large
            int largest = left.largest();
            int current = this.value;
            this.value = largest;
            assertTrue(current != this.value);
            put(current);
        }
    }

    public int smallest() {
        if (left.value == null) {
            return this.value;
        } else {
            return left.smallest();
        }
    }

    public int largest() {
        if (right.value == null) {
            return this.value;
        } else {
            return right.largest();
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
