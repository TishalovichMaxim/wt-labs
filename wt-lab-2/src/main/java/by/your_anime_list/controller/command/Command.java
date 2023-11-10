package by.your_anime_list.controller.command;

import by.your_anime_list.controller.JspPage;
import by.your_anime_list.controller.command.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest request) throws CommandException;
}
