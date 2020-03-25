import databaseFunction.CrudFunction;
import databaseFunction.JDBCConnector;
import gui.RunGui;
import orderAndKnights.Knight;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        RunGui Gui = new RunGui();
        CrudFunction crudFunction = new CrudFunction();
//        crudFunction.add();
        crudFunction.get();


        }
    }




