package by.lab1.task3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class Task3Test {
    private static final double EPS = 0.0001;

    @Test
    void testTableOnRangeWithSeveralValues() {
        Task3 task3 = new Task3();
        double[][] table = task3.solve(-20, 20.1, 4);

        double[] expectedX = {-20, -16, -12, -8, -4, 0, 4, 8, 12, 16, 20};
        double[] expectedY = {-2.237160944224742, -0.3006322420239034,
                0.6358599286615808, 6.799711455220379, -1.1578212823495775,
                0.0, 1.1578212823495775, -6.799711455220379,
                -0.6358599286615808, 0.3006322420239034, 2.237160944224742};

        assertArrayEquals(expectedX, table[0], EPS);
        assertArrayEquals(expectedY, table[1], EPS);
    }

    @Test
    void testTableWhenLeftGreaterThanRight() {
        Task3 task3 = new Task3();
        double[][] table = task3.solve(20, 0.1, 4);
        assertNull(table);
    }
}
