import databaseFunction.JDBCConnector;
import gui.RunGui;


public class Main {
    public static void main(String[] args) {
        RunGui Gui = new RunGui();
        JDBCConnector jdbcConnector = new JDBCConnector();
        jdbcConnector.get();
    }


}

