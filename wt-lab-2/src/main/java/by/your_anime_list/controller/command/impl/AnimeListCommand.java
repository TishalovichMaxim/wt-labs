package by.your_anime_list.controller.command.impl;

import by.your_anime_list.bean.Anime;
import by.your_anime_list.controller.JspPage;
import by.your_anime_list.controller.command.Command;
import by.your_anime_list.controller.command.exception.CommandException;
import by.your_anime_list.service.AnimeService;
import by.your_anime_list.service.exception.ServiceException;
import by.your_anime_list.service.factory.ServiceFactory;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

public class AnimeListCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        List<Anime> animeList = null;
        AnimeService animeService = ServiceFactory.getInstance().getAnimeService();
        try {
            animeList = animeService.getAnimeList();
        } catch (ServiceException e) {
            System.out.println("Error");
        }
        request.setAttribute("animeList", animeList);
        return JspPage.ANIME_LIST.getName();
    }
}
