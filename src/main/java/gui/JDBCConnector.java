package gui;

import orderAndKnights.Functions;

import java.io.File;
import java.sql.*;

public class JDBCConnector implements Functions {


    //    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://remotemysql.com:3306/qeabw7Rsms";
    static final String USER = "qeabw7Rsms";
    static final String PASSWORD = "v5HGLnVJDe";


    public Connection StartConnection() {
        Connection connection = null;
        try {
//            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Bangla");
//        } catch (ClassNotFoundException e) {
//            System.out.println("wygibało DriverManager");
//            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Wygibało dane do połączenia");
            e.printStackTrace();
        }

        return connection;
    }

    //    public void add(String name, String swordColor,int power, String forceSite)
    public void add() {
        String tableName = "JediKnight";
        String addQuery = "INSERT INTO " + tableName + "(FirstName,SwordColor,Power,ForceSite) VALUES";

        try {
            Statement statement = StartConnection().createStatement();
            statement.executeUpdate(
                    "INSERT INTO JediKnight(FirstName,SwordColor,Power,ForceSite) VALUES (\n" +
                            "'Anna', 'Oliwkowy', 666, 'GUnit');"
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("poszło");
    }

    public void get() {

    }
}
