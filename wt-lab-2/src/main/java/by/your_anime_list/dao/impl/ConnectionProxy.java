package by.your_anime_list.dao.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

public class ConnectionProxy implements InvocationHandler {
    private final Connection connection;
    private final ConnectionPool connectionPool;

    private ConnectionProxy(Connection connection, ConnectionPool connectionPool) {
        this.connection = connection;
        this.connectionPool = connectionPool;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("close")) {
            connectionPool.returnConnection(connection);
            return null;
        }

        return method.invoke(connection, args);
    }

    public static Connection createProxy(Connection connection, ConnectionPool connectionPool) {
        ClassLoader classLoader = connection.getClass().getClassLoader();
        Class<?>[] interfaces = connection.getClass().getInterfaces();
        ConnectionProxy connectionProxy = new ConnectionProxy(connection, connectionPool);

        return (Connection) Proxy.newProxyInstance(classLoader, interfaces, connectionProxy);
    }
}
