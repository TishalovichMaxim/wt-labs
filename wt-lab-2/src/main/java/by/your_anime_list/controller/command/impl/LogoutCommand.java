package by.your_anime_list.controller.command.impl;

import by.your_anime_list.controller.JspPage;
import by.your_anime_list.controller.command.Command;
import by.your_anime_list.controller.command.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("user", null);
        AnimeListCommand animeListCommand = new AnimeListCommand();
        animeListCommand.execute(request);
        return JspPage.ANIME_LIST.getName();
    }
}
