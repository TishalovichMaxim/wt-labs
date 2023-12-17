package by.your_anime_list.dao.impl;

import by.your_anime_list.bean.AnimeReview;
import by.your_anime_list.dao.ReviewDAO;
import by.your_anime_list.dao.exception.DAOException;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class HiberReviewDAO implements ReviewDAO {

    private SessionFactory sessionFactory;

    @Override
    public AnimeReview addReview(AnimeReview animeReview) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        session.persist(animeReview);

        return animeReview;
    }

    @Override
    public AnimeReview getReview(int userId, int animeId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        AnimeReview animeReview;
        try {
            animeReview = (AnimeReview) session.createQuery("SELECT a FROM AnimeReview a WHERE userId = ?1 AND animeId = ?2")
                            .setParameter(1, userId)
                            .setParameter(2, animeId)
                            .getSingleResult();

        } catch ( NoResultException e ) {
            animeReview = null;
        }

        return animeReview;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
