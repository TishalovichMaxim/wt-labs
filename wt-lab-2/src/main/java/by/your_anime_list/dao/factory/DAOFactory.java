package by.your_anime_list.dao.factory;

import by.your_anime_list.dao.AnimeDAO;
import by.your_anime_list.dao.ReviewDAO;
import by.your_anime_list.dao.UserDAO;
import by.your_anime_list.dao.impl.SQLAnimeDAO;
import by.your_anime_list.dao.impl.SQLAnimeReview;
import by.your_anime_list.dao.impl.SQLUserDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO userImpl = new SQLUserDAO();
    private final AnimeDAO animeImpl = new SQLAnimeDAO();
    private final ReviewDAO reviewImpl = new SQLAnimeReview();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return userImpl;
    }

    public AnimeDAO getAnimeDAO() {
        return animeImpl;
    }

    public ReviewDAO getReviewDAO() {
        return reviewImpl;
    }
}
