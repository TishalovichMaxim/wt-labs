package by.your_anime_list.dao.impl;

import by.your_anime_list.bean.AnimeReview;
import by.your_anime_list.dao.ReviewDAO;
import by.your_anime_list.dao.exception.DAOException;

import java.sql.*;

public class SQLAnimeReview implements ReviewDAO {
    @Override
    public AnimeReview addReview(AnimeReview animeReview) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        String registerUserSql = "INSERT INTO review"
                + "(user_id, anime_id, rate, comment)"
                + "values(?,?,?,?);";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(registerUserSql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, animeReview.userId());
            preparedStatement.setInt(2, animeReview.animeId());
            preparedStatement.setFloat(3, animeReview.rate());
            preparedStatement.setString(4, animeReview.comment());

            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 1) {
                try (ResultSet rs = preparedStatement.getResultSet()) {
                    return animeReview;
                }
            }
        } catch (SQLException | InterruptedException e) {
            throw new DAOException(e.getMessage());
        }
        return null;
    }

    @Override
    public AnimeReview getReview(int userId, int animeId) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        String sqlTemplate = "SELECT review.*, user.login"
                + " FROM review JOIN user ON user.id = review.user_id"
                + " WHERE user_id = %d AND anime_id = %d;";
        String sql = String.format(sqlTemplate, userId, animeId);

        AnimeReview animeReview = null;
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            if (rs.next()) {
                animeReview = new AnimeReview(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(6),
                        rs.getInt(3),
                        rs.getFloat(4),
                        rs.getString(5)
                );
            }
        } catch (SQLException | InterruptedException e) {
            throw new DAOException(e.getMessage());
        }
        return animeReview;
    }
}
