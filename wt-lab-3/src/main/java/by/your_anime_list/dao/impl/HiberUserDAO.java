package by.your_anime_list.dao.impl;

import by.your_anime_list.bean.User;
import by.your_anime_list.bean.UserPrivilegeRole;
import by.your_anime_list.dao.UserDAO;
import by.your_anime_list.dao.exception.DAOException;
import com.google.common.hash.Hashing;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class HiberUserDAO implements UserDAO {

    @PersistenceContext
    private EntityManagerFactory emf;

    @Override
    public User signIn(String login, String password) throws DAOException {
        User user;
        try ( EntityManager em = emf.createEntityManager(); ) {
            em.getTransaction().begin();

            user = em.createQuery("SELECT u FROM User u WHERE u.login = ?1", User.class)
                            .setParameter(1, login)
                            .getSingleResult();

            em.getTransaction().commit();
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
        User user = null;

        try ( EntityManager em = emf.createEntityManager(); ) {

            em.getTransaction().begin();

            List<User> oldUser = em.createQuery("SELECT u FROM User u WHERE u.login = ?1", User.class)
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

                em.persist(user);
            }

            em.getTransaction().commit();
        }

        return user;
    }

    @Override
    public User getUser(int userId) throws DAOException {
        User user;
        try ( EntityManager em = emf.createEntityManager(); ) {

            em.getTransaction().begin();

            user = em.find(User.class, userId);

            em.getTransaction().commit();
        }

        return user;
    }

    @Override
    public void ban(int userId) throws DAOException {
        try ( EntityManager em = emf.createEntityManager(); ) {

            em.getTransaction().begin();

            User user = em.find(User.class, userId);
            if (user == null) {
                throw new DAOException("There is no user with id = " + userId);
            }

            user.setBanned(true);

            em.merge(user);

            em.getTransaction().commit();
        }
    }

    @Override
    public void unban(int userId) throws DAOException {
        try ( EntityManager em = emf.createEntityManager(); ) {

            em.getTransaction().begin();

            User user = em.find(User.class, userId);
            if (user == null) {
                throw new DAOException("There is no user with id = " + userId);
            }

            user.setBanned(false);

            em.merge(user);

            em.getTransaction().commit();
        }
    }
}
