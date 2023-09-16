package by.lab1.task16;

import java.util.Comparator;

public class Book implements Cloneable, Comparable<Book> {
    private String title;
    private String author;
    private int price;
    private long isbn;
    private static int edition;

    static class ComparatorByTitle implements Comparator<Book> {
        public int compare(Book o1, Book o2) {
            return o1.title.compareTo(o2.title);
        }
    }

    public static class ComparatorByTitleAuthor implements Comparator<Book> {
        public int compare(Book o1, Book o2) {
            int byTitle = o1.title.compareTo(o2.title);
            if (byTitle == 0) {
                return o1.author.compareTo(o2.author);
            }
            return byTitle;
        }
    }

    public static class ComparatorByAuthorTitle implements Comparator<Book> {
        public int compare(Book o1, Book o2) {
            int byAuthor = o1.author.compareTo(o2.author);
            if (byAuthor == 0) {
                return o1.title.compareTo(o2.title);
            }
            return byAuthor;
        }
    }

    static class ComparatorByAuthorTitlePrice implements Comparator<Book> {
        public int compare(Book o1, Book o2) {
            int byAuthor = o1.author.compareTo(o2.author);
            if (byAuthor == 0) {
                int byTitle = o1.title.compareTo(o2.title);
                if (byTitle == 0) {
                    return o1.price - o2.price;
                }
                return byTitle;
            }
            return byAuthor;
        }
    }

    public Book(String title, String author, int price, long isbn) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isbn = isbn;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return isbn == book.isbn
                && title.equals(book.title)
                && author.equals(book.author)
                && price == book.price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + price;
        hash = 31 * hash + (int) (isbn ^ (isbn >>> 32));
        hash = 31 * hash + (title == null ? 0 : title.hashCode());
        hash = 31 * hash + (author == null ? 0 : author.hashCode());
        return hash;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": "
                + "price=" + price + ";"
                + "title=" + title + ";"
                + "author=" + author + ";"
                + "isbn=" + isbn + ";";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Book book) {
        return Long.compare(isbn, book.isbn);
    }
}
