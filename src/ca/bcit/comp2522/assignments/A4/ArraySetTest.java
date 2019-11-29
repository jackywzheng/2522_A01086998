package ca.bcit.comp2522.assignments.A4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

/**
 * Unit tests for ArraySet.
 *
 * @author Jacky Zheng
 * @author Frey Tolman
 * @version 2019/11/26
 */
public class ArraySetTest {

    private ArraySet<String> testArraySet;
    private ArraySet<String> testEmptySet;
    private ArraySet<Integer> testIntArraySet;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @org.junit.Before
    public void setUp() throws Exception {
        testArraySet = new ArraySet<>();

        for (int i = 0; i < ArraySet.INITIAL_CAPACITY; i++) {
            testArraySet.add(String.format("Index %d", i));
        }
        testEmptySet = new ArraySet<>();

        testIntArraySet = new ArraySet<>();
    }



    @Test
    public void containsConstantCalledINITIAL_CAPACITY() {
        assertEquals(10, ArraySet.INITIAL_CAPACITY);
    }

    @Test
    public void elementCountEqualToNumberOfElementsInArraySet() {
        int count = 0;
        for (Object o : testArraySet.toArray()) {
            if (o != null) {
                ++count;
            }
        }
        assertEquals(count, testArraySet.size());
    }

    @Test
    public void elementCountIsZeroWhenArraySetIsInitialized() {
        assertEquals(testEmptySet.size(), 0);
    }


    @Test
    public void addingExistingElementDoesNotAddToArraySet() {
        int size = testArraySet.size();
        testArraySet.add("Index 1");
        testArraySet.add("Index 2");
        testArraySet.add("Index 3");
        testArraySet.add("Index 4");
        testArraySet.add("Index 5");
        assertEquals(size, testArraySet.size());
    }

    @Test
    public void addingExistingElementReturnsFalse() {
        assertFalse(testArraySet.add("Index 1"));
        assertFalse(testArraySet.add("Index 2"));
        assertFalse(testArraySet.add("Index 3"));
        assertFalse(testArraySet.add("Index 4"));
        assertFalse(testArraySet.add("Index 5"));
    }

    @Test
    public void addingNullElementDoesNotAddToArraySet() {
        int size = testArraySet.size();
        testArraySet.add(null);
        testArraySet.add(null);
        assertEquals(size, testArraySet.size());
    }

    @Test
    public void addingNullElementReturnsFalse() {
        assertFalse(testArraySet.add(null));
    }

    @Test
    public void addNewElementInsertsElementAtEndOfArraySet() {
        String newElement = "Index 11";
        testArraySet.add(newElement);
        Object[] strings = testArraySet.toArray();
        assertEquals(newElement, strings[strings.length - 1]);
    }

    @Test
    public void addNewElementReturnsTrue() {
        assertTrue(testArraySet.add("newElement"));
    }

    @Test
    public void addOneElementIncreasesElementCountByOne() {
        int size = testArraySet.size();
        testArraySet.add("newElement");
        assertEquals(++size, testArraySet.size());
    }

    @Test
    public void addTenElementsIncreasesElementCountByTen() {
        for (int i = 0; i < 10; i++) {
            testIntArraySet.add(i);
        }
        assertEquals(testIntArraySet.size(), 10);
    }

    @Test
    public void addDoublesCapacityIfFull() {
        for (int i = 0; i < 20; i++) {
            testIntArraySet.add(i);
        }
        assertEquals(testIntArraySet.size(), 20);
    }

    @Test
    public void elementSuccessfullyRemovedReturnsTrue() {
        assertTrue(testArraySet.remove("Index 1"));
    }

    @Test
    public void elementNotSuccessfullyRemovedReturnsFalse() {
        assertFalse(testArraySet.remove(null));
    }

    @Test
    public void elementCountNotChangedForUnsuccessfulRemoval() {
        int size = testArraySet.size();
        testArraySet.remove(null);
        assertEquals(size, testArraySet.size());
    }

    @Test
    public void elementCountChangedForSuccessfulRemoval() {
        int size = testArraySet.size();
        testArraySet.remove("Index 5");
        assertEquals(--size, testArraySet.size());
    }

    @Test
    public void lastElementIsSwappedToRemovedElementIndex() {
        Object[] strings = testArraySet.toArray();
        String lastElement = strings[strings.length-1].toString();

        assertTrue(testArraySet.remove("Index 5"));
        strings = testArraySet.toArray();
        assertEquals(lastElement, strings[5]);
    }

