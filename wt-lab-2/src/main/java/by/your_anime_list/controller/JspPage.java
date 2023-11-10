package by.your_anime_list.controller;

public enum JspPage {
    ANIME_LIST("/anime_list.jsp"),
    LOGIN_PAGE("/login.jsp"),
    REGISTER_PAGE("/register.jsp"),
    ERROR_PAGE("/error.jsp"),
    ANIME("/anime_page.jsp"),
    PROFILE("/profile.jsp"),
    ADD_ANIME("/add_anime.jsp");

    private final String name;

    JspPage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
