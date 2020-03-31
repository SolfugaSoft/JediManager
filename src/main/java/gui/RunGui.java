package gui;

import databaseFunction.JDBCConnector;

import java.awt.*;

public class RunGui {

    public RunGui() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                StartFrame startFrame = new StartFrame();
            }

        });
    }
}