    @Test
    public void lastElementIsNotSwappedIfLastElementIsRemoved() {
        Object[] strings = testArraySet.toArray();
        String lastElement = strings[strings.length-1].toString();

        assertTrue(testArraySet.remove("Index 9"));
        assertFalse(testArraySet.contains(lastElement));
    }

    @Test
    public void clearEmptySetSizeEqualsZero() {
        assertEquals(0, testEmptySet.size());
        testEmptySet.clear();
        assertEquals(0, testEmptySet.size());
    }

    @Test
    public void clearNonEmptySetSizeEqualsZero() {
        assertTrue(testArraySet.size() > 0);
        testArraySet.clear();
        assertEquals(0, testArraySet.size());
    }

    @Test
    public void containsReturnTrueForExistingElement() {
        assertTrue(testArraySet.contains("Index 1"));
    }

    @Test
    public void containsReturnFalseForNonExistentElement() {
        assertFalse(testArraySet.contains("Index 10"));
    }

    @Test
    public void containsReturnFalseForEmptyArraySet() {
        assertFalse(testEmptySet.contains(null));
    }

    @Test
    public void containsHandlesNullElement() {
        assertFalse(testArraySet.contains(null));
    }

    @Test
    public void resizeContainsOldCollectionData() {
        for (int i = 0; i < 100; i++) {
            testIntArraySet.add(i);
            assertTrue(testIntArraySet.contains(i));
        }
    }

    @Test
    public void sizeEqualsNumberOfElementsInArraySet() {
        for (int i = 0; i < 10; i++) {
            testIntArraySet.add(i);
        }
        assertEquals(testIntArraySet.size(), 10);
    }

    @Test
    public void sizeReturnsInt() {
        assertTrue(Integer.class.isInstance(testArraySet.size()));
    }

    @Test
    public void toArrayReturnsArrayWithSameSizeAsArraySet() {
        assertEquals(testArraySet.size(), testArraySet.toArray().length);
    }

    @Test
    public void toArrayReturnsArrayWithSizeZeroIfEmptyArraySet() {
        ArraySet<Integer> emptyArraySet = new ArraySet<>();
        assertEquals(emptyArraySet.toArray().length, 0);
    }

    @Test
    public void toArrayReturnsArrayOfIdenticalElementTypes() {
        ArraySet<Integer> intArraySet = new ArraySet<>();
        intArraySet.add(1);
        Object[] intArray = intArraySet.toArray();
        for (Object i : intArray) {
            assertTrue(intArraySet.contains((int) i));
        }
    }

    @Test
    public void toArrayContainsAllElementsOfArraySetInOrder() {
        for (int i = 0; i < 10; i++) {
            testIntArraySet.add(i);
        }
        ArraySet.SetIterator it = testIntArraySet.iterator();
        int count = 0;
        while (it.hasNext()) {
            Object testInt = it.next();
            assertEquals(testInt, count);
            count++;
        }
    }

    @Test
    public void hasNextReturnsTrueIfIterationHasMoreElements() {
        for (int i = 0; i < 10; i++) {
            testIntArraySet.add(i);
        }
        ArraySet.SetIterator it = testArraySet.iterator();
        assertTrue(it.hasNext());
    }

    @Test
    public void hasNextReturnsTrueIfIterationHasOneElement() {
        testIntArraySet.add(1);
        ArraySet.SetIterator it = testIntArraySet.iterator();
        assertTrue(it.hasNext());
    }

    @Test
    public void hasNextReturnsFalseOnEmptyArraySet() {
        ArraySet.SetIterator it = testIntArraySet.iterator();
        assertFalse(it.hasNext());
    }


    @Test
    public void nextReturnsNextElementInArraySet() {
        ArraySet.SetIterator it = testIntArraySet.iterator();
        for (int i = 0; i < 100; i++) {
            testIntArraySet.add(i);
            assertEquals(it.next(), i);
        }
    }

    @Test
    public void nextReturnsNullInEmptyArraySet() {
        ArraySet.SetIterator it = testEmptySet.iterator();
        assertNull(it.next());
    }

    @Test
    public void nextDoesNotReturnNullIfNonEmptyArraySet() {
        ArraySet.SetIterator it = testIntArraySet.iterator();
        testIntArraySet.add(1);
        assertEquals(it.next(), 1);
    }
}
