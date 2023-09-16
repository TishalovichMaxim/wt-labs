package by.lab1.task13;

import by.lab1.task12.Book;

public class ProgrammerBook extends Book {
    private String language;
    private int level;

    public ProgrammerBook(String title, String author, int price,
                          String language, int level) {
        super(title, author, price);
        this.language = language;
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }

        ProgrammerBook programmerBook = (ProgrammerBook) o;
        return language.equals(programmerBook.language)
                && level == programmerBook.level;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = 31 * hash + level;
        hash = 31 * hash + (language == null ? 0 : language.hashCode());

        return hash;
    }

    @Override
    public String toString() {
        return super.toString()
                + "language= " + language + ";"
                + "level= " + level + ";";
    }
}
