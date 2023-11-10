package by.your_anime_list.dao;

import by.your_anime_list.bean.User;
import by.your_anime_list.dao.exception.DAOException;

public interface UserDAO {
    User signIn(String login, String password) throws DAOException;
    User register(String login, String password) throws DAOException;
    User getUser(int userId) throws DAOException;
}
