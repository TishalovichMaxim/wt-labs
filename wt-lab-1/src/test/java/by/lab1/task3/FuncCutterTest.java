package by.lab1.task3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import org.junit.jupiter.api.Test;

class FuncCutterTest {
    private static final double EPS = 0.0001;

    @Test
    void testCutOnTangentFuncAndGeneralRange() {
        FuncCutter funcCutter = new FuncCutter();
        List<Point> actualPoints = funcCutter.cut(Math::tan, -5, 5.1, 1);
        double[] actualX = actualPoints.stream()
                                        .mapToDouble(Point::x)
                                        .toArray();

        double[] actualY = actualPoints.stream()
                                        .mapToDouble(Point::y)
                                        .toArray();

        double[] expectedX = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        double[] expectedY = {3.380515006246586, -1.1578212823495775,
                0.1425465430742778, 2.185039863261519, -1.5574077246549023,
                0.0, 1.5574077246549023, -2.185039863261519,
                -0.1425465430742778, 1.1578212823495775, -3.380515006246586};

        assertArrayEquals(expectedX, actualX, EPS);
        assertArrayEquals(expectedY, actualY, EPS);
    }

    @Test
    void testCutWhenLeftGreaterThanRight() {
        FuncCutter funcCutter = new FuncCutter();
        List<Point> actualPoints = funcCutter.cut(Math::tan, 5, -5.1, 1);
        assertNull(actualPoints);
    }

    @Test
    void testCutWhenOnlyOnePointInInterval() {
        FuncCutter funcCutter = new FuncCutter();
        List<Point> actualPoints = funcCutter.cut(Math::tan, Math.PI, 4, 10);
        double[] actualX = actualPoints.stream()
                                        .mapToDouble(Point::x)
                                        .toArray();

        double[] actualY = actualPoints.stream()
                                        .mapToDouble(Point::y)
                                        .toArray();

        double[] expectedX = {Math.PI};
        double[] expectedY = {0};

        assertArrayEquals(expectedX, actualX, EPS);
        assertArrayEquals(expectedY, actualY, EPS);
    }
}
