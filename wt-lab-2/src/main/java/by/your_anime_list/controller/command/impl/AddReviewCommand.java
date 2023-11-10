package by.your_anime_list.controller.command.impl;

import by.your_anime_list.bean.AnimeReview;
import by.your_anime_list.bean.User;
import by.your_anime_list.controller.RedirectAddress;
import by.your_anime_list.controller.RequestParameter;
import by.your_anime_list.controller.command.Command;
import by.your_anime_list.controller.command.exception.CommandException;
import by.your_anime_list.service.ReviewService;
import by.your_anime_list.service.exception.ServiceException;
import by.your_anime_list.service.factory.ServiceFactory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class AddReviewCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String rateString = request.getParameter("reviewRate");
        float rate = Float.parseFloat(rateString);

        String comment = request.getParameter("reviewComment");

        String animeIdString = request.getParameter("id");
        int animeId = Integer.parseInt(animeIdString);

        ShowAnimeCommand showAnimeCommand = new ShowAnimeCommand();

        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute(RequestParameter.USER.getName());

        try {
            ReviewService reviewService = ServiceFactory
                    .getInstance()
                    .getReviewService();

            AnimeReview newAnimeReview = new AnimeReview(
                    -1,
                    user.getId(),
                    user.getLogin(),
                    animeId,
                    rate,
                    comment
            );
            reviewService.addReview(newAnimeReview);
        } catch (ServiceException e) {
            throw new CommandException(e.getMessage());
        }
        return RedirectAddress.ANIME_ADD_SUCCESS.getAddress();
    }
}
