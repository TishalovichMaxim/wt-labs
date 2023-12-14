package by.your_anime_list.dao.impl;

import by.your_anime_list.bean.Anime;
import by.your_anime_list.bean.AnimeReview;
import by.your_anime_list.dao.AnimeDAO;
import by.your_anime_list.dao.exception.DAOException;
import com.google.common.primitives.Ints;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class HiberAnimeDAO implements AnimeDAO {

    @PersistenceContext
    private EntityManagerFactory emf;

    @Override
    public boolean addAnime(Anime anime) throws DAOException {
        try ( EntityManager em = emf.createEntityManager(); ){

            em.getTransaction().begin();

            em.persist(anime);

            em.getTransaction().commit();
        }

        return true;
    }

    @Override
    public Anime getAnime(int id) throws DAOException {
        Anime anime;
        try ( EntityManager em = emf.createEntityManager(); ) {

            em.getTransaction().begin();

            anime = em.find(Anime.class, id);

            em.getTransaction().commit();
        }

        return anime;
    }

    @Override
    public List<Anime> getAnime() throws DAOException {
        List<Anime> anime;
        try ( EntityManager em = emf.createEntityManager(); ) {

            em.getTransaction().begin();

            anime = em.createQuery("SELECT a FROM Anime a")
                    .getResultList();

            em.getTransaction().commit();
        }

        return anime;
    }

    @Override
    public List<Anime> getAnime(int offset, int limit) throws DAOException {
        List<Anime> anime;
        try ( EntityManager em = emf.createEntityManager(); ){

            em.getTransaction().begin();

            Query query = em.createQuery("FROM Anime a ORDER BY a.rating DESC");
            query.setMaxResults(limit);
            query.setFirstResult(offset);

            anime = query.getResultList();

            em.getTransaction().commit();
        }

        return anime;
    }

    @Override
    public int getAnimeCount() throws DAOException {
        int res;
        try ( EntityManager em = emf.createEntityManager(); ){

            em.getTransaction().begin();

            long temp = (long) em.createQuery("SELECT COUNT(*) FROM Anime")
                    .getSingleResult();

            res = Ints.saturatedCast(temp);

            em.getTransaction().commit();
        }

        return res;
    }

    @Override
    public List<AnimeReview> getAnimeReviews(int animeId) throws DAOException {
        List<AnimeReview> res;
        try ( EntityManager em = emf.createEntityManager(); ) {

            em.getTransaction().begin();

            res = em.createQuery("SELECT r FROM AnimeReview r WHERE animeId = ?1")
                    .setParameter(1, animeId)
                    .getResultList();

            em.getTransaction().commit();
        }

        return res;
    }
}
