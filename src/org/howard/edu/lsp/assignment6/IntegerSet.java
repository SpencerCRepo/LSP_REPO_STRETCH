package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;


public class IntegerSet {

    /** Internal storage for set elements. */
    private ArrayList<Integer> set = new ArrayList<>();

    /**
     Creates an empty IntegerSet.
     */
    public IntegerSet() {}

    /**

     * @param set the ArrayList to initialize the set with
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = new ArrayList<>(set);
    }

    /**
     * Removes all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**

     * @return the number of elements in the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Returns true if this set and the given set contain exactly the same element
     * @param b the IntegerSet to compare with
     * @return true if both sets contain the same elements, false otherwise
     */
    public boolean equals(IntegerSet b) {
        if (this.length() != b.length()) return false;
        ArrayList<Integer> copy = new ArrayList<>(b.set);
        for (int val : set) {
            if (!copy.remove(Integer.valueOf(val))) return false;
        }
        return copy.isEmpty();
    }

    /**
     * Returns true if the set contains the specified value.
     * @param value the integer to search for
     * @return true if the value is found, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest element in the set.
     * @return the maximum integer in the set
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (isEmpty()) throw new IllegalStateException("Set is empty");
        return Collections.max(set);
    }

    /**
     * Returns the smallest element in the set.
     *
     * @return the minimum integer in the set
     * @throws IllegalStateException if the set is empty
     */
    public int smallest() {
        if (isEmpty()) throw new IllegalStateException("Set is empty");
        return Collections.min(set);
    }

    /**
     * Adds an item to the set. Does nothing if the item is already present.
     *
     * @param item the integer to add
     */
    public void add(int item) {
        if (!contains(item)) set.add(item);
    }

    /**
     * Removes an item from the set. Does nothing if the item is not present.
     *
     * @param item the integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new set containing all elements from both this set and intSetb.
     * Does not modify either original set.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the union of both sets
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet(this.set);
        for (int val : intSetb.set) {
            result.add(val);
        }
        return result;
    }

    /**

     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the intersection of both sets
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet(this.set);
        result.set.retainAll(intSetb.set);
        return result;
    }

    /**
     * Returns a new set containing elements in this set but not in intSetb.
     * Does not modify either original set.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the difference (this - intSetb)
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet(this.set);
        result.set.removeAll(intSetb.set);
        return result;
    }

    /**
     * Returns a new set containing elements in intSetb but not in this set.
     * Does not modify either original set.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the complement (intSetb - this)
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet(intSetb.set);
        result.set.removeAll(this.set);
        return result;
    }

    /**
     * Returns true if the set contains no elements.
     *
     * @return true if the set is empty, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set in ascending order.
     * Format: [1, 2, 3] or [] for an empty set.
     *
     * @return string representation of the set
     */
    @Override
    public String toString() {
        ArrayList<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        return sorted.toString();
    }
}