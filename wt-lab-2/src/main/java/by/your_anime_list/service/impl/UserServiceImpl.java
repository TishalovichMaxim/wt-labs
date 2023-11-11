package by.your_anime_list.service.impl;

import by.your_anime_list.bean.User;
import by.your_anime_list.dao.UserDAO;
import by.your_anime_list.dao.exception.DAOException;
import by.your_anime_list.dao.factory.DAOFactory;
import by.your_anime_list.service.UserService;
import by.your_anime_list.service.exception.ServiceException;

public class UserServiceImpl implements UserService {
    @Override
    public User login(String login, String password) throws ServiceException {
        CredentialsValidator credentialsValidator = new CredentialsValidator();
        if ( !credentialsValidator.validLogin(login) ) {
            return null;
        }

        if ( !credentialsValidator.validPassword(password) ) {
            return null;
        }

        User user;
        UserDAO userDAO = DAOFactory
                .getInstance().getUserDAO();

        try {
            user = userDAO.signIn(login, password);
        } catch ( DAOException e ) {
            throw new ServiceException(e.getMessage());
        }
        return user;
    }

    @Override
    public User register(String login, String password, String confirmationPassword) throws ServiceException {
        CredentialsValidator credentialsValidator = new CredentialsValidator();
        if ( !credentialsValidator.validLogin(login) ) {
            return null;
        }

        if ( !credentialsValidator.validPassword(password) || !password.equals(confirmationPassword)) {
            return null;
        }

        User user;
        UserDAO userDAO = DAOFactory
                .getInstance().getUserDAO();

        try {
            user = userDAO.register(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
        return user;
    }

    @Override
    public User getUser(int userId) throws ServiceException {
        User user;
        UserDAO userDAO = DAOFactory
                .getInstance().getUserDAO();

        try {
            user = userDAO.getUser(userId);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
        return user;
    }
}
