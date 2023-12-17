package by.your_anime_list.dao.impl;

import by.your_anime_list.bean.Anime;
import by.your_anime_list.bean.AnimeReview;
import by.your_anime_list.dao.AnimeDAO;
import by.your_anime_list.dao.exception.DAOException;
import com.google.common.primitives.Ints;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Component
@Transactional
public class HiberAnimeDAO implements AnimeDAO {

    private SessionFactory sessionFactory;

    @Override
    public boolean addAnime(Anime anime) throws DAOException {
        Session em = sessionFactory.getCurrentSession();
        em.persist(anime);
        return true;
    }

    @Override
    public Anime getAnime(int id) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Anime.class, id);
    }

    @Override
    public List<Anime> getAnime() throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT a FROM Anime a")
                .getResultList();
    }

    @Override
    public List<Anime> getAnime(int offset, int limit) throws DAOException {
        List<Anime> anime;
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM Anime a ORDER BY a.rating DESC");
        query.setMaxResults(limit);
        query.setFirstResult(offset);

        anime = query.getResultList();

        return anime;
    }

    @Override
    public int getAnimeCount() throws DAOException {
        int res;
        Session session = sessionFactory.getCurrentSession();

        long temp = (long) session.createQuery("SELECT COUNT(*) FROM Anime")
                .getSingleResult();

        res = Ints.saturatedCast(temp);
        return res;
    }

    @Override
    public List<AnimeReview> getAnimeReviews(int animeId) throws DAOException {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT r FROM AnimeReview r WHERE animeId = ?1")
                .setParameter(1, animeId)
                .getResultList();
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
