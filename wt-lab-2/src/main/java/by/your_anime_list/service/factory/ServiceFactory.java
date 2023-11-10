package by.your_anime_list.service.factory;

import by.your_anime_list.service.AnimeService;
import by.your_anime_list.service.ImageService;
import by.your_anime_list.service.ReviewService;
import by.your_anime_list.service.UserService;
import by.your_anime_list.service.impl.AnimeServiceImpl;
import by.your_anime_list.service.impl.ImageServiceImpl;
import by.your_anime_list.service.impl.ReviewServiceImpl;
import by.your_anime_list.service.impl.UserServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final AnimeService animeService = new AnimeServiceImpl();
    private final UserService userService = new UserServiceImpl();
    private final ReviewService reviewService = new ReviewServiceImpl();
    private final ImageService imageService = new ImageServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public AnimeService getAnimeService() {
        return animeService;
    }

    public UserService getUserService() {
        return userService;
    }

    public ReviewService getReviewService() {
        return reviewService;
    }

    public ImageService getImageService() {
        return imageService;
    }
}
