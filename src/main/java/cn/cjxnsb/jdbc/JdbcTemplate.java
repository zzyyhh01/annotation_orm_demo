package cn.cjxnsb.jdbc;

import java.sql.*;

public class JdbcTemplate {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://106.12.54.164/springcloud?useSSL=false&useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";



    private static Connection connection;

    private static Statement statement;

    private static PreparedStatement preparedStatement;

    static {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public JdbcTemplate(){
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取Statement
     * @return Statement
     */
    public static Statement getStatement(){
        try {
            if (statement == null)
                statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    /**
     * 创建preparedStatement
     * @param sql sql语句
     * @return preparedStatement
     */
    public static PreparedStatement getPreparedStatement(String sql){
        try {
            destroyPreparedStatement();
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    /**
     * 销毁PreparedStatement
     */
    public static void destroyPreparedStatement(){
        try {
            if (preparedStatement != null)
                preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
