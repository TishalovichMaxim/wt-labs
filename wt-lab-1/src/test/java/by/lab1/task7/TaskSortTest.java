package by.lab1.task7;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class TaskSortTest {
    @Test
    public void testSortOnUnsortedArray() {
        double[] testArr = {10.4, 4.1, 5, 1, 8.44, 3.21, -10.33, 100};
        double[] resultArr = {-10.33, 1, 3.21, 4.1, 5, 8.44, 10.4, 100};
        TaskSort taskSort = new TaskSort();
        taskSort.sort(testArr);
        assertArrayEquals(resultArr, testArr);
    }

    @Test
    public void testSortOnSortedArray() {
        double[] testArr = {5, 5, 5, 5, 5, 5, 5, 5};
        double[] resultArr = {5, 5, 5, 5, 5, 5, 5, 5};
        TaskSort taskSort = new TaskSort();
        taskSort.sort(testArr);
        assertArrayEquals(resultArr, testArr);
    }

    @Test
    public void testSortOnEmptyArray() {
        double[] testArr = {};
        double[] resultArr = {};
        TaskSort taskSort = new TaskSort();
        taskSort.sort(testArr);
        assertArrayEquals(resultArr, testArr);
    }
}
