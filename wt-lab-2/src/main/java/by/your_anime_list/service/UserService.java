package by.your_anime_list.service;

import by.your_anime_list.bean.User;
import by.your_anime_list.service.exception.ServiceException;

public interface UserService {
    User login(String login, String password) throws ServiceException;
    User register(String login, String password, String confirmationPassword) throws ServiceException;
    User getUser(int userId) throws ServiceException;
}
