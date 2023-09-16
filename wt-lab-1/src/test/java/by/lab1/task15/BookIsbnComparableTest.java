package by.lab1.task15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class BookIsbnComparableTest {
    @Test
    void testLessComparison() {
        Book book1 = new Book("A", "a", 1, 23);
        Book book2 = new Book("A", "a", 1, 44);
        assertTrue(book1.compareTo(book2) < 0);
    }

    @Test
    void testEqualComparison() {
        Book book1 = new Book("A", "a", 1, 23);
        Book book2 = new Book("A", "a", 1, 23);
        assertEquals(0, book1.compareTo(book2));
    }

    @Test
    void testGreaterComparison() {
        Book book1 = new Book("A", "a", 1, 23);
        Book book2 = new Book("A", "a", 1, 22);
        assertTrue(book1.compareTo(book2) > 0);
    }

    @Test
    void testDefaultSort() {
        Book[] actualArr = {
                new Book("A", "a", 1, 100),
                new Book("A", "a", 1, 3),
                new Book("A", "a", 1, 64),
                new Book("A", "a", 1, 34),
                new Book("A", "a", 1, -54),
                new Book("A", "a", 1, 2),
                new Book("A", "a", 1, 100),
                new Book("A", "a", 1, 43),
        };

        long[] expectedIsbn = {-54, 2, 3, 34, 43, 64, 100, 100};
        Arrays.sort(actualArr);

        for (int i = 0; i < actualArr.length; i++) {
            if (actualArr[i].getIsbn() != expectedIsbn[i]) {
                fail();
            }
        }
    }
}
