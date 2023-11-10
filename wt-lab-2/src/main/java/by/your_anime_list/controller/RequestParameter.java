package by.your_anime_list.controller;

public enum RequestParameter {
    ANIME_ID("anime_id"),
    USER_ID("user_id"),
    COMMAND_NAME("command"),
    USER("user"),
    LANGUAGE("language"),
    CURR_PAGE_NAME("curr_page_name")
    ;

    private final String name;

    RequestParameter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
