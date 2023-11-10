package by.your_anime_list.service.impl;

import by.your_anime_list.bean.Anime;
import by.your_anime_list.bean.AnimeReview;
import by.your_anime_list.dao.AnimeDAO;
import by.your_anime_list.dao.ReviewDAO;
import by.your_anime_list.dao.exception.DAOException;
import by.your_anime_list.dao.factory.DAOFactory;
import by.your_anime_list.service.ReviewService;
import by.your_anime_list.service.exception.ServiceException;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {
    @Override
    public AnimeReview getReview(int userId, int animeId) throws ServiceException {
        AnimeReview animeReview;
        ReviewDAO reviewDAO = DAOFactory
                .getInstance().getReviewDAO();

        try {
            animeReview = reviewDAO.getReview(userId, animeId);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
        return animeReview;
    }

    @Override
    public AnimeReview addReview(AnimeReview animeReview) throws ServiceException {
        AnimeReview result;
        ReviewDAO reviewDAO = DAOFactory
                .getInstance()
                .getReviewDAO();

        try {
            result = reviewDAO.addReview(animeReview);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }

        return result;
    }

    @Override
    public List<AnimeReview> getAnimeReviews(int animeId) throws ServiceException {
        List<AnimeReview> result;
        AnimeDAO animeDAO = DAOFactory.getInstance().getAnimeDAO();
        try {
            result = animeDAO.getAnimeReviews(animeId);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
        return result;
    }
}
