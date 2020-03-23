package databaseFunction;

import orderAndKnights.Functions;
import orderAndKnights.Knight;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class JDBCConnector implements Functions {

    public JDBCConnector() {
    }

    //https://remotemysql.com/phpmyadmin/tbl_sql.php?db=qeabw7Rsms&table=JediKnight
    //    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://remotemysql.com:3306/qeabw7Rsms";
    static final String USER = "qeabw7Rsms";
    static final String PASSWORD = "v5HGLnVJDe";
    private static Statement statement;
    private static File file;

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
    public void saveIntoFile(Component parent, ArrayList<Knight> objectsToSave) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Place this Data File in the safest place");
        int value = fileChooser.showSaveDialog(parent);
        if (value == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            System.out.println("Kaj sie to zapisało " + file.getAbsolutePath());
            if (file == null) {
                return;
            }
            if (!file.getName().toLowerCase().endsWith(".txt")) {
                file = new File(file.getParentFile(), file.getName() + ".txt");
            }
            try {
                PrintWriter printWriter = new PrintWriter(file, "UTF-8");
                for (Object o : objectsToSave) {
                    printWriter.write(o.toString());
                }
                printWriter.flush();
                printWriter.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
}



