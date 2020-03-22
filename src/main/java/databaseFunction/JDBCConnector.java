package databaseFunction;

import orderAndKnights.Functions;

import java.sql.*;
import java.util.ArrayList;

public class JDBCConnector implements Functions {

    //https://remotemysql.com/phpmyadmin/tbl_sql.php?db=qeabw7Rsms&table=JediKnight
    //    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://remotemysql.com:3306/qeabw7Rsms";
    static final String USER = "qeabw7Rsms";
    static final String PASSWORD = "v5HGLnVJDe";


    public static Statement StartConnection() {
        Statement statement = null;
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

    public void add() {
        String tableName = "JediKnight";
        String addQuery = "INSERT INTO " + tableName + "(FirstName,SwordColor,Power,ForceSite) VALUES";

        try {
            StartConnection().executeUpdate(
                    "INSERT INTO JediKnight(FirstName,SwordColor,Power,ForceSite) VALUES (\n" +
                            "'Anna', 'Oliwkowy', 666, 'GUnit');"
            );
            System.out.println("poszło");
        } catch (SQLException e) {
            System.out.println("nie poszło");
            e.printStackTrace();
        }

    }

    public ArrayList<String> get() {

        String knight = "";
        ArrayList<String> getJediArray = new ArrayList<>();
        String tableName = "JediKnight";
        String addQuery = "SELECT * FROM " + tableName;
        try {
            ResultSet resultSet = StartConnection().executeQuery(addQuery);
            while (resultSet.next()) {
//                System.out.printf("%d,%s,%s,%d,%s \n",
//                        resultSet.getInt("ID"),
//                        resultSet.getString("FirstName"),
//                        resultSet.getString("SwordColor"),
//                        resultSet.getInt("Power"),
//                        resultSet.getString("ForceSite"));

                String[] knightTable = {String.valueOf(resultSet.getInt("ID")),
                        resultSet.getString("FirstName"),
                        resultSet.getString("SwordColor"),
                        String.valueOf(resultSet.getInt("Power")),
                        resultSet.getString("ForceSite")};

                for (int i = 0; i < knightTable.length; i++) {
                    knight = knight + knightTable[i] + ",";
                }
                getJediArray.add(knight);
                knight = "";
                System.out.println(getJediArray);
            }

        } catch (SQLException e) {
            System.out.println("OOOoooo motyla noga cos nie działa");
            e.printStackTrace();
        }

        return getJediArray;
    }

    @Override
    public void refreshTable() {



    }


}
