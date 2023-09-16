package by.lab1.task4;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SieveOfEratosthenesTest {
    @Test
    void testGetPrimesOnPositiveMaxNumber() {
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
        boolean[] trueIfPrime = sieveOfEratosthenes.getPrimes(19);
        boolean[] expected = {false, false, true, true, false, true, false,
                true, false, false, false, true, false, true, false, false,
                false, true, false, true};

        assertArrayEquals(expected, trueIfPrime);
    }

    @Test
    void testGetPrimesOnZeroMaxNumber() {
        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
        boolean[] trueIfPrime = sieveOfEratosthenes.getPrimes(0);
        boolean[] expected = {false};

        assertArrayEquals(trueIfPrime, expected);
    }
}
