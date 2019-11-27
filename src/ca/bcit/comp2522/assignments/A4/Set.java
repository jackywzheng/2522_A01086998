package ca.bcit.comp2522.assignments.A4;

/**
 * An unsorted, typed collection of objects with no duplicates
 * or nulls in the collection.
 *
 * @author Christopher Thompson
 * @version 2.0
 */
public interface Set<E> extends MyIterable<E> {

    /**
     * Adds a given object into the set.
     * @param newItem The object to be added to the set.
     * @pre true
     * @post IF ( newItem !=null AND NOT @pre.contains(newItem) )
     *       THEN contains(newItem)
     *       ELSE  the set is not changed
     * @return true if newItem was added to the set, false otherwise.
     */
    public boolean add(final E newItem);

    /**
     * Check if a given object is in the set.
     * @param item The object to be checked.
     * @pre true
     * @post true
     * @return true if item is in the set, and false otherwise.
     */
    public boolean contains(E item);

    /**
     * Removes a given object from the set.
     *
     * @param item
     *            The object to be removed.
     * @pre true
     * @post IF @pre.contains(item) THEN NOT contains(item) ELSE the set is not
     *       changed
     * @return true if item was removed from the set, and false otherwise.
     */
    public boolean remove(E item);

    /**
     * Creates and returns an array with all of the objects in the set.
     * @pre true
     * @post Set is not changed.
     * @return An unordered array containing all objects in the set.
     */
    public Object[] toArray();

    /**
     * Removes all elements from the set.
     * @pre true
     * @post size() = 0 
     */
    public void clear();

    /**
     * Returns the number of items in the set.
     * @pre true
     * @post true
     * @return The number of objects contained in the set.
     */
    public int size();
}
