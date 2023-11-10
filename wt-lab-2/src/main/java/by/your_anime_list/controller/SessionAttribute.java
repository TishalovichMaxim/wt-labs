package by.your_anime_list.controller;

public enum SessionAttribute {
    LANGUAGE("lang"),
    USER("user")
    ;

    private final String name;

    SessionAttribute(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
