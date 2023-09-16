package by.lab1.task12;

public class Book {
    private String title;
    private String author;
    private int price;
    private static int edition;

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return title.equals(book.title)
                && author.equals(book.author)
                && price == book.price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + price;
        hash = 31 * hash + (title == null ? 0 : title.hashCode());
        hash = 31 * hash + (author == null ? 0 : author.hashCode());
        return hash;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": "
                + "price=" + price + ";"
                + "title=" + title + ";"
                + "author=" + author + ";";
    }
}
