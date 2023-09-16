package by.lab1.task14;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class BookCloneTest {
    @Test
    void testClone() {
        Book book = new Book("Winnie-the-Pooh", "E. H. Shepard", 100);
        Book clonedBook = null;
        try {
            clonedBook = (Book) book.clone();
        } catch (CloneNotSupportedException e) {
            fail();
        }

        assertNotSame(book, clonedBook);
        assertEquals(book, clonedBook);
    }
}
