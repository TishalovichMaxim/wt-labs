package by.lab1.task16;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BookComparatorsTest {
    @Test
    void testComparatorByTitle() {
        Book book1 = new Book("a", "b", 50, 1);
        Book book2 = new Book("e", "b", 50, 6);
        Book book3 = new Book("c", "b", 50, 2);
        Book book4 = new Book("d", "b", 50, 5);
        Book book5 = new Book("f", "b", 50, 3);
        Book book6 = new Book("b", "b", 50, 4);
        Book book7 = new Book("g", "b", 50, 2);
        Book book8 = new Book("i", "b", 50, 5);
        Book book9 = new Book("j", "b", 50, 3);
        Book book10 = new Book("h", "b", 50, 4);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);

        books.sort(new Book.ComparatorByTitle());
        String[] expectedTitles = new String[] {
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[] actualTitles = books.stream()
                                        .map(Book::getTitle)
                                        .toArray(String[]::new);

        assertArrayEquals(expectedTitles, actualTitles);
    }

    @Test
    void testComparatorByTitleAuthor() {
        Book book1 = new Book("a", "a", 50, 1);
        Book book2 = new Book("e", "b", 50, 6);
        Book book3 = new Book("c", "c", 50, 2);
        Book book4 = new Book("d", "d", 50, 5);
        Book book5 = new Book("f", "e", 50, 3);
        Book book6 = new Book("b", "f", 50, 4);
        Book book7 = new Book("f", "g", 50, 2);
        Book book8 = new Book("c", "h", 50, 5);
        Book book9 = new Book("j", "i", 50, 3);
        Book book10 = new Book("d", "j", 50, 4);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);

        books.sort(new Book.ComparatorByTitleAuthor());

        String[] expectedTitles = new String[] {
                "a", "b", "c", "c", "d", "d", "e", "f", "f", "j"};
        String[] actualTitles = books.stream()
                                        .map(Book::getTitle)
                                        .toArray(String[]::new);

        assertArrayEquals(expectedTitles, actualTitles);

        String[] expectedAuthors = new String[] {
                "a", "f", "c", "h", "d", "j", "b", "e", "g", "i"};
        String[] actualAuthors = books.stream()
                .map(Book::getAuthor)
                .toArray(String[]::new);

        assertArrayEquals(expectedAuthors, actualAuthors);
    }

    @Test
    void testComparatorByAuthorTitle() {
        Book book1 = new Book("a", "a", 50, 1);
        Book book2 = new Book("e", "c", 50, 6);
        Book book3 = new Book("c", "c", 50, 2);
        Book book4 = new Book("d", "d", 50, 5);
        Book book5 = new Book("f", "e", 50, 3);
        Book book6 = new Book("b", "a", 50, 4);
        Book book7 = new Book("f", "g", 50, 2);
        Book book8 = new Book("c", "c", 50, 5);
        Book book9 = new Book("j", "i", 50, 3);
        Book book10 = new Book("d", "a", 50, 4);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);

        books.sort(new Book.ComparatorByAuthorTitle());

        String[] expectedAuthors = new String[] {
                "a", "a", "a", "c", "c", "c", "d", "e", "g", "i"};
        String[] actualAuthors = books.stream()
                .map(Book::getAuthor)
                .toArray(String[]::new);

        assertArrayEquals(expectedAuthors, actualAuthors);

        String[] expectedTitles = new String[] {
                "a", "b", "d", "c", "c", "e", "d", "f", "f", "j"};
        String[] actualTitles = books.stream()
                .map(Book::getTitle)
                .toArray(String[]::new);

        assertArrayEquals(expectedTitles, actualTitles);
   }

    @Test
    void testComparatorByAuthorTitlePrice() {
        Book book1 = new Book("b", "a", 1, 1);
        Book book2 = new Book("e", "c", 68, 6);
        Book book3 = new Book("c", "c", 100, 2);
        Book book4 = new Book("d", "c", 5, 5);
        Book book5 = new Book("f", "e", 59, 3);
        Book book6 = new Book("b", "a", 50, 4);
        Book book7 = new Book("f", "g", 33, 2);
        Book book8 = new Book("c", "c", 12, 5);
        Book book9 = new Book("j", "i", 2323, 3);
        Book book10 = new Book("b", "a", 0, 4);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);

        books.sort(new Book.ComparatorByAuthorTitlePrice());

        String[] expectedAuthors = new String[] {
                "a", "a", "a", "c", "c", "c", "c", "e", "g", "i"};
        String[] actualAuthors = books.stream()
                .map(Book::getAuthor)
                .toArray(String[]::new);

        assertArrayEquals(expectedAuthors, actualAuthors);

        String[] expectedTitles = new String[] {
                "b", "b", "b", "c", "c", "d", "e", "f", "f", "j"};
        String[] actualTitles = books.stream()
                .map(Book::getTitle)
                .toArray(String[]::new);

        assertArrayEquals(expectedTitles, actualTitles);

        int[] expectedPrices = new int[] {
                0, 1, 50, 12, 100, 5, 68, 33, 59, 2323};
        int[] actualPrices = books.stream()
                .mapToInt(Book::getPrice)
                .toArray();

        assertArrayEquals(expectedTitles, actualTitles);
    }
}
