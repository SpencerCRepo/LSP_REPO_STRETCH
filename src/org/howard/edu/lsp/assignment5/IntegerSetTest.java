package org.howard.edu.lsp.assignment5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test cases for IntegerSet.
 */
public class IntegerSetTest {

    /**
     * Test 1: largest() throws IllegalStateException on empty set.
     */
    @Test
    public void testLargestEmptySetThrowsException() {
        IntegerSet set = new IntegerSet();
        assertThrows(IllegalStateException.class, () -> set.largest());
    }

    /**
     * Test 2: add() does not insert duplicates.
     */
    @Test
    public void testAddDuplicateNotInserted() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        set.add(5);
        assertEquals(1, set.length());
    }

    /**
     * Test 3: equals() returns true regardless of insertion order.
     */
    @Test
    public void testEqualsIgnoresOrder() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2); a.add(3);
        b.add(3); b.add(1); b.add(2);
        assertTrue(a.equals(b));
    }

    /**
     * Test 4: union() of two non-overlapping sets contains all elements.
     */
    @Test
    public void testUnionNoOverlap() {
        IntegerSet a = new IntegerSet();
        IntegerSet b = new IntegerSet();
        a.add(1); a.add(2);
        b.add(3); b.add(4);
        IntegerSet result = a.union(b);
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
        assertTrue(result.contains(4));
        assertEquals(4, result.length());
    }

    /**
     * Test 5: remove() on an element not in the set does not throw or alter the set.
     */
    @Test
    public void testRemoveElementNotPresent() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.remove(99);
        assertEquals(2, set.length());
        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
    }
}