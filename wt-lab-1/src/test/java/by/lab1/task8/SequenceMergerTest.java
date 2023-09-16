package by.lab1.task8;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SequenceMergerTest {
    @Test
    void shouldReturnNullOnEqualElementsInNewSequence() {
        int[] first = {1, 3, 5, 7, 9, 11};
        int[] second = {2, 4, 6, 7, 10, 12};
        SequenceMerger sequenceMerger = new SequenceMerger();
        int[] res = sequenceMerger.mergeSequences(first, second);
        assertArrayEquals(null, res);
    }

    @Test
    void shouldReturnNullOnEqualElementsInFirstSequence() {
        int[] first = {1, 3, 5, 7, 7, 11};
        int[] second = {2, 4, 6, 8, 10, 12};
        SequenceMerger sequenceMerger = new SequenceMerger();
        int[] res = sequenceMerger.mergeSequences(first, second);
        assertArrayEquals(null, res);
    }

    @Test
    void shouldReturnNullOnEqualElementsInSecondSequence() {
        int[] first = {1, 3, 5, 7, 9, 11};
        int[] second = {2, 4, 6, 8, 8, 12};
        SequenceMerger sequenceMerger = new SequenceMerger();
        int[] res = sequenceMerger.mergeSequences(first, second);
        assertArrayEquals(null, res);
    }

    @Test
    void shouldReturnInsertionIndexesWhenAllElementsUnique() {
        int[] first = {1, 4, 6, 7, 9};
        int[] second = {2, 3, 5, 8, 10, 11, 12};
        SequenceMerger sequenceMerger = new SequenceMerger();
        int[] res = sequenceMerger.mergeSequences(first, second);
        int[] expected = {1, 2, 4, 7, 9, 10, 11};
        assertArrayEquals(expected, res);
    }
}
