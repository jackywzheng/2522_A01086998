package ca.bcit.comp2522.assignments.A4;

import ca.bcit.comp2522.assignments.A4.ArraySet;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ArraySetTest {

    private ArraySet<String> testArraySet;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @org.junit.Before
    public void setUp() throws Exception {
        testArraySet = new ArraySet<>();
        for (int i = 0; i < ArraySet.INITIAL_CAPACITY; i++) {
            testArraySet.add(String.format("Index %d", i));
        }
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

    }
    @Test
    public void addingExistingElementReturnsFalse() {
    }
    @Test
    public void addingNullElementDoesNotAddToArraySet() {
    }
    @Test
    public void addingNullElementReturnsFalse() {
    }
    @Test
    public void addNewElementInsertsElementAtEndOfArraySet() {
    }
    @Test
    public void addNewElementReturnsTrue() {
    }
    @Test
    public void addingNewElementExpandsArrayIfArrayIsFull() {
    }
    @Test
    public void addingNewElementDoublesArraySizeIfArrayIsFull() {
    }
    @Test
    public void addingNewElementIncreasesElementCount() {
    }

    //adding a different element type will not add.(boolean)
    //adding a different element type will not add.(double)
    //adding a different element type will not add.(int)

    @Test
    public void elementSuccessfullyRemoved() {
    }
    @Test
    public void elementNotSuccessfullyRemoved() {
    }
    @Test
    public void elementCountNotChangedForUnsuccessfulRemoval() {
    }
    @Test
    public void elementCountChangedForSuccessfulRemoval() {
    }
    @Test
    public void lastElementIsSwappedToNullWhenElementIsRemoved() {
    }
    @Test
    public void lastElementIsNotSwappedIfLastElementIsRemoved() {
    }

    @Test
    public void clearEmptySetSizeEqualsZero() {
    }
    @Test
    public void clearNonEmptySetSizeEqualsZero() {
    }

    @Test
    public void containsReturnTrueForExistingElement() {
    }
    @Test
    public void containsReturnFalseForNonExistentElement() {
    }
    @Test
    public void containsHandlesNullElement() {
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



