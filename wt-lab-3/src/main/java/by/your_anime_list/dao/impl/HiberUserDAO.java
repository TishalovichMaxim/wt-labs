package by.your_anime_list.dao.impl;

import by.your_anime_list.bean.User;
import by.your_anime_list.bean.UserPrivilegeRole;
import by.your_anime_list.dao.UserDAO;
import by.your_anime_list.dao.exception.DAOException;
import com.google.common.hash.Hashing;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
@Transactional
public class HiberUserDAO implements UserDAO {

    private SessionFactory sessionFactory;

    @Override
    public User signIn(String login, String password) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        User user;

        try {
            user = session.createQuery("SELECT u FROM User u WHERE u.login = ?1", User.class)
                            .setParameter(1, login)
                            .getSingleResult();

        } catch (PersistenceException e) {
            user = null;
        }

        String hexPasswordHash = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();


        if (user == null || !user.getPasswordHash().equals(hexPasswordHash)) {
            return null;
        }

        return user;
    }

    @Override
    public User register(String login, String password) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        User user = null;

        List<User> oldUser = session.createQuery("SELECT u FROM User u WHERE u.login = ?1", User.class)
                .setParameter(1, login)
                .getResultList();

        if (oldUser.size() == 0) {
            String passwordHash = Hashing.sha256()
                    .hashString(password, StandardCharsets.UTF_8)
                    .toString();

            user = new User(
                    login,
                    passwordHash,
                    UserPrivilegeRole.USER,
                    5.0f,
                    false
            );

            session.persist(user);
        }

        return user;
    }

    @Override
    public User getUser(int userId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        return session.find(User.class, userId);
    }

    @Override
    public void ban(int userId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();

        User user = session.find(User.class, userId);
        if (user == null) {
            throw new DAOException("There is no user with id = " + userId);
        }

        user.setBanned(true);

        session.merge(user);
    }

    @Override
    public void unban(int userId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();

        User user = session.find(User.class, userId);
        if (user == null) {
            throw new DAOException("There is no user with id = " + userId);
        }

        user.setBanned(false);

        session.merge(user);
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
