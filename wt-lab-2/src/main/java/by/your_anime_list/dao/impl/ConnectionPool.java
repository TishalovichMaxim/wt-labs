package by.your_anime_list.dao.impl;

import by.your_anime_list.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConnectionPool {
    private static final int POOL_CAPACITY = 15;
    private static final String URL = "jdbc:mysql://localhost:3306/my_anime_list";
    private static final String USER = "root";
    private static final String PASSWORD = "somepassword";
    private static final long TIME_OUT_SECONDS = 2;
    private static ConnectionPool connectionPool = null;

    private final BlockingQueue<Connection> connections;

    public static ConnectionPool getConnectionPool() throws DAOException {
        if (connectionPool == null) {
            try {
                connectionPool = new ConnectionPool(URL, USER, PASSWORD, POOL_CAPACITY);
            } catch (SQLException e) {
                throw new DAOException(e.getMessage());
            }
        }
        return connectionPool;
    }

    public Connection getConnection() throws InterruptedException {
        System.out.println(connections.size());
        Connection connection = connections.poll(TIME_OUT_SECONDS, TimeUnit.SECONDS);
        if (connection == null) {
            return null;
        }
        return ConnectionProxy.createProxy(connection, connectionPool);
    }

    public void returnConnection(Connection connection) {
        System.out.println("Here");
        connections.add(connection);
    }

    public ConnectionPool(String url, String user, String password, int capacity) throws SQLException {
        connections = new ArrayBlockingQueue<>(capacity);
        for (int i = 0; i < capacity; i++) {
            connections.add(DriverManager.getConnection(url, user, password));
        }
    }
}
