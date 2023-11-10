package by.your_anime_list.service;

import by.your_anime_list.bean.AnimeReview;
import by.your_anime_list.service.exception.ServiceException;

import java.util.List;

public interface ReviewService {
    AnimeReview getReview(int userId, int animeId) throws ServiceException;
    AnimeReview addReview(AnimeReview animeReview) throws ServiceException;
    List<AnimeReview> getAnimeReviews(int animeId) throws ServiceException;
}
