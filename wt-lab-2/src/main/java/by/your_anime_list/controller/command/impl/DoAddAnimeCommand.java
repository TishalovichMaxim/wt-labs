package by.your_anime_list.controller.command.impl;

import by.your_anime_list.bean.Anime;
import by.your_anime_list.controller.JspPage;
import by.your_anime_list.controller.RedirectAddress;
import by.your_anime_list.controller.command.Command;
import by.your_anime_list.controller.command.exception.CommandException;
import by.your_anime_list.service.AnimeService;
import by.your_anime_list.service.ImageService;
import by.your_anime_list.service.exception.ServiceException;
import by.your_anime_list.service.factory.ServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import java.io.IOException;

public class DoAddAnimeCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String animeName = request.getParameter("animeName");
        String authorName = request.getParameter("authorName");

        String animeYearString = request.getParameter("animeYear");
        int animeYear = Integer.parseInt(animeYearString);

        String imageName;

        ImageService imageService = ServiceFactory.getInstance().getImageService();
        try {
            String directoryName = request
                    .getServletContext()
                    .getRealPath("/images/");

            Part part = request.getPart("animeImage");
            imageName = imageService.uploadImage(part, directoryName, animeName);
        } catch (ServiceException | ServletException | IOException e ) {
            throw new CommandException(e.getMessage());
        }

        Anime newAnime = new Anime(
                Anime.ID_STUB,
                animeName,
                authorName,
                Anime.RATING_STUB,
                imageName,
                animeYear
        );

        AnimeService animeService = ServiceFactory
                .getInstance()
                .getAnimeService();

        boolean result;
        try {
            result = animeService.addAnime(newAnime);
        } catch (ServiceException e) {
            System.out.println("Exception in adding anime!");
            throw new CommandException(e.getMessage());
        }

        System.out.println("Anime adding result = " + result);
        return RedirectAddress.ANIME_ADD_SUCCESS.getAddress();
    }
}
