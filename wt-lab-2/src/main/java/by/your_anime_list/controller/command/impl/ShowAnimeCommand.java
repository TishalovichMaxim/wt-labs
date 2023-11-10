package by.your_anime_list.controller.command.impl;

import by.your_anime_list.bean.Anime;
import by.your_anime_list.bean.AnimeReview;
import by.your_anime_list.bean.User;
import by.your_anime_list.controller.JspPage;
import by.your_anime_list.controller.command.Command;
import by.your_anime_list.controller.command.exception.CommandException;
import by.your_anime_list.service.AnimeService;
import by.your_anime_list.service.ReviewService;
import by.your_anime_list.service.exception.ServiceException;
import by.your_anime_list.service.factory.ServiceFactory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;

public class ShowAnimeCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        Anime anime;
        User user;
        AnimeReview userReview = null;
        List<AnimeReview> animeReviews;

        String animeIdParam = request.getParameter("id");
        int animeId = Integer.parseInt(animeIdParam);

        ReviewService reviewService = ServiceFactory
                .getInstance()
                .getReviewService();

        AnimeService animeService = ServiceFactory
                .getInstance()
                .getAnimeService();
        try {
            anime = animeService.getAnime(animeId);
            animeReviews = reviewService.getAnimeReviews(animeId);

            HttpSession httpSession = request.getSession();
            user = (User) httpSession.getAttribute("user");
            if (user != null) {
                userReview = reviewService.getReview(user.getId(), animeId);
            }
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage());
        }

        request.setAttribute("userReview", userReview);
        request.setAttribute("animeReviews", animeReviews);
        request.setAttribute("user", user);
        request.setAttribute("anime", anime);
        return JspPage.ANIME.getName();
    }
}
