package by.lab1.task6;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class MatrixCreatorTest {
    @Test
    void testOnNonEmptyInitSequence() {
        MatrixCreator matrixCreator = new MatrixCreator();
        double[] initValues = {0, 1, 2, 3, 4};
        double[][] res = {
                {0, 1, 2, 3, 4},
                {1, 2, 3, 4, 0},
                {2, 3, 4, 0, 1},
                {3, 4, 0, 1, 2},
                {4, 0, 1, 2, 3}
        };
        assertArrayEquals(res, matrixCreator.create(initValues));
    }

    @Test
    void testOnEmptyInitSequence() {
        MatrixCreator matrixCreator = new MatrixCreator();
        double[] initValues = {};
        double[][] res = new double[0][0];
        assertArrayEquals(res, matrixCreator.create(initValues));
    }
}
