import databaseFunction.JDBCConnector;
import gui.RunGui;


import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        RunGui Gui = new RunGui();
        JDBCConnector jdbcConnector = new JDBCConnector();
        jdbcConnector.get();
    }



}

