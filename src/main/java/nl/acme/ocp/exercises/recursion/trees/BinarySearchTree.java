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
        assertTrue(isBalanced());
    }

    public int depth() {
        if(this.value == null) return 0;
        int leftDepth = 1+this.left.depth();
        int rightDepth = 1+this.right.depth();

        return Math.max(leftDepth, rightDepth);
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
        if (!isBalanced()) {
            if (left.size() > right.size()) {
                int n = left.largest();
                swapWithCurrent(n);
            } else {
                int n = right.smallest();
                swapWithCurrent(n);
            }
        }
    }

    private void swapWithCurrent(int n) {
        int current = this.value;
        delete(n);
        this.value = n;
        add(current);
    }

    public void add(int value) {
        put(value);
    }

    public void delete(int n) {
        if (this.value.equals(n)) {
            if (isLeaf()) {
                this.value = null;
                this.left = null;
                this.right = null;
            } else {
                if (left.size() <= right.size()) {
                    int rightSmallest = right.smallest();
                    right.delete(rightSmallest);
                    this.value = rightSmallest;
                } else {
                    int leftLargest = left.largest();
                    left.delete(leftLargest);
                    this.value = leftLargest;
                }
            }
        } else {
            if (n <= this.value) {
                left.delete(n);
            } else {
                right.delete(n);
            }
        }
        rebalance();
    }
    public void pp() {
        if (this.value == null) return;
        if (this.left != null) {
            System.out.print("[");
            left.pp();
        }
        System.out.print(value != null ? value : "");
        System.out.print("]");
        if (this.right != null) {
            System.out.print("[");
            right.pp();
        }
        System.out.print("]");
    }


    public boolean isLeaf() {
        return this.size() <= 1;
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
