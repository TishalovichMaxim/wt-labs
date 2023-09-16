package by.lab1.task4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class Task4Test {
    @Test
    void testOutputWhenPrimesExist() {
        Task4 task4 = new Task4();
        int[] arr = {-100, 7, 234, 0, 1, -4, 13, 101, 8, 10};

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        task4.solve(arr);
        String res = outputStream.toString();
        assertEquals("1 6 7 ", res);
    }

    @Test
    void testOutputWhenNoPrimeExist() {
        Task4 task4 = new Task4();
        int[] arr = {-101, -7, 234, 0, 1, -4, 15, 100, 8, 10};

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        task4.solve(arr);
        String res = outputStream.toString();
        assertEquals("", res);
    }
}
