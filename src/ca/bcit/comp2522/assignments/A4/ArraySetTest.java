package ca.bcit.comp2522.assignments.A4;

import ca.bcit.comp2522.assignments.A4.ArraySet;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ArraySetTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @org.junit.Before
    public void setUp() throws Exception {
        ArraySet testArraySet = new ArraySet<>();
    }

    @Test
    public void containsConstantCalledINITIAL_CAPACITY() {
    }
    @Test
    public void capacityGreaterThanElementCount() {
    }
    @Test
    public void capacityEqualToElementCount() {
    }
    @Test
    public void elementCountEqualToNumberOfElementsInArraySet() {
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

