package by.your_anime_list.dao.impl;

import by.your_anime_list.bean.Anime;
import by.your_anime_list.bean.AnimeReview;
import by.your_anime_list.dao.AnimeDAO;
import by.your_anime_list.dao.exception.DAOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLAnimeDAO implements AnimeDAO {
    @Override
    public boolean addAnime(Anime anime) throws DAOException {
        int nRowsAffected;
        String sql = "INSERT INTO anime(name, author, rating, image_path, year) " +
                "VALUES(?, ?, ?, ?, ?);";

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, anime.getName());
            preparedStatement.setString(2, anime.getAuthorName());
            preparedStatement.setFloat(3, anime.getRating());
            preparedStatement.setString(4, anime.getImagePath());
            preparedStatement.setInt(5, anime.getYear());

            nRowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException | InterruptedException e) {
            throw new DAOException(e.getMessage());
        }

        return nRowsAffected == 1;
    }

    @Override
    public boolean deleteAnime(Anime anime) throws DAOException {
        return false;
    }

    @Override
    public Anime updateAnime(Anime anime) throws DAOException {
        return null;
    }

    @Override
    public List<Anime> getAnime() throws DAOException {
        List<Anime> anime = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        String sql = "SELECT * FROM anime;";

        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                Anime currAnime = new Anime(rs.getInt("id"),
                                            rs.getString("name"),
                                            rs.getString("author"),
                                            rs.getFloat("rating"),
                                            rs.getString("image_path"),
                                            rs.getInt("year")
                                            );
                anime.add(currAnime);
            }
        } catch (SQLException | InterruptedException e) {
            throw new DAOException(e.getMessage());
        }

        return anime;
    }

    @Override
    public Anime getAnime(int id) throws DAOException {
        Anime anime = null;
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        String sql = "SELECT * FROM anime WHERE id = " + id + ";";

        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            if (rs.next()) {
                anime = new Anime(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getFloat("rating"),
                        rs.getString("image_path"),
                        rs.getInt("year")
                );
            }
        } catch (SQLException | InterruptedException e) {
            throw new DAOException(e.getMessage());
        }

        return anime;
    }

    @Override
    public List<AnimeReview> getAnimeReviews(int animeId) throws DAOException {
        List<AnimeReview> reviews = new ArrayList<>();
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        String sql = "SELECT r.id, user_id, anime_id, rate, comment, login" +
                " FROM review r JOIN user u ON r.user_id = u.id WHERE anime_id = "
                + animeId + ";";

        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                AnimeReview currAnimeReview = new AnimeReview(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("login"),
                        rs.getInt("anime_id"),
                        rs.getFloat("rate"),
                        rs.getString("comment")
                );
                reviews.add(currAnimeReview);
            }
        } catch (SQLException | InterruptedException e) {
            throw new DAOException(e.getMessage());
        }

        return reviews;
    }
}
