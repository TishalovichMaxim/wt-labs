package by.your_anime_list.controller.command.impl;

import by.your_anime_list.controller.JspPage;
import by.your_anime_list.controller.command.Command;
import by.your_anime_list.controller.command.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return JspPage.REGISTER_PAGE.getName();
    }
}
