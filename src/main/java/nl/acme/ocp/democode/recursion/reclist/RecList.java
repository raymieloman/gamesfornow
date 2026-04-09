package nl.acme.ocp.democode.recursion.reclist;

import java.util.Iterator;

public class RecList<T extends Comparable<T>> implements Iterable<T> {

    private T value;
    private RecList<T> tail;

    public void add(T value) {
        if (this.value == null) {
            this.value = value;
            this.tail = new RecList<>();
        } else {
            tail.add(value);
        }
    }

    public T get(int index) {
        RecList<T> tree = get(index, 0);
        if (tree != null) {
            return tree.value;
        } else {
            return null;
        }
    }

    private RecList<T> get(int index, int current) {
        if (this.value == null) {
            return null;
        }
        if (index == current) {
            return this;
        } else {
            return tail.get(index, ++current);
        }
    }

    public void update(int index, T value) {
        RecList<T> tree = get(index, 0);
        if( tree != null) {
            tree.value = value;
        }
    }

    public void sort() {
        if (this.value == null || tail.value == null) {
            return; // 0 or 1 elements — already sorted
        }

        // Bubble the largest value toward the tail
        if (this.value.compareTo(tail.value) > 0) {
            T temp = this.value;
            this.value = tail.value;
            tail.value = temp;
        }

        // Recursively sort the tail
        tail.sort();

        // After the tail is sorted, the current node might be out of order
        // again relative to the new tail head, so do one more pass
        if (this.value.compareTo(tail.value) > 0) {
            T temp = this.value;
            this.value = tail.value;
            tail.value = temp;
            tail.sort();
        }
    }

    @Override
    public String toString() {
        if (this.value == null) {
            return "";
        } else {
            return this.value + " " + this.tail;
        }
    }

    public int size() {
        if (this.value == null) {
            return 0;
        } else {
            return 1 + tail.size();
        }
    }

    public boolean contains(Object value) {
        if (this.value == null) return false;
        return this.value.equals(value) || tail.contains(value);
    }

    public boolean delete(Object value) {
        if (this.value == null) {
            return false;
        }
        if (this.value.equals(value)) {
            this.value = tail.value;
            this.tail = tail.tail;

            return true;
        }
        return tail.delete(value);
    }


    static class RecListIterator<T extends Comparable<T>> implements Iterator<T> {
        private RecList<T> recList;

        RecListIterator(RecList<T> recList) {
            this.recList = recList;
        }

        @Override
        public boolean hasNext() {
            return recList.value != null;
}

        @Override
        public T next() {
            T value = recList.value;
            recList = recList.tail;

            return value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new RecListIterator<>(this);
    }
}