package by.your_anime_list.controller;

import by.your_anime_list.controller.command.CommandName;

public enum RedirectAddress {
    ERROR(CommandName.NO_SUCH_COMMAND.name()),
    LOGIN_SUCCESS(CommandName.ANIME_LIST.name()),
    LOGIN_FAILED(CommandName.LOGIN.name()),
    REGISTRATION_SUCCESS(CommandName.ANIME_LIST.name()),
    REGISTRATION_FAILED(CommandName.REGISTER.name()),
    ANIME_ADD_SUCCESS(CommandName.ADD_ANIME.name()),
    ANIME_ADD_FAILED(CommandName.ADD_ANIME.name())
    ;

    private static final String BASE_ADDRESS = "/your_anime_list/controller?command=";

    private final String address;

    RedirectAddress(String address) {
        this.address = BASE_ADDRESS + address;
    }

    public String getAddress() {
        return address;
    }
}
