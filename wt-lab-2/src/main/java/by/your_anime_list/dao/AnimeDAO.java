package by.your_anime_list.dao;

import by.your_anime_list.bean.Anime;
import by.your_anime_list.bean.AnimeReview;
import by.your_anime_list.dao.exception.DAOException;

import java.util.List;

public interface AnimeDAO {
    boolean addAnime(Anime anime) throws DAOException;

    boolean deleteAnime(Anime anime) throws DAOException;

    Anime updateAnime(Anime anime) throws DAOException;

    Anime getAnime(int id) throws DAOException;

    List<Anime> getAnime() throws DAOException;

    List<AnimeReview> getAnimeReviews(int animeId) throws DAOException;
}
