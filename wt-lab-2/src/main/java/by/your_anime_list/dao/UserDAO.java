package by.your_anime_list.dao;

import by.your_anime_list.bean.User;
import by.your_anime_list.dao.exception.DAOException;

public interface UserDAO {
    boolean signIn(String login, String password) throws DAOException;
    void register(User user) throws DAOException;
}
