package by.your_anime_list.dao;

import by.your_anime_list.bean.AnimeReview;
import by.your_anime_list.dao.exception.DAOException;

public interface ReviewDAO {
    AnimeReview addReview(AnimeReview animeReview) throws DAOException;
    AnimeReview getReview(int userId, int animeId) throws DAOException;
}
