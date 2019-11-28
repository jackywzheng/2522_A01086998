package ca.bcit.comp2522.assignments.A4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


public class ArraySetTest {

    private ArraySet<String> testArraySet;
    private ArraySet<String> testEmptySet;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @org.junit.Before
    public void setUp() throws Exception {
        testArraySet = new ArraySet<>();

        for (int i = 0; i < ArraySet.INITIAL_CAPACITY; i++) {
            testArraySet.add(String.format("Index %d", i));
        }
        testEmptySet = new ArraySet<>();
    }

    @Test
    public void containsConstantCalledINITIAL_CAPACITY() {
        assertEquals(10, ArraySet.INITIAL_CAPACITY);
    }

//    @Test (NOT POSSIBLE WITH PRIVATE FIELD VARIABLES)
//    public void capacityGreaterThanElementCount() {
//        assertTrue(testArraySet.size() < testArraySet.getCapacity());
//    }

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
        assertEquals(newElement, strings[strings.length-1]);
    }

    @Test
    public void addNewElementReturnsTrue() {
        assertTrue(testArraySet.add("newElement"));
    }

//    @Test (NOT POSSIBLE WITH PRIVATE FIELD VARIABLES)
//    public void addingNewElementExpandsArrayIfArrayIsFull() {
//        int capacity = testArraySet.getCapacity();
//        testArraySet.add("newElement");
//        int capacityNew = testArraySet.getCapacity();
//        assertTrue(capacity < capacityNew);
//    }

//    @Test (NOT POSSIBLE WITH PRIVATE FIELD VARIABLES)
//    public void addingNewElementDoublesArraySizeIfArrayIsFull() {
//        int capacity = testArraySet.getCapacity();
//        testArraySet.add("newElement");
//        int capacityNew = testArraySet.getCapacity();
//        assertEquals(capacity*2, capacityNew);
//    }

    @Test
    public void addingNewElementIncreasesElementCount() {
        int size = testArraySet.size();
        testArraySet.add("newElement");
        assertEquals(++size, testArraySet.size());
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
    public void containsHandlesNullElement() {
        assertFalse(testArraySet.contains(null));
    }

    @Test
    public void sizeEqualsZeroForEmptyArraySet() {
    }
    @Test
    public void sizeEqualsNumberOfElementsInArraySet() {
    }
    @Test
    public void sizeReturnsInt() {
    }

    @Test
    public void toArrayReturnsArrayWithSameSizeAsArraySet() {
    }
    @Test
    public void toArrayReturnsArrayWithSizeZeroIfEmptyArraySet() {
    }

    @Test
    public void toArrayReturnsCorrectElementType() {

    }

    @Test
    public void toArrayReturnsArrayOfIdenticalElementTypes() {

    }

    @Test
    public void toArrayReturnsArrayWithSameElementsAsArraySet() {

    }

    @Test
    public void iteratorContainsSameElementsAsOriginalArraySet() {
    }

    @Test
    public void hasNextReturnsTrueIfNextElementExists() {
    }
    @Test
    public void hasNextReturnsFalseIfNoNextElementExists() {
    }

    @Test
    public void nextReturnsElementIfExists() {
    }
    @Test
    public void nextReturnsNullIfNoNextElementExists() {
    }
}