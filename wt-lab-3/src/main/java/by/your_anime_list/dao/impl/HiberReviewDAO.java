package by.your_anime_list.dao.impl;

import by.your_anime_list.bean.AnimeReview;
import by.your_anime_list.dao.ReviewDAO;
import by.your_anime_list.dao.exception.DAOException;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
public class HiberReviewDAO implements ReviewDAO {

    @PersistenceContext
    private EntityManagerFactory emf;

    @Override
    public AnimeReview addReview(AnimeReview animeReview) throws DAOException {
        try ( EntityManager em = emf.createEntityManager(); ) {

            em.getTransaction().begin();

            em.persist(animeReview);

            em.getTransaction().commit();
        }

        return animeReview;
    }

    @Override
    public AnimeReview getReview(int userId, int animeId) throws DAOException {
        AnimeReview animeReview;
        try ( EntityManager em = emf.createEntityManager(); ){

            em.getTransaction().begin();

            animeReview = (AnimeReview) em.createQuery("SELECT a FROM AnimeReview a WHERE userId = ?1 AND animeId = ?2")
                            .setParameter(1, userId)
                            .setParameter(2, animeId)
                            .getSingleResult();

            em.getTransaction().commit();
        } catch ( NoResultException e ) {
            animeReview = null;
        }

        return animeReview;
    }
}
