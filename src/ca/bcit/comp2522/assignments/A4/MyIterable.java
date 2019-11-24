package ca.bcit.comp2522.assignments.A4;

/**
 * Provides a means to access an iterator.
 *
 * @author Your name
 * @author Your name
 * @version Date
 */

public interface MyIterable<E> {
    /**
     * Returns an iterator for a set of objects.
     * @pre true
     * @post Set is not changed
     * @return An iterator for the set of objects that points to the beginning of the set.
     */
    public MyIterator<E> iterator();
}
