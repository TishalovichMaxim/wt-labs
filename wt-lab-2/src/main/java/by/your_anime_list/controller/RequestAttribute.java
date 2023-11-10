package by.your_anime_list.controller;

public enum RequestAttribute {
    PRIVILEGE_ROLE("role");

    private final String name;

    RequestAttribute(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
