package by.your_anime_list.service.impl;

import by.your_anime_list.bean.Anime;
import by.your_anime_list.bean.AnimeReview;
import by.your_anime_list.dao.AnimeDAO;
import by.your_anime_list.dao.exception.DAOException;
import by.your_anime_list.dao.factory.DAOFactory;
import by.your_anime_list.service.AnimeService;
import by.your_anime_list.service.exception.ServiceException;
import java.util.List;

public class AnimeServiceImpl implements AnimeService {

    @Override
    public boolean addAnime(Anime anime) throws ServiceException {
        boolean result;
        AnimeDAO animeDAO = DAOFactory.getInstance().getAnimeDAO();
        try {
            result = animeDAO.addAnime(anime);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
        return result;
    }

    @Override
    public List<Anime> getAnimeList() throws ServiceException {
        List<Anime> result;
        AnimeDAO animeDAO = DAOFactory.getInstance().getAnimeDAO();
        try {
            result = animeDAO.getAnime();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
        return result;
    }

    @Override
    public Anime getAnime(int id) throws ServiceException {
        Anime anime;
        AnimeDAO animeDAO = DAOFactory.getInstance().getAnimeDAO();
        try {
            anime = animeDAO.getAnime(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
        return anime;
    }

}
