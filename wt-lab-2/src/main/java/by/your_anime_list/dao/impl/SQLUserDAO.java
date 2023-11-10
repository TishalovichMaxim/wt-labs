package by.your_anime_list.dao.impl;

import by.your_anime_list.bean.User;
import by.your_anime_list.bean.UserPrivilegeRole;
import by.your_anime_list.dao.UserDAO;
import by.your_anime_list.dao.exception.DAOException;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.sql.*;

public class SQLUserDAO implements UserDAO {
    private User extractUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("id"),
                rs.getString("login"),
                UserPrivilegeRole.valueOf(
                        rs.getString("role_name")
                        .toUpperCase()),
                rs.getFloat("status_value")
        );
    }

    @Override
    public User getUser(int userId) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        String sql = "SELECT u.*, r.name AS role_name FROM user u join role r" +
                " ON u.role_id = r.id WHERE u.id = " + userId + ";";
        User user = null;
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            if (rs.next()) {
                user = extractUser(rs);
            }
        } catch (SQLException | InterruptedException e) {
            throw new DAOException(e.getMessage());
        }
        return user;
    }

    @Override
    public User signIn(String login, String password) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        String passwordHash = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();

        String sql = String.format(
                "select user.*, r.name as role_name from user "
                        + "join role r on user.role_id = r.id "
                        + "where user.login = '%s' and user.password = '%s' "
                        + "limit 1;",
                login, passwordHash);

        User user = null;
        try (Connection connection = connectionPool.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            if (rs.next()) {
                user = extractUser(rs);
            }
        } catch (SQLException | InterruptedException e) {
            throw new DAOException(e.getMessage());
        }
        return user;
    }

    @Override
    public User register(String login, String password) throws DAOException {
        int roleId = 3;
        float statusValue = -1.0f;
        String imagePath = null;
        String passwordHash = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();

        ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
        String registerUserSql = "INSERT INTO user"
                + "(login, password, role_id, status_value, image_path)"
                + "values(?,?,?,?,?);";

        try (Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.
                    prepareStatement(registerUserSql, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, login);
            preparedStatement.setString(2, passwordHash);
            preparedStatement.setInt(3, roleId);
            preparedStatement.setDouble(4, statusValue);
            preparedStatement.setString(5, imagePath);

            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected == 1) {
                try (ResultSet rs = preparedStatement.getGeneratedKeys()) {
                    if (rs.next()) {
                        int userId = rs.getInt(1);
                        return new User(userId, login, UserPrivilegeRole.USER, statusValue);
                    }
                }
            }
        } catch (SQLException | InterruptedException e) {
            throw new DAOException(e.getMessage());
        }
        return null;
    }
}
