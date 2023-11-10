package by.your_anime_list.service;

import by.your_anime_list.bean.Anime;
import by.your_anime_list.service.exception.ServiceException;
import java.util.List;

public interface AnimeService {
    boolean addAnime(Anime anime) throws ServiceException;
    List<Anime> getAnimeList() throws ServiceException;
    Anime getAnime(int id) throws ServiceException;
}
