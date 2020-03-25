package databaseFunction;

import orderAndKnights.Functions;
import orderAndKnights.Knight;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class JDBCConnector {

    public JDBCConnector() {
    }

    //https://remotemysql.com/phpmyadmin/tbl_sql.php?db=qeabw7Rsms&table=JediKnight
    //    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://remotemysql.com:3306/qeabw7Rsms";
    static final String USER = "qeabw7Rsms";
    static final String PASSWORD = "v5HGLnVJDe";
    private static Statement statement;


    public static Statement StartConnection() {
        try {
//            Class.forName(JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Bangla");
            statement = connection.createStatement();
//        } catch (ClassNotFoundException e) {
//            System.out.println("wygibało DriverManager");
//            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Wygibało dane do połączenia");
            e.printStackTrace();
        }

        return statement;

    }
    //    public void add(String name, String swordColor,int power, String forceSite)

}



