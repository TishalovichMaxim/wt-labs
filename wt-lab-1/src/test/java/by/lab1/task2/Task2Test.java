package by.lab1.task2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class Task2Test {
    @Test
    void testIsPointInRectWhenPointInRect() {
        Rectangle rectangle = new Rectangle(new Point(-1, 1), 2, 2);
        Point point = new Point(0.5, 0.5);
        Task2 task2 = new Task2();
        assertTrue(task2.isPointInRect(point, rectangle));
    }

    @Test
    void testIsPointInRectWhenPointOutRect() {
        Rectangle rectangle = new Rectangle(new Point(-1, 1), 2, 2);
        Point point = new Point(2, 0);
        Task2 task2 = new Task2();
        assertFalse(task2.isPointInRect(point, rectangle));
    }

    @Test
    void testTrueOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        Task2 task2 = new Task2();
        task2.solve(new Point(3, 4));
        String res = outputStream.toString();
        assertEquals("true", res);
    }

    @Test
    void testFalseOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        Task2 task2 = new Task2();
        task2.solve(new Point(5.1, 0.5));
        String res = outputStream.toString();
        assertEquals("false", res);
    }
}
