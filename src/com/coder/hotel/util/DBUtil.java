package com.coder.hotel.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;


public class DBUtil {
    private static final String DRIVER;
    private static final String USERNAME;
    private static final String PASSWORD;
    private static final String URL;
    private static final String poolClass;

    static {
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        DRIVER = bundle.getString("jdbc.driver");
        USERNAME = bundle.getString("jdbc.user");
        PASSWORD = bundle.getString("jdbc.password");
        URL = bundle.getString("jdbc.url");
        poolClass = bundle.getString("pool.class");
    }

    /**
     * 获取连接方法
     *
     * @return 连接
     */
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static DataSource getDataSource(){
        try {
            Class<?> aClass = Class.forName(poolClass);
            Object o = aClass.getConstructor().newInstance();
            Method method1 = aClass.getMethod("setDriverClassName", String.class);
            method1.invoke(o, DRIVER);
            if (aClass.getName().equals(DruidDataSource.class.getName())) {
                Method method2 = aClass.getMethod("setUrl", String.class);
                method2.invoke(o, URL);
            } else if (aClass.getName().equals(HikariDataSource.class.getName())) {
                Method method2 = aClass.getMethod("setJdbcUrl", String.class);
                method2.invoke(o, URL);
            }
            Method method3 = aClass.getMethod("setUsername", String.class);
            method3.invoke(o, USERNAME);
            Method method4 = aClass.getMethod("setPassword", String.class);
            method4.invoke(o, PASSWORD);
            return (DataSource) o;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static Connection getConnectionPool() {
        try {
            DataSource dataSource=getDataSource();
            return dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取Statement语句对象
     *
     * @param connection 连接
     * @return Statement对象
     */
    public static Statement createStatement(Connection connection) {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 执行增加删除修改的操作
     *
     * @param statement
     * @param sql
     * @return
     */
    public static int executeUpdate(Statement statement, String sql) {
        try {
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 执行增加删除和修改的操作
     *
     * @param sql 要执行的sql语句
     * @return 影响的行数
     */
    public static int executeUpdate(String sql) {
        Connection connection = getConnection();
        Statement statement = createStatement(connection);
        int i = executeUpdate(statement, sql);
        DBUtil.close(statement, connection);
        return i;
    }
    public static int executeUpdatePool(String sql) {
        Connection connection = getConnectionPool();
        Statement statement = createStatement(connection);
        int i = executeUpdate(statement, sql);
        DBUtil.close(statement, connection);
        return i;
    }

    public static int executeUpdatePrepared(String sql, Object... args) {//0...n
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            int index = 1;
            for (Object arg : args) {
                statement.setObject(index++, arg);
            }
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            DBUtil.close(statement, connection);
        }
    }
    public static int executeUpdatePreparedPool(String sql, Object... args) {//0...n
        Connection connection = getConnectionPool();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            int index = 1;
            for (Object arg : args) {
                statement.setObject(index++, arg);
            }
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            DBUtil.close(statement, connection);
        }
    }

    public static void executeBatch(String sql, List<Map<Integer,Object>> list){
        Connection connection = getConnectionPool();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            for (Map<Integer, Object> map : list) {
                for (Map.Entry<Integer, Object> entry : map.entrySet()) {
                    statement.setObject(entry.getKey(), entry.getValue());
                }
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(statement, connection);
        }
    }
    /**
     * 查询方法
     *
     * @param sql
     * @return DBObject对象
     */
    public static DBObject executeQuery(String sql) {
        Connection connection = getConnection();
        Statement statement = createStatement(connection);
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new DBObject(connection, statement, resultSet);
    }

    public static DBObject executeQueryPrepared(String sql, Object... args) {
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            int index = 1;
            for (Object arg : args) {
                statement.setObject(index++, arg);
            }
            ResultSet resultSet = statement.executeQuery();
            return new DBObject(connection, statement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void close(DBObject dbObject) {
        close(dbObject.getResultSet(), dbObject.getStatement(), dbObject.getConnection());
    }

    /**
     * 关闭连接
     *
     * @param connection
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭语句对象
     *
     * @param statement
     */
    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭结果集对象
     *
     * @param resultSet
     */
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭连接和语句对象
     *
     * @param statement
     * @param connection
     */
    public static void close(Statement statement, Connection connection) {
        close(statement);
        close(connection);
    }

    /**
     * 关闭连接、语句对象和结果集
     *
     * @param statement
     * @param connection
     * @param resultSet
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        close(resultSet);
        close(statement);
        close(connection);
    }
}
