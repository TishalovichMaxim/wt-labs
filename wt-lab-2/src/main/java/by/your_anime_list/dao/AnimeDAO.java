package by.your_anime_list.dao;

import by.your_anime_list.bean.Anime;
import by.your_anime_list.dao.exception.DAOException;

import java.util.List;

public interface AnimeDAO {
    void addAnime(Anime anime) throws DAOException;

    void deleteAnime(Anime anime) throws DAOException;

    void updateAnime(Anime anime) throws DAOException;

    List<Anime> getAnime() throws DAOException;
}
