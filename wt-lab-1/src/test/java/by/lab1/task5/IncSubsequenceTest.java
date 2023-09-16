package by.lab1.task5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class IncSubsequenceTest {
    @Test
    void testOnRandomSequence() {
        IncSubsequence incSubsequence = new IncSubsequence();
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        assertEquals(4, incSubsequence.getCorrectionNum(arr));
    }

    @Test
    void testOnEmptySequence() {
        IncSubsequence incSubsequence = new IncSubsequence();
        int[] arr = {};
        assertEquals(0, incSubsequence.getCorrectionNum(arr));
    }

    @Test
    void testOnSequenceWithEqualValues() {
        IncSubsequence incSubsequence = new IncSubsequence();
        int[] arr = {7, 7, 7, 7, 7, 7, 7};
        assertEquals(6, incSubsequence.getCorrectionNum(arr));
    }
}
